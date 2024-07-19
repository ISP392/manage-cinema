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
import java.util.List;
import modal.Orders;
import modal.Users;

/**
 *
 * @author caoha
 */
@WebServlet(name = "ChooseCustomer", urlPatterns = {"/chooseCustomer"})
public class ChooseCustomer extends HttpServlet {

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
            out.println("<title>Servlet ChooseCustomer</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChooseCustomer at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("/WEB-INF/views/staff-views/listCustomer.jsp").forward(request, response);
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
        HttpSession session = req.getSession();
        Integer userIDs = (Integer) session.getAttribute("userID");
        if (userIDs == null) {
            resp.sendRedirect("signin");
        } else {
            String userIDStr = req.getParameter("userID");
            if (userIDStr == null || userIDStr.isEmpty() || !userIDStr.matches("\\d+")) {
                req.setAttribute("error", "Mã khách hàng không hợp lệ.");
                req.getRequestDispatcher("/WEB-INF/views/staff-views/listCustomer.jsp").forward(req, resp);
                return;
            }

            int userID = Integer.parseInt(userIDStr);
            DAO d = new DAO();
            List<Users> usersList = d.getUserById(userID);

            if (usersList != null && !usersList.isEmpty()) {
                req.setAttribute("user", usersList);
            } else {
                req.setAttribute("error", "Không tìm thấy thông tin khách hàng.");
            }

            req.getRequestDispatcher("/WEB-INF/views/staff-views/listCustomer.jsp").forward(req, resp);
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
