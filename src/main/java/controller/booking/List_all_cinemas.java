/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.booking;

import DAO.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

import java.time.LocalDate;
import java.util.*;

import modal.*;

/**
 *
 * @author baoquoc
 */
@WebServlet(name = "List_all_cinemas", urlPatterns = {"/list_all_cinemas"})
public class List_all_cinemas extends HttpServlet {

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
            out.println("<title>Servlet List_all_cinemas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet List_all_cinemas at " + request.getContextPath() + "</h1>");
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
        DAO dao = new DAO();
        String date = request.getParameter("date");
        String cinema = request.getParameter("cinemaName");
        String locationID = request.getParameter("locationID");

        // Redirect sớm nếu thiếu tham số
        if (date == null || locationID == null) {
            response.sendRedirect("home");
            return;
        }

        Timestamp startTime = new Timestamp(System.currentTimeMillis());
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        String dateNow = year + "-" + month + "-" + date;
        List<Cinemas> cinemas = new ArrayList<>();

        if (cinema == null || cinema.isEmpty()) {
            cinemas = dao.getAllCinemasByLocationID(Integer.parseInt(locationID));
            if (cinemas.isEmpty()) {
                request.setAttribute("error", "Vị trí này chưa có rạp nào");
                request.setAttribute("locationID", Integer.parseInt(locationID));
                request.setAttribute("locations", dao.getAllDirection());
                request.getRequestDispatcher("/WEB-INF/views/cinemas/list_all_cinemas.jsp").forward(request, response);
                return;
            } else {
                cinema = cinemas.get(0).getName();
            }
        } else {
            cinemas = dao.getAllCinemasByLocationID(Integer.parseInt(locationID));
        }

        java.sql.Date sqlDate = java.sql.Date.valueOf(dateNow);
        List<Movies> movies = dao.getMovieByMovieDateAndCinemaName(sqlDate, cinema);
        Map<Movies, List<ScreeningTimes>> moviesMap = new HashMap<>();

        for (Movies movie : movies) {
            String movieTitle = movie.getTitle();
            List<ScreeningTimes> screeningTimes = dao.getScreeningTimeOfMovieByMovieDateAndCinemaName(sqlDate, cinema, movie.getMovieID(), startTime);
            Collections.sort(screeningTimes, new Comparator<ScreeningTimes>() {
                @Override
                public int compare(ScreeningTimes st1, ScreeningTimes st2) {
                    return st1.getStartTime().compareTo(st2.getStartTime());
                }
            });

            if (moviesMap.containsKey(movie)) {
                moviesMap.get(movie).addAll(screeningTimes);
            } else {
                moviesMap.put(movie, new ArrayList<>(screeningTimes));
            }
        }

        List<GenresByMovie> GBM = new ArrayList<>();
        for (Movies movie : movies) {
            List<MovieGenres> mg = dao.getMovieGenres(movie.getMovieID());
            for (MovieGenres m : mg) {
                GBM.add(new GenresByMovie(m.getMovieID().getMovieID(), m.getGenreID().getName()));
            }
        }

        request.setAttribute("cinema", cinema);
        request.setAttribute("cinemas", cinemas);
        request.setAttribute("locations", dao.getAllDirection());
        request.setAttribute("locationID", Integer.parseInt(locationID));
        request.setAttribute("GenresByMovie", GBM);
        request.setAttribute("moviesMap", moviesMap);

        request.getRequestDispatcher("/WEB-INF/views/cinemas/list_all_cinemas.jsp").forward(request, response);
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
        processRequest(request, response);
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
