package controller;

import DAO.Movie;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import modal.Users;
import util.Email;

import java.io.IOException;
import java.util.Random;

@WebServlet(name = "verifyServlet", value = "/verify")
public class verifyServlet extends HttpServlet {
    int code = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random random = new Random();
        code = random.nextInt(900000) + 100000;

        Users u = (Users)request.getSession().getAttribute("user");
        Email.sendEmail(u.getEmail(), "Code", "Your code is: "+code);
        request.getRequestDispatcher("/WEB-INF/views/verify.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Movie dao = new Movie();
        if(Integer.parseInt(request.getParameter("otp-code")) == code){
            Users u = (Users)request.getSession().getAttribute("user");
            request.getSession().removeAttribute("user");
            dao.add(u);
            request.getRequestDispatcher("/WEB-INF/views/signIn.jsp").forward(request, response);
        }else{
            request.setAttribute("error", "Invalid code");
            request.getRequestDispatcher("/WEB-INF/views/verify.jsp").forward(request, response);
        }
    }
}