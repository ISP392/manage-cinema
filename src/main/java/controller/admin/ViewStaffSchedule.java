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
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modal.Cinemas;
import modal.ShiftCurrent;
import modal.Users;

/**
 *
 * @author baoquoc
 */
@WebServlet(name = "ViewStaffSchedule", urlPatterns = {"/staff-schedule"})
public class ViewStaffSchedule extends HttpServlet {

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
            out.println("<title>Servlet ViewStaffSchedule</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewStaffSchedule at " + request.getContextPath() + "</h1>");
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
            
            List<Cinemas> listCinemas = dao.getAllCinemas();
            String dateParam = request.getParameter("date");
            Date[] dates = getWeekRange(dateParam);
            Date startHidden = dates[0]; // Ví dụ: 2024-07-01
            Date endHidden = dates[1]; // Ví dụ: 2024-07-07
            
            String cinemaName = request.getParameter("cinemaName");
            List<Users> listStaff = dao.getAllStaffByCinemaName(cinemaName);

            List<java.util.Date> weekDays = new ArrayList<>();
            Calendar cal = Calendar.getInstance();
            cal.setTime(new java.util.Date(startHidden.getTime()));
            while (!cal.getTime().after(new java.util.Date(endHidden.getTime()))) {
                weekDays.add(new java.util.Date(cal.getTimeInMillis()));
                cal.add(Calendar.DATE, 1);
            }

            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

            List<ShiftCurrent> listShiftAllWeek = dao.getAllDayHasShiftAWeek(startHidden, endHidden, cinemaName);
            Map<String, List<ShiftCurrent>> mapShift = new HashMap<>();
            for(ShiftCurrent shift : listShiftAllWeek){
                Timestamp thisDate = shift.getStartTime();
                //change format thisDate to yyyy-MM-dd
                String key = sdf2.format(thisDate);
                List<ShiftCurrent> eachShiftPerDay = dao.getAllShiftTimeOfStaffEachDay(Date.valueOf(key), cinemaName);
                if(mapShift.containsKey(key)){
                    mapShift.get(key).addAll(eachShiftPerDay);
                } else {
                    mapShift.put(key, eachShiftPerDay);
                }
            }
            request.setAttribute("mapShift", mapShift);
            request.setAttribute("cinemaName", cinemaName);
            request.setAttribute("listStaff", listStaff);

             request.setAttribute("listCinemas", listCinemas);
             request.getRequestDispatcher("/WEB-INF/views/admin-views/staffSchedule.jsp").forward(request, response);
        }
    }
    
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

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
