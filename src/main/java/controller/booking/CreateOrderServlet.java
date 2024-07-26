package controller.booking;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.sql.Timestamp;
import DAO.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.FoodItem;
import modal.Orders;
import modal.Users;
import modal.Movies;
import modal.OrderDetail;
import modal.Seats;

@WebServlet(name = "CreateOrderServlet", urlPatterns = {"/createOrder"})
public class CreateOrderServlet extends HttpServlet {

    DAO dao = new DAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Users staffUser = (Users) request.getSession().getAttribute("account");
        OrderDetail OD = (OrderDetail) request.getSession().getAttribute("orderDetail");
        String customerIdStr = request.getParameter("userID");
        int movieId = OD.getScreeningID().getMovieID().getMovieID();

        Users customer = null;
        Integer customerId = null;
        if (customerIdStr != null && !customerIdStr.equals("null")) {
            customerId = Integer.parseInt(customerIdStr);
            List<Users> customerList = dao.getUserById(customerId);
            if (customerList != null && !customerList.isEmpty()) {
                customer = customerList.get(0);
            } else {
                customer = new Users();
                customer.setUserID(0); // set to 0 for guests
            }
        } else {
            customer = new Users();
            customer.setUserID(0); // set to 0 for guests
        }

        Orders order = new Orders();
        int quantitySeat = OD.getSelectedSeats().split(", ").length;
        int totalPrice = Integer.parseInt(OD.getTotalPrice());
        order.setStaffID(staffUser.getUserID());
        order.setUserID(customer);
        order.setQuantity(quantitySeat);
        order.setAllPrice(String.valueOf(totalPrice));

        // Save the order to get the generated order ID
        dao.saveOrder(order, movieId);
        int orderID = dao.getOrderRecentlyAdded(); // Get the correct order ID after saving
        order.setOrderID(orderID); // Set the orderID to the order object

        Timestamp purchaseDate = new Timestamp(System.currentTimeMillis());
        String selectedSeats = OD.getSelectedSeats();
        String[] seatArray = selectedSeats.split(", ");
        List<Seats> seats = new ArrayList<>();

        for (String seatNumber : seatArray) {
            dao.insertSeats(OD.getScreeningID().getScreeningID(), seatNumber);
            seats.add(dao.getSeatByScreeningIDAndSeatNumber(OD.getScreeningID().getScreeningID(), seatNumber));
        }
        
        int totalCostWithFood = 0;
        if (OD.getFoodMap() != null) {
            for (Map.Entry<FoodItem, Integer> entry : OD.getFoodMap().entrySet()) {
                FoodItem foodItem = entry.getKey();
                int quantity = entry.getValue();
                totalCostWithFood += foodItem.getPrice() * quantity;
                dao.insertFoodItem(orderID, foodItem.getFoodItemID(), quantity);
            }
        }
        totalPrice += totalCostWithFood; // Tổng tiền bao gồm cả đồ ăn
        order.setAllPrice(String.valueOf(totalPrice)); // Cập nhật tổng tiền vào đối tượng order
        dao.updateOrderTotalPrice(orderID, totalPrice); // Update the total price in the Orders table

        for (Seats seat : seats) {
            if (OD.getIsVip() == 1) {
                dao.insertTickets(customerId, OD.getScreeningID().getMovieID().getMovieID(),
                        OD.getScreeningID().getTheaterID().getCinemaID().getCinemaID(), "85000",
                        purchaseDate, seat.getSeatID(), orderID);
            } else {
                dao.insertTickets(customerId, OD.getScreeningID().getMovieID().getMovieID(),
                        OD.getScreeningID().getTheaterID().getCinemaID().getCinemaID(), "75000",
                        purchaseDate, seat.getSeatID(), orderID);
            }
        }

        dao.updatePointOfUser(customer.getUserID(), OD.getPoint());
        Movies movie = dao.getMovieById(movieId);
        
        request.getSession().setAttribute("order", order);
        
        response.sendRedirect("checkTicket?orderID=" + orderID);
    }
}