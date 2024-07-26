/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import DAO.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.Users;
import util.Email;

/**
 *
 * @author baoquoc
 */
@WebServlet(name = "AddShiftServlet", urlPatterns = {"/add_shift"})
public class AddShiftServlet extends HttpServlet {

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
            out.println("<title>Servlet AddShiftServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddShiftServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Users u = (Users) request.getSession().getAttribute("admin");
        if (u == null || u.getRoleID().getRoleID() != 1) {
            response.sendRedirect("admin");
        } else {
            DAO dao = new DAO();
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            String userID = request.getParameter("userID");
            String email = request.getParameter("email");

            // Định dạng không có phần giây chính xác
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date parsedDate;

            try {
                // Phân tích cú pháp ngày giờ
                parsedDate = dateFormat.parse(startTime);
                java.sql.Timestamp startTimestamp = new java.sql.Timestamp(parsedDate.getTime());

                parsedDate = dateFormat.parse(endTime);
                java.sql.Timestamp endTimestamp = new java.sql.Timestamp(parsedDate.getTime());
                
                System.out.println("Email: "+email);
                Email.sendEmail(email, "Shift", "You have a new shift at " + startTimestamp + " to " + endTimestamp);
               
                    dao.insertShift(Integer.parseInt(userID), startTimestamp, endTimestamp);
                
            } catch (ParseException e) {
                e.printStackTrace();
            }

            response.sendRedirect("home_admin");
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
