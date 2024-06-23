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

import java.util.List;
import modal.MovieGenres;
import modal.Movies;
import modal.Users;

import java.sql.Date;

/**
 *
 * @author baoquoc
 */
@WebServlet(name = "updateMovieServlet", urlPatterns = {"/update_movie"})
@MultipartConfig
public class updateMovieServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateMovieServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateMovieServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Users u = (Users) request.getSession().getAttribute("admin");
        if (u == null || u.getRoleID().getRoleID() != 1) {
            response.sendRedirect("admin");
        } else {
            DAO dao = new DAO();
            String movieID = request.getParameter("movieID");
            Movies m = dao.getMovieByID(Integer.parseInt(movieID));
            List<MovieGenres> list = dao.getMovieGenres(Integer.parseInt(movieID));
            String genresID = "";
            for (MovieGenres mg : list) {
                genresID += mg.getGenreID().getGenreID() + ", ";
            }

            request.setAttribute("genresID", genresID);
            request.setAttribute("movie", m);
            request.getRequestDispatcher("/WEB-INF/views/admin-views/updateMovie.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        String title = request.getParameter("movieTitle");
        String description = request.getParameter("description").trim();
        Date releaseDate = Date.valueOf(request.getParameter("releaseDate"));
        String duration = request.getParameter("duration");
        String genres = request.getParameter("selectedGenres");
        String trailerUrl = request.getParameter("trailerUrl");
        String movieID = request.getParameter("movieID");
        String posterImage = request.getParameter("posterImage");

        try {
            //check if date is 30 days from now will return a error message
            Date currentDate = new Date(System.currentTimeMillis());
            long diff = currentDate.getTime() - releaseDate.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            if (diffDays > 30) {
                request.setAttribute("message", "Release date must be at most 30 days before now");
                request.getRequestDispatcher("/WEB-INF/views/admin-views/updateMovie.jsp").forward(request, response);
            }else {
                dao.updateMovieByID(title, description, releaseDate, posterImage, Integer.parseInt(duration), trailerUrl, Integer.parseInt(movieID));

                dao.deleteMovieGenreByMovieID(Integer.parseInt(movieID));
                String[] genreList = genres.split(", ");

                for (String genre : genreList) {
                    dao.insertMovieGenre(Integer.parseInt(genre), Integer.parseInt(movieID));
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
