/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import DAO.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import modal.Cinemas;
import modal.Movies;
import modal.ScreeningTimes;
import modal.Theaters;
import util.CinemaConfig;

/**
 *
 * @author Dan
 */
@WebServlet(name = "updateNewSlot", urlPatterns = {"/updateNewSlot"})
public class updateNewSlot extends HttpServlet {

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
            out.println("<title>Servlet updateNewSlot</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateNewSlot at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        int sid = Integer.parseInt(request.getParameter("id"));
        DAO dao = new DAO();
        ScreeningTimes screeningTimes = dao.getAllScreeningById(sid);
        Movies movie = dao.getMovieByID(screeningTimes.getMovieId());
        String movieName = movie.getTitle();

        List<Cinemas> cinemases = dao.getAllCinemas();
        List<Movies> listAllMovies = dao.getMovie();
        request.setAttribute("sid", sid);
        request.setAttribute("listAllMovies", listAllMovies);
        request.setAttribute("cinemases", cinemases);
        request.setAttribute("movieName", movieName);
        request.setAttribute("duration", movie.getDuration());
        request.setAttribute("screeningTimes", screeningTimes);
        Timestamp timestampStart = screeningTimes.getStartTime();
        Timestamp timestampEnd = screeningTimes.getEndTime();
        // Chuyển đổi Timestamp sang Date
        Date date = new Date(timestampStart.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        // Chuyển đổi Timestamp sang String theo định dạng mong muốn
        String formattedTimeStart = sdf.format(timestampStart);
        String formattedTimeEnd = sdf.format(timestampEnd);
        // In ra thời gian theo định dạng HH:mm:ss
//        System.out.println(formattedTimeStart);
//        System.out.println(formattedTimeEnd);
        request.setAttribute("date", date);
        request.setAttribute("formattedTimeStart", formattedTimeStart);
        request.setAttribute("formattedTimeEnd", formattedTimeEnd);

        request.getRequestDispatcher("/WEB-INF/views/admin-views/updateNewSlot.jsp").forward(request, response);
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
        int sid = Integer.parseInt(request.getParameter("sid"));
        String theaterName = request.getParameter("theaterName");
        System.out.println(theaterName);
        String cinema = request.getParameter("cinemaSelect");

        String movieDateStr = request.getParameter("dateInput");
        String theaterNumber = request.getParameter("theaterNumber");
        String startTime = request.getParameter("startTimeInput");
        String endTime = request.getParameter("endTimeInput");

        CinemaConfig cinemaConfig = new CinemaConfig();
        int locationID = cinemaConfig.getLocationIdByCinemaName(cinema);
        int[] dimensions = cinemaConfig.getRowsAndColumns(cinema, Integer.parseInt(theaterNumber));
        int rows = dimensions[0];
        int columns = dimensions[1];

        DAO dao = new DAO();
        Movies movies = dao.getMovieByName(theaterName);
        int movieID = movies.getMovieID();
        //response.getWriter().print("locationID: " + locationID);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date movieDateUtil;
        try {
            movieDateUtil = format.parse(movieDateStr);
        } catch (ParseException e) {
            response.getWriter().print("Error: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        java.sql.Date movieDateSql = new java.sql.Date(movieDateUtil.getTime());

        //lay ra slot chieu phim muon nhat
        java.sql.Timestamp endTimeLastestSlot = dao.getLastestEndTimeOfTheater(cinema, movieDateSql, Integer.parseInt(theaterNumber));

        // Assuming movieDateStr is a String representing a date in the format "yyyy-MM-dd"
        String startTimeStr = movieDateStr + " " + startTime + ":00";
        String endTimeStr = movieDateStr + " " + endTime + ":00";
        java.sql.Timestamp startTimeTimestamp;
        java.sql.Timestamp endTimeTimestamp;
        try {
            startTimeTimestamp = java.sql.Timestamp.valueOf(startTimeStr);
            endTimeTimestamp = java.sql.Timestamp.valueOf(endTimeStr);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            response.getWriter().print("Error: " + e.getMessage());
            // Handle the exception. For example, you might want to return an error response.
            return;
        }
        Movies movie = dao.getMovieByID(movieID);
        // Check start time of new slot have to later than end time of lastest slot
        if (endTimeLastestSlot != null && endTimeLastestSlot.after(startTimeTimestamp)) {
            request.setAttribute("message", "Start time of new slot have to later than end time of lastest slot is " + endTimeLastestSlot);
            request.setAttribute("movie", movie);
            List<Movies> listAllMovies = dao.getMovie();
            List<Cinemas> cinemases = dao.getAllCinemas();
            request.setAttribute("cinemases", cinemases);
            request.setAttribute("listAllMovies", listAllMovies);

            request.getRequestDispatcher("WEB-INF/views/admin-views/updateNewSlot.jsp").forward(request, response);
            return;
        } else {
            //insert new cinemas
            dao.insertNewCinemas(cinema, Date.valueOf(movieDateStr), locationID);
            //get id of cinemas recently inserted
            Cinemas c = dao.getCinemasRecentlyAdded();

            // //insert new theaters
            dao.insertTheaters(c.getCinemaID(), Integer.parseInt(theaterNumber), rows, columns);
            // //get id of theaters recently inserted
            int theaterID = dao.getTheaterIDRecentlyAdded();

            //update screeningTimes
//            System.out.println(theaterID);
//             System.out.println(movieID);
//              System.out.println(startTimeTimestamp);
//               System.out.println(endTimeTimestamp);
//                System.out.println(sid);
            dao.updateScreeningTimes(theaterID, movieID, startTimeTimestamp, endTimeTimestamp, sid);
            response.sendRedirect("home_admin");
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
