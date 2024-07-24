/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import DAO.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import modal.Movies;
import modal.Cinemas;
import modal.ScreeningTimes;
import util.CinemaConfig;

/**
 *
 * @author LÊ PHƯƠNG MAI
 */
@WebServlet(name = "addNewSlot", urlPatterns = {"/addNewSlot"})
public class addNewSlot extends HttpServlet {

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
            out.println("<title>Servlet addNewSlot</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addNewSlot at " + request.getContextPath() + "</h1>");
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
//        Users u = (Users) request.getSession().getAttribute("admin");
//        if (u == null || u.getRoleID().getRoleID() != 1 || movieID == null) {
//            response.sendRedirect("admin");
//        } else {
        DAO dao = new DAO();
        List<Movies> listAllMovies = dao.getMovie();
        request.setAttribute("listAllMovies", listAllMovies);
        List<Cinemas> cinemases = dao.getAllCinemas();
        request.setAttribute("cinemases", cinemases);
//            Movies movie = dao.getMovieByIDForAddSlot(Integer.parseInt(movieID));
//           
//            if (movie == null) {
//                request.setAttribute("errorMessage", "Hãy Chọn Những Phim Đang Chiếu");
//
//                String indexPage = request.getParameter("index");
//                if (indexPage == null) {
//                    indexPage = "1";
//                }
//                int index = Integer.parseInt(indexPage);
//                int pageSize = 10;
//
//                int totalMovies = dao.getMovieCount();
//                int endPage = totalMovies / pageSize;
//                if (totalMovies % pageSize != 0) {
//                    endPage++;
//                }
//
//                List<Movies> listMovies = dao.getMoviesByPage(index, pageSize);
//
//                java.util.Date currentDate = new java.util.Date();
//                Calendar cal = Calendar.getInstance();
//                cal.setTime(currentDate);
//                cal.add(Calendar.DAY_OF_MONTH, -30);
//                java.util.Date date30DaysAgo = cal.getTime();
//
//                for (Movies m : listMovies) {
//                    if (m.getDisplay() == 1) {
//                        if (m.getReleaseDate().after(currentDate)) {
//                            m.setStatus("Sắp Chiếu");
//                        } else if (m.getReleaseDate().after(date30DaysAgo) && m.getReleaseDate().before(currentDate)) {
//                            m.setStatus("Đang chiếu");
//                        } else {
//                            m.setStatus("Đã chiếu");
//                        }
//                    } else if (m.getDisplay() == 0) {
//                        m.setStatus("Hidden");
//                    }
//                }
//
//                request.setAttribute("endPage", endPage);
//                request.setAttribute("tag", index);
//                request.setAttribute("listMovies", listMovies);
//                request.getRequestDispatcher("/WEB-INF/views/admin-views/listMovie.jsp").forward(request, response);
//                return;
//            }
//
//            int duration = movie.getDuration();
//            request.setAttribute("duration", duration);
//            request.setAttribute("movie", movie);
        request.getRequestDispatcher("WEB-INF/views/admin-views/addslotmovies.jsp").forward(request, response);
//        }

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
        String movieName = request.getParameter("movieName");

        String cinema = request.getParameter("cinemaSelect");

        String movieDateStr = request.getParameter("dateInput");
        String theaterNumber = request.getParameter("theaterNumber");
        String startTime = request.getParameter("startTimeInput");
        String endTime = request.getParameter("endTimeInput");

        CinemaConfig cinemaConfig = new CinemaConfig();
        // Lấy ID của địa điểm cinema từ tên cinema và lưu vào biến "locationID"
        int locationID = cinemaConfig.getLocationIdByCinemaName(cinema);

        int[] dimensions = cinemaConfig.getRowsAndColumns(cinema, Integer.parseInt(theaterNumber));
        // Lấy số hàng và cột của rạp chiếu từ tên cinema và số rạp chiếu
        int rows = dimensions[0];
        // Lưu số hàng của rạp chiếu vào biến "rows"

        int columns = dimensions[1];
        // Lưu số cột của rạp chiếu vào biến "columns"

        DAO dao = new DAO();
        java.sql.Timestamp startTimeEarlySlot = null;
        java.sql.Timestamp endTimeEarlySlot = null;
        java.sql.Timestamp startTimeLastestSlot = null;
        List<ScreeningTimes> list = dao.getAllFlimDay(movieDateStr, Integer.parseInt(theaterNumber));

        if (!list.isEmpty()) {
            startTimeEarlySlot = list.get(0).getStartTime();
            endTimeEarlySlot = list.get(0).getEndTime();
            System.out.println(list.size());

            if (list.size() == 1) {
                startTimeLastestSlot = list.get(0).getStartTime();
            } else if (list.size() > 1) {
                startTimeLastestSlot = list.get(1).getStartTime();
            }

            System.out.println(startTimeEarlySlot);
        }

        Movies movies = dao.getMovieByName(movieName);

