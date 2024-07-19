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
        String movieName = request.getParameter("movieName");
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

        java.sql.Timestamp startTimeEarlySlot = null;
        java.sql.Timestamp endTimeEarlySlot = null;
        java.sql.Timestamp startTimeLastestSlot = null;
        List<ScreeningTimes> list = dao.getAllFlimDay(movieDateStr, Integer.parseInt(theaterNumber));

        if (!list.isEmpty()) {
            for (int i = 0; i <= 1; i++) {

                startTimeEarlySlot = list.get(0).getStartTime();
                endTimeEarlySlot = list.get(0).getEndTime();

            }

            if (list.size() == 1) {
                startTimeLastestSlot = list.get(0).getStartTime();
            }
            if (list.size() > 1) {
                startTimeLastestSlot = list.get(1).getStartTime();
            }

        }
        Movies movies = dao.getMovieByName(movieName);
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
            ScreeningTimes screeningTimes = dao.getAllScreeningById(sid);
            Movies movie = dao.getMovieByID(screeningTimes.getMovieId());
            String movieName1 = movie.getTitle();

            List<Cinemas> cinemases = dao.getAllCinemas();
            List<Movies> listAllMovies = dao.getMovie();
            request.setAttribute("sid", sid);
            request.setAttribute("listAllMovies", listAllMovies);
            request.setAttribute("cinemases", cinemases);
            request.setAttribute("movieName", movieName1);
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

            request.setAttribute("date", date);
            request.setAttribute("formattedTimeStart", formattedTimeStart);
            request.setAttribute("formattedTimeEnd", formattedTimeEnd);
            request.setAttribute("messageError", "Eror input day");
            request.getRequestDispatcher("WEB-INF/views/admin-views/updateNewSlot.jsp").forward(request, response);
            // Handle the exception. For example, you might want to return an error response.
            return;
        }
        Movies movie = dao.getMovieByID(movieID);
        // Check start time of new slot have to later than end time of lastest slot
        System.out.println(startTimeEarlySlot);
        if (startTimeEarlySlot == null) {

            System.out.println("1");
            // //insert new theaters
            dao.insertNewCinemas(cinema, Date.valueOf(movieDateStr), locationID);
            //get id of cinemas recently inserted
            Cinemas c = dao.getCinemasRecentlyAdded();

            // //insert new theaters
            dao.insertTheaters(c.getCinemaID(), Integer.parseInt(theaterNumber), rows, columns);
            // //get id of theaters recently inserted
            int theaterID = dao.getTheaterIDRecentlyAdded();

            // //insert screeningTimes
            dao.updateScreeningTimes(theaterID, movieID, startTimeTimestamp, endTimeTimestamp, sid);
            response.sendRedirect("home_admin");
        } else {
            if (list.size() == 1) {
                if (endTimeLastestSlot.after(startTimeTimestamp)) {
                    System.out.println("2");
                    ScreeningTimes screeningTimes = dao.getAllScreeningById(sid);
                    Movies movie1 = dao.getMovieByID(screeningTimes.getMovieId());
                    String movieName2 = movie1.getTitle();

                    List<Cinemas> cinemases1 = dao.getAllCinemas();
                    List<Movies> listAllMovies1 = dao.getMovie();
                    request.setAttribute("sid", sid);
                    request.setAttribute("listAllMovies", listAllMovies1);
                    request.setAttribute("cinemases", cinemases1);
                    request.setAttribute("movieName", movieName2);
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

                    request.setAttribute("date", date);
                    request.setAttribute("formattedTimeStart", formattedTimeStart);
                    request.setAttribute("formattedTimeEnd", formattedTimeEnd);

                    request.setAttribute("message", "Start time of new slot have to later than end time of lastest slot is " + endTimeLastestSlot);
                    request.setAttribute("movie", movie);
                    List<Movies> listAllMovies = dao.getMovie();
                    List<Cinemas> cinemases = dao.getAllCinemas();
                    request.setAttribute("cinemases", cinemases);
                    request.setAttribute("listAllMovies", listAllMovies);

                    request.getRequestDispatcher("WEB-INF/views/admin-views/updateNewSlot.jsp").forward(request, response);

                } else {
                    dao.insertNewCinemas(cinema, Date.valueOf(movieDateStr), locationID);
                    //get id of cinemas recently inserted
                    Cinemas c = dao.getCinemasRecentlyAdded();

                    // //insert new theaters
                    dao.insertTheaters(c.getCinemaID(), Integer.parseInt(theaterNumber), rows, columns);
                    // //get id of theaters recently inserted
                    int theaterID = dao.getTheaterIDRecentlyAdded();

                    // //insert screeningTimes
                    dao.updateScreeningTimes(theaterID, movieID, startTimeTimestamp, endTimeTimestamp, sid);
                    response.sendRedirect("home_admin");
                }
            } else {
                if (!(endTimeLastestSlot.before(startTimeTimestamp) && startTimeEarlySlot.after(startTimeTimestamp))) {
                    String durationStart = movieDateStr + " " + startTime + ":00.0";
                    String durationEnd = movieDateStr + " " + endTime + ":00.0";

                    java.sql.Timestamp startTimestamp = java.sql.Timestamp.valueOf(durationStart);
                    java.sql.Timestamp endTimestamp = java.sql.Timestamp.valueOf(durationEnd);

                    if (!(startTimestamp.after(endTimeEarlySlot) && endTimestamp.before(startTimeLastestSlot))) {
                        System.out.println("5");
                        ScreeningTimes screeningTimes = dao.getAllScreeningById(sid);
                        Movies movie1 = dao.getMovieByID(screeningTimes.getMovieId());
                        String movieName2 = movie1.getTitle();

                        List<Cinemas> cinemases1 = dao.getAllCinemas();
                        List<Movies> listAllMovies1 = dao.getMovie();
                        request.setAttribute("sid", sid);
                        request.setAttribute("listAllMovies", listAllMovies1);
                        request.setAttribute("cinemases", cinemases1);
                        request.setAttribute("movieName", movieName2);
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

                        request.setAttribute("date", date);
                        request.setAttribute("formattedTimeStart", formattedTimeStart);
                        request.setAttribute("formattedTimeEnd", formattedTimeEnd);

                        request.setAttribute("message", "Start time of new slot have to later than end time of lastest slot is " + endTimeLastestSlot);
                        request.setAttribute("movie", movie);
                        List<Movies> listAllMovies = dao.getMovie();
                        List<Cinemas> cinemases = dao.getAllCinemas();
                        request.setAttribute("cinemases", cinemases);
                        request.setAttribute("listAllMovies", listAllMovies);

                        request.getRequestDispatcher("WEB-INF/views/admin-views/updateNewSlot.jsp").forward(request, response);
                    } else {
                        System.out.println("3");
                        dao.insertNewCinemas(cinema, Date.valueOf(movieDateStr), locationID);
                        //get id of cinemas recently inserted
                        Cinemas c = dao.getCinemasRecentlyAdded();

                        // //insert new theaters
                        dao.insertTheaters(c.getCinemaID(), Integer.parseInt(theaterNumber), rows, columns);
                        // //get id of theaters recently inserted
                        int theaterID = dao.getTheaterIDRecentlyAdded();

                        // //insert screeningTimes
                        System.out.println(theaterID);
                        System.out.println(movieID);
                        System.out.println(startTimeTimestamp);
                        System.out.println(endTimeTimestamp);
                        System.out.println(sid);

                        dao.updateScreeningTimes(theaterID, movieID, startTimeTimestamp, endTimeTimestamp, sid);
                        response.sendRedirect("home_admin");
                    }

                } else {
                    System.out.println("4");
                    //insert new cinemas
                    ScreeningTimes screeningTimes = dao.getAllScreeningById(sid);
                    Movies movie1 = dao.getMovieByID(screeningTimes.getMovieId());
                    String movieName2 = movie1.getTitle();
                    List<Cinemas> cinemases1 = dao.getAllCinemas();
                    List<Movies> listAllMovies1 = dao.getMovie();
                    request.setAttribute("sid", sid);
                    request.setAttribute("listAllMovies", listAllMovies1);
                    request.setAttribute("cinemases", cinemases1);
                    request.setAttribute("movieName", movieName2);
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

                    request.setAttribute("date", date);
                    request.setAttribute("formattedTimeStart", formattedTimeStart);
                    request.setAttribute("formattedTimeEnd", formattedTimeEnd);

                    request.setAttribute("message", "Start time of new slot have to later than end time of lastest slot is " + endTimeLastestSlot);
                    request.setAttribute("movie", movie);
                    List<Movies> listAllMovies = dao.getMovie();
                    List<Cinemas> cinemases = dao.getAllCinemas();
                    request.setAttribute("cinemases", cinemases);
                    request.setAttribute("listAllMovies", listAllMovies);

                    request.getRequestDispatcher("WEB-INF/views/admin-views/updateNewSlot.jsp").forward(request, response);
                }
            }

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
