/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import DAO.DAO;
import DAO.admin_DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.Cinemas;
import modal.Users;

/**
 *
 * @author baoquoc
 */
@WebServlet(name = "homeAdminServlet", urlPatterns = {"/home_admin"})
public class homeAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Users u = (Users) request.getSession().getAttribute("admin");
        if( u == null || u.getRoleID().getRoleID() != 1 ){
            response.sendRedirect("admin");
        }else{
        admin_DAO ad = new admin_DAO();
        DAO dao = new DAO();
        int totalTicket = ad.getTotalTicket();
        int totalMoney = ad.getTotalMoney();
        int totalStaff = ad.getTotalStaff();
        int totalUser = ad.getTotalUser();
        List<Cinemas> listCinemas = dao.getAllCinemas();

        request.setAttribute("totalTicket", totalTicket);
        request.setAttribute("totalMoney", totalMoney);
        request.setAttribute("totalStaff", totalStaff);
        request.setAttribute("totalUser", totalUser);
        request.setAttribute("listCinemas", listCinemas);
        request.getRequestDispatcher("/WEB-INF/views/admin-views/homeAdmin.jsp").forward(request, response);
            }
    }
}
