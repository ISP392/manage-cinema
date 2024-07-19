package controller.booking;

import DAO.DAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import modal.FoodItem;
import modal.Movies;
import modal.OrderDetail;
import modal.ScreeningTimes;
import modal.Users;

@WebServlet(name = "pickFoodServlet", urlPatterns = {"/pickFood"})
public class pickFoodServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Users user = (Users) request.getSession().getAttribute("account");
        if (user == null) {
            response.sendRedirect("home");
            return;
        } else {
            String movieID = request.getParameter("movieID");
            String cinemaName = request.getParameter("cinemaName");
            String screeningStartTimeStr = request.getParameter("screeningStartTime");
            String screeningEndTimeStr = request.getParameter("screeningEndTime");
            String theaterNumber = request.getParameter("theaterNumber");
            String selectedSeats = request.getParameter("selectedSeats");
            String totalPrice = request.getParameter("totalPrice");
            String screeningID = request.getParameter("screeningID");
            String isVip = request.getParameter("isVip");

            DAO dao = new DAO();
            Movies movie = dao.getMovieByID(Integer.parseInt(movieID));
            ScreeningTimes screening = dao.getScreeningTimesByID(Integer.parseInt(screeningID));

            // create session to store screeningID, selectedSeats, totalPrice
            OrderDetail OD = new OrderDetail(screening, selectedSeats, totalPrice);
            OD.setIsVip(Integer.parseInt(isVip));
            request.getSession().setAttribute("orderDetail", OD);

            request.setAttribute("movie", movie);
            request.setAttribute("cinemaName", cinemaName);
            request.setAttribute("screeningStartTime", screeningStartTimeStr);
            request.setAttribute("screeningEndTime", screeningEndTimeStr);
            request.setAttribute("theaterNumber", theaterNumber);
            request.setAttribute("selectedSeats", selectedSeats);
            request.setAttribute("totalPrice", totalPrice);

            List<FoodItem> foodItems = dao.getFood();
            request.setAttribute("foodItems", foodItems);

            request.getRequestDispatcher("/WEB-INF/views/pickFood.jsp").forward(request, response);

        }
    }

}
