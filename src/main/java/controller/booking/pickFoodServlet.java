package controller.booking;

import DAO.DAO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import modal.FoodItem;

@WebServlet(name = "pickFoodServlet", urlPatterns = {"/pickFood"})
public class pickFoodServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet pickFoodServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet pickFoodServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String movieTitle = request.getParameter("movieTitle");
        String cinemaName = request.getParameter("cinemaName");
        String screeningStartTimeStr = request.getParameter("screeningStartTime");
        String screeningEndTimeStr = request.getParameter("screeningEndTime");
        String theaterNumber = request.getParameter("theaterNumber");
        String selectedSeats = request.getParameter("selectedSeats");
        String totalPrice = request.getParameter("totalPrice");


        request.setAttribute("movieTitle", movieTitle);
        request.setAttribute("cinemaName", cinemaName);
        request.setAttribute("screeningStartTime", screeningStartTimeStr);
        request.setAttribute("screeningEndTime", screeningEndTimeStr);
        request.setAttribute("theaterNumber", theaterNumber);
        request.setAttribute("selectedSeats", selectedSeats);
        request.setAttribute("totalPrice", totalPrice);

        DAO dao = new DAO();
        List<FoodItem> foodItems = dao.getFood();
        request.setAttribute("foodItems", foodItems);

        request.getRequestDispatcher("/WEB-INF/views/pickFood.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
