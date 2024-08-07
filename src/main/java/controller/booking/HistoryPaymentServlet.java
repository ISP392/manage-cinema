/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.booking;

import DAO.DAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import modal.Tickets;
import modal.Users;

/**
 *
 * @author MISS NGA
 */
@WebServlet(name = "HistoryPaymentServlet", urlPatterns = {"/historyPayment"})
public class HistoryPaymentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Users user = (Users) request.getSession().getAttribute("account");
        if (user == null || user.getRoleID() == null || user.getRoleID().getName() == null) {
            response.sendRedirect("signin");
        } else {
            request.setAttribute("colorMain", "white");
            request.setAttribute("backgroundColorMain", "red");
            request.setAttribute("colorSecond", "#666");
            request.setAttribute("backgroundColorSecond", "#bfd2d9");

            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            int pageSize = 5;

            DAO dao = new DAO();

            // Get total number of tickets for the user
            List<Tickets> allTickets = dao.pagingTickets(user.getUserID(), 1); 
            int totalTickets = allTickets.size();
            int endPage = totalTickets / pageSize;
            if (totalTickets % pageSize != 0) {
                endPage++;
            }

            // Get the tickets for the current page
            int fromIndex = (index - 1) * pageSize;
            int toIndex = Math.min(fromIndex + pageSize, totalTickets);
            List<Tickets> listTickets = allTickets.subList(fromIndex, toIndex);

            request.setAttribute("endPage", endPage);
            request.setAttribute("tag", index);
            request.setAttribute("listTickets", listTickets);

            request.getRequestDispatcher("/WEB-INF/views/historyPaymennt.jsp").forward(request, response);
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
