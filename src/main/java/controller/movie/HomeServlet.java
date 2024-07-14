/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.movie;

import DAO.DAO;

import java.io.IOException;
<<<<<<< HEAD

=======
import java.io.PrintWriter;
import java.io.IOException;
>>>>>>> e5f9b2bdaeb66f1668e9988fde80f35c950a7ed3
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

import modal.Movies;

/**
 * @author ACER
 */
@WebServlet(name = "HomeServlet", urlPatterns = { "/home" })
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO d = new DAO();
        List<Movies> movies = d.getMovie(true);
        request.setAttribute("movies", movies);
        // remove session orderDetail
        request.getSession().removeAttribute("orderDetail");

        request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
    }

}
