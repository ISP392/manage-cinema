/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.payment;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DAO.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.FoodItem;
import modal.OrderDetail;
import modal.Seats;
import modal.Users;

/**
 *
 * @author baoquoc
 */
@WebServlet(name = "PaymentComplete", urlPatterns = { "/payment_complete" })
public class PaymentComplete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Users user = (Users) request.getSession().getAttribute("account");
        OrderDetail OD = (OrderDetail) request.getSession().getAttribute("orderDetail");
        if (user == null || OD == null) {
            response.sendRedirect("home");
            return;
        } else {
            DAO dao = new DAO();
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
            if (OD.getVoucherID() != null) {
                dao.insertOrder(user.getUserID(), OD.getScreeningID().getMovieID().getMovieID(), count,
                        OD.getTotalPrice(),
                        OD.getVoucherID().getVoucherID());
                // update quantity of voucher
                dao.updateQuantityOfVoucher(OD.getVoucherID().getVoucherID());
            } else {
                dao.insertOrderWithVoucherIDNull(user.getUserID(), OD.getScreeningID().getMovieID().getMovieID(), count,
                        OD.getTotalPrice());
            }
            int orderID = dao.getOrderRecentlyAdded();
            // get all food items from OD.foodMap
            if (OD.getFoodMap() != null) {
                for (FoodItem foodItem : OD.getFoodMap().keySet()) {
                    dao.insertFoodItem(orderID, foodItem.getFoodItemID(), OD.getFoodMap().get(foodItem));
                }
            }

            // insert tickets
            for (Seats seat : seats) {
                if (OD.getIsVip() == 1) {
                    dao.insertTickets(user.getUserID(), OD.getScreeningID().getMovieID().getMovieID(),
                            OD.getScreeningID().getTheaterID().getCinemaID().getCinemaID(), "85000",
                            purchaseDate, seat.getSeatID(), orderID);
                } else {
                    dao.insertTickets(user.getUserID(), OD.getScreeningID().getMovieID().getMovieID(),
                            OD.getScreeningID().getTheaterID().getCinemaID().getCinemaID(), "75000",
                            purchaseDate, seat.getSeatID(), orderID);
                }
            }
            // update point
            dao.updatePointOfUser(user.getUserID(), OD.getPoint());
            response.sendRedirect("home");

        }
    }
}