        int movieID = movies.getMovieID();
        // Định dạng chuỗi ngày tháng
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // Khởi tạo biến để lưu ngày chiếu phim dưới dạng java.util.Date
        java.util.Date movieDateUtil;
        try {
            movieDateUtil = format.parse(movieDateStr);
            // Chuyển đổi chuỗi ngày tháng thành đối tượng java.util.Date và lưu vào "movieDateUtil"
        } catch (ParseException e) {
            response.getWriter().print("Error: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        java.sql.Date movieDateSql = new java.sql.Date(movieDateUtil.getTime());

        // Lấy thời gian kết thúc của suất chiếu gần nhất trong rạp chiếu
        java.sql.Timestamp endTimeLastestSlot = dao.getLastestEndTimeOfTheater(cinema, movieDateSql, Integer.parseInt(theaterNumber));
        System.out.println(endTimeLastestSlot);
        // Giả định rằng movieDateStr là chuỗi ngày tháng dạng "yyyy-MM-dd"
        String startTimeStr = movieDateStr + " " + startTime + ":00";
        String endTimeStr = movieDateStr + " " + endTime + ":00";
        // Khởi tạo các biến để lưu thời gian bắt đầu và kết thúc dưới dạng java.sql.Timestamp
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
        // Kiểm tra xem thời gian bắt đầu của suất chiếu mới có sau thời gian kết thúc của suất chiếu gần nhất hay không
        if (startTimeEarlySlot == null) {
            dao.insertNewCinemas(cinema, Date.valueOf(movieDateStr), locationID);
            //get id of cinemas recently inserted
            Cinemas c = dao.getCinemasRecentlyAdded();
            System.out.println("1");
            // //insert new theaters
            dao.insertTheaters(c.getCinemaID(), Integer.parseInt(theaterNumber), rows, columns);
            // //get id of theaters recently inserted
            int theaterID = dao.getTheaterIDRecentlyAdded();

            // //insert screeningTimes
            dao.insertScreeningTimes(theaterID, movieID, startTimeTimestamp, endTimeTimestamp);
            response.sendRedirect("home_admin");
        } else {
            if (list.size() == 1) {
                if (endTimeLastestSlot.after(startTimeTimestamp)) {
                    System.out.println("2");
                    request.setAttribute("message", "Start time of new slot have to later than end time of lastest slot is " + endTimeLastestSlot);
                    request.setAttribute("movie", movie);
                    List<Movies> listAllMovies = dao.getMovie();
                    request.setAttribute("listAllMovies", listAllMovies);
                    List<Cinemas> cinemases = dao.getAllCinemas();
                    request.setAttribute("cinemases", cinemases);
                    request.getRequestDispatcher("WEB-INF/views/admin-views/addslotmovies.jsp").forward(request, response);

                } else {
                    dao.insertNewCinemas(cinema, Date.valueOf(movieDateStr), locationID);
                    //get id of cinemas recently inserted
                    Cinemas c = dao.getCinemasRecentlyAdded();

                    // //insert new theaters
                    dao.insertTheaters(c.getCinemaID(), Integer.parseInt(theaterNumber), rows, columns);
                    // //get id of theaters recently inserted
                    int theaterID = dao.getTheaterIDRecentlyAdded();

                    // //insert screeningTimes
                    dao.insertScreeningTimes(theaterID, movieID, startTimeTimestamp, endTimeTimestamp);
                    response.sendRedirect("home_admin");
                }
            } else {
                if (!(endTimeLastestSlot.before(startTimeTimestamp) && startTimeEarlySlot.after(startTimeTimestamp))) {
                    String durationStart = movieDateStr + " " + startTime + ":00.0";
                    String durationEnd = movieDateStr + " " + endTime + ":00.0";

                    java.sql.Timestamp startTimestamp = java.sql.Timestamp.valueOf(durationStart);
                    java.sql.Timestamp endTimestamp = java.sql.Timestamp.valueOf(durationEnd);
                    System.out.println(endTimeEarlySlot);
                    System.out.println(startTimestamp);
                    System.out.println(startTimeLastestSlot);
                    System.out.println(endTimestamp);
                    System.out.println("123" + endTimeEarlySlot.after(startTimestamp));
                    System.out.println("234" + startTimeLastestSlot.before(endTimestamp));
                    if (!(startTimestamp.after(endTimeEarlySlot) && endTimestamp.before(startTimeLastestSlot))) {
                        System.out.println("5");
                        request.setAttribute("message", "Start time of new slot have to later than end time of lastest slot is " + endTimeLastestSlot);
                        request.setAttribute("movie", movie);
                        List<Movies> listAllMovies = dao.getMovie();
                        request.setAttribute("listAllMovies", listAllMovies);
                        List<Cinemas> cinemases = dao.getAllCinemas();
                        request.setAttribute("cinemases", cinemases);
                        request.getRequestDispatcher("WEB-INF/views/admin-views/addslotmovies.jsp").forward(request, response);
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
                        dao.insertScreeningTimes(theaterID, movieID, startTimeTimestamp, endTimeTimestamp);
                        response.sendRedirect("home_admin");
                    }

                } else {
                    System.out.println("4");
                    //insert new cinemas
                    request.setAttribute("message", "Start time of new slot have to later than end time of lastest slot is " + endTimeLastestSlot);
                    request.setAttribute("movie", movie);
                    List<Movies> listAllMovies = dao.getMovie();
                    request.setAttribute("listAllMovies", listAllMovies);
                    List<Cinemas> cinemases = dao.getAllCinemas();
                    request.setAttribute("cinemases", cinemases);
                    request.getRequestDispatcher("WEB-INF/views/admin-views/addslotmovies.jsp").forward(request, response);
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
