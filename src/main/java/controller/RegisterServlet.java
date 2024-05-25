package controller;

import DAO.Movie;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import modal.Users;
import util.Email;
import util.Encrypt;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String displayName = request.getParameter("name");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password"); 
        try{
            password = Encrypt.toSHA1(password);
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        Movie dao = new Movie();
        if(dao.checkUsername(username)){
            request.setAttribute("errorUsername", "Username is already existed");
            request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
        }else if(dao.checkEmail(email)){
            request.setAttribute("errorEmail", "Email is already existed");
            request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
        }

        Users u = new Users(displayName, username, password, email);
        HttpSession session = request.getSession();
        session.setAttribute("user", u);
        response.sendRedirect("verify");
    }
}