package controller.account;

import DAO.DAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import modal.Users;

import java.io.IOException;

@WebServlet(name = "AccountServlet", value = "/account")
public class AccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users user = (Users) request.getSession().getAttribute("account");
        if (user == null) {
            response.sendRedirect("signin");
        } else {
            request.setAttribute("colorMain", "white");
            request.setAttribute("backgroundColorMain", "red");

            request.setAttribute("colorSecond", "#666");
            request.setAttribute("backgroundColorSecond", "#bfd2d9");
            DAO dao = new DAO();
            int userId = user.getUserID(); // Assume getUserID() method exists in Users class
            String rank = dao.getRank(userId);
            String totalSpending = dao.gettotalSpending(userId);
            String point = dao.getPoint(userId);

            request.setAttribute("userRank", rank);
            request.setAttribute("totalSpending", totalSpending);
            request.setAttribute("point", point);

            request.getRequestDispatcher("/WEB-INF/views/informationUser.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
