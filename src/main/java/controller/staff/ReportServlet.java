/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.staff;

import DAO.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modal.Users;

/**
 *
 * @author caoha
 */
@WebServlet(name = "ReportServlet", urlPatterns = {"/report"})
public class ReportServlet extends HttpServlet {

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
            out.println("<title>Servlet ReportServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReportServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("/WEB-INF/views/staff-views/shiftReport.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Users user = (Users) req.getSession().getAttribute("account");
        if (user == null) {
            resp.sendRedirect("signin");
        } else {
            int userID = user.getUserID();
            String date = req.getParameter("date");
            String shift = req.getParameter("shift");
            String startCash = req.getParameter("startCash");
            String endCash = req.getParameter("endCash");
            String transferPayments = req.getParameter("transferPayments"); // Sửa lại tên biến cho đúng

            String[] shiftTimes = shift.split("-");
            String startTime = date + " " + shiftTimes[0] + ":00";
            String endTime = date + " " + shiftTimes[1] + ":00";

            DAO dao = new DAO();
            dao.saveShiftReport(userID, startTime, endTime, Double.parseDouble(startCash), Double.parseDouble(endCash), Double.parseDouble(transferPayments));

            req.setAttribute("userID", userID);
            req.getRequestDispatcher("/WEB-INF/views/staff-views/reportSuccess.jsp").forward(req, resp);
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
