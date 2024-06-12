package controller.admin;

import DAO.DAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import modal.Users;

@WebServlet(name = "adminLoginServlet", value = "/admin")
public class adminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/admin-views/adminLogin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        DAO d = new DAO();
        Users user = d.checkLoginAdmin(username, password);
        if(user == null){
            request.getSession().setAttribute("error", "Username and password incorrect!");
            request.getRequestDispatcher("/WEB-INF/views/admin-views/adminLogin.jsp").forward(request, response);
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("admin", user);
            response.sendRedirect("home_admin");
        }
    }
}