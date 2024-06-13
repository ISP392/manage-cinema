package controller.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import modal.Users;

@WebServlet(name = "listMovieServlet", value = "/list_movie")
public class listMovieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users u = (Users) request.getSession().getAttribute("admin");
        if( u == null || u.getRoleID().getRoleID() != 1 ){
            response.sendRedirect("admin");
        }else{
        request.getRequestDispatcher("/WEB-INF/views/admin-views/listMovie.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}