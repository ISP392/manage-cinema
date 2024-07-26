/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.util.*;

import DAO.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.Cinemas;
import modal.ScreeningTimes;
import modal.Users;

/**
 *
 * @author baoquoc
 */
@WebServlet(name = "ViewSlotEachCinemasServlet", urlPatterns = {"/view-slot"})
public class ViewSlotEachCinemasServlet extends HttpServlet {

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
            out.println("<title>Servlet ViewSlotEachCinemasServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewSlotEachCinemasServlet at " + request.getContextPath() + "</h1>");
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
        Timestamp startTime = new Timestamp(System.currentTimeMillis());
        String dateParam = request.getParameter("date");
        Date[] dates = getWeekRange(dateParam);
        Date startHidden = dates[0]; // Ví dụ: 2024-07-01
        Date endHidden = dates[1]; // Ví dụ: 2024-07-07

        String cinemaName = request.getParameter("cinemaName");
        String theaterNumber = request.getParameter("theaterNumber");

        List<java.util.Date> weekDays = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date(startHidden.getTime()));
        while (!cal.getTime().after(new java.util.Date(endHidden.getTime()))) {
            weekDays.add(new java.util.Date(cal.getTimeInMillis()));
            cal.add(Calendar.DATE, 1);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");

        List<Cinemas> listCinemas = dao.getAllCinemas();
        List<Cinemas> listMovieDate = dao.getAllMovieDateInOneWeek(startHidden, endHidden, cinemaName,
                Integer.parseInt(theaterNumber));

        Map<String, List<ScreeningTimes>> showtimeMap = new HashMap<>();
        for (Cinemas c : listMovieDate) {
            List<ScreeningTimes> screeningTimes = dao.getAllScreeningTimesEachDay(c.getMovieDate(), cinemaName);

            // Sắp xếp danh sách screeningTimes theo startTime
            Collections.sort(screeningTimes, new Comparator<ScreeningTimes>() {
                @Override
                public int compare(ScreeningTimes st1, ScreeningTimes st2) {
                    return st1.getStartTime().compareTo(st2.getStartTime());
                }
            });

            String dateKey = sdf.format(c.getMovieDate());
            if (showtimeMap.containsKey(dateKey)) {
                showtimeMap.get(dateKey).addAll(screeningTimes);
            } else {
                showtimeMap.put(dateKey, new ArrayList<>(screeningTimes));
            }
        }

        request.setAttribute("showtimeMap", showtimeMap);
        request.setAttribute("listCinemas", listCinemas);
        request.setAttribute("cinemaName", cinemaName);
        request.setAttribute("theaterNumber", theaterNumber);
        request.setAttribute("currentDate", dateParam);
        request.setAttribute("weekDays", weekDays);
        request.getRequestDispatcher("/WEB-INF/views/admin-views/viewSlotEachCinemas.jsp").forward(request,
                response);
    }
}

    // get week range and return start date and end date as java.sql.Date
    public Date[] getWeekRange(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        LocalDate startDate = localDate.with(DayOfWeek.MONDAY);
        LocalDate endDate = startDate.plusDays(6);
        Date[] dates = new Date[2];
        dates[0] = Date.valueOf(startDate); // Chuyển đổi LocalDate thành java.sql.Date
        dates[1] = Date.valueOf(endDate); // Chuyển đổi LocalDate thành java.sql.Date
        return dates;
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
