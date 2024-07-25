package controller.booking;

import java.io.IOException;
import java.util.List;

import DAO.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;
import modal.FoodItem;
import modal.Orders;
import modal.Users;
import modal.Movies;
import modal.OrderDetail;
import modal.OrderFoodItem;
import modal.Seats;

@WebServlet(name = "CreateOrderServlet", urlPatterns = {"/createOrder"})
public class CreateOrderServlet extends HttpServlet {

    DAO dao = new DAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Users staffUser = (Users) request.getSession().getAttribute("account");
        OrderDetail OD = (OrderDetail) request.getSession().getAttribute("orderDetail");
        int customerId = Integer.parseInt(request.getParameter("userID"));
        int movieId = OD.getScreeningID().getMovieID().getMovieID();

        Users customer = null;
        if (customerId != 0) {
            // Retrieve the customer user and set it in the order
            List<Users> customerList = dao.getUserById(customerId);
            if (customerList == null || customerList.isEmpty()) {
                response.sendRedirect("chooseCustomer.jsp?error=Customer not found");
                return;
            }
            customer = customerList.get(0);
        } else {
            // Handle guest user case
            customer = new Users();
            customer.setUserID(0); // Set a special value for guest user
        }
        Orders order = new Orders();

        int quantitySeat = OD.getSelectedSeats().split(", ").length;
        int totalPrice = Integer.parseInt(OD.getTotalPrice());
        order.setStaffID(staffUser.getUserID());
        order.setUserID(customer);
        order.setQuantity(quantitySeat);

        // Save the order to the database and get the generated order ID
        Timestamp purchaseDate = new Timestamp(System.currentTimeMillis());
        String selectedSeats = OD.getSelectedSeats();
        String[] seatArray = selectedSeats.split(", ");
        List<Seats> seats = new ArrayList<>();
        int count = 0;

        for (String seatNumber : seatArray) {
            count++;
            dao.insertSeats(OD.getScreeningID().getScreeningID(), seatNumber);
            seats.add(dao.getSeatByScreeningIDAndSeatNumber(OD.getScreeningID().getScreeningID(), seatNumber));
        }
        int orderID = dao.getOrderRecentlyAdded();
        // get all food items from OD.foodMap
        if (OD.getFoodMap() != null) {
            for (FoodItem foodItem : OD.getFoodMap().keySet()) {
                dao.insertFoodItem(orderID, foodItem.getFoodItemID(), OD.getFoodMap().get(foodItem));
            }
        }
        int totalCostWithFood = 0;
        for (Map.Entry<FoodItem, Integer> entry : OD.getFoodMap().entrySet()) {
            FoodItem foodItem = entry.getKey();
            int quantity = entry.getValue();
            totalCostWithFood += foodItem.getPrice() * quantity;
        }
        totalPrice += totalCostWithFood;

        order.setAllPrice(String.valueOf(totalPrice));

        // insert tickets
        for (Seats seat : seats) {
            if (OD.getIsVip() == 1) {
                dao.insertTickets(customer.getUserID(), OD.getScreeningID().getMovieID().getMovieID(),
                        OD.getScreeningID().getTheaterID().getCinemaID().getCinemaID(), "85000",
                        purchaseDate, seat.getSeatID(), orderID);
            } else {
                dao.insertTickets(customer.getUserID(), OD.getScreeningID().getMovieID().getMovieID(),
                        OD.getScreeningID().getTheaterID().getCinemaID().getCinemaID(), "75000",
                        purchaseDate, seat.getSeatID(), orderID);
            }
        }
        // update point
        dao.updatePointOfUser(customer.getUserID(), OD.getPoint());
        Movies movie = dao.getMovieById(movieId);  // Assuming there's a method to get movie by ID
        dao.saveOrder(order, movieId);

        // Set the order in the session
        request.getSession().setAttribute("order", order);

        // Redirect to the checkTicket page with the orderId
        response.sendRedirect("checkTicket");
    }
}
