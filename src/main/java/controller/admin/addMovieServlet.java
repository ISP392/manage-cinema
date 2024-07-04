/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import DAO.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import modal.Movies;
import modal.Users;

/**
 *
 * @author baoquoc
 */
@WebServlet(name = "addMovieServlet", urlPatterns = { "/add_movie" })
@MultipartConfig
public class addMovieServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addMovieServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addMovieServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Users u = (Users) request.getSession().getAttribute("admin");
        if (u == null || u.getRoleID().getRoleID() != 1) {
            response.sendRedirect("admin");
        } else {
            request.getRequestDispatcher("/WEB-INF/views/admin-views/addMovie.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        String title = request.getParameter("movieTitle");
        String description = request.getParameter("description");
        Date releaseDate = Date.valueOf(request.getParameter("releaseDate"));
        String duration = request.getParameter("duration");
        String genres = request.getParameter("selectedGenres");
        String trailerUrl = request.getParameter("trailerUrl");
        String posterImage = request.getParameter("poster");

        try {
            // check if date is 30 days from now will return a error message
            Date currentDate = new Date(System.currentTimeMillis());
            long diff = currentDate.getTime() - releaseDate.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            if (diffDays > 30) {
                request.setAttribute("message", "Release date must be at most 30 days before now");
                request.getRequestDispatcher("/WEB-INF/views/admin-views/addMovie.jsp").forward(request, response);
            } else {
                dao.insertNewMovie(title, description, releaseDate, posterImage, Integer.parseInt(duration),
                        trailerUrl);
                Movies movie = dao.getMovieRecentlyAdded();
                String[] genreList = genres.split(", ");
                for (String genre : genreList) {
                    dao.insertMovieGenre(Integer.parseInt(genre), movie.getMovieID());
                }
                response.sendRedirect("list_movie");
            }

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
