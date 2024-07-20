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
import java.util.ArrayList;
import java.util.List;
import modal.Users;

/**
 *
 * @author MISS NGA
 */
@WebServlet(name = "ManageUser", value = "/manager_user")
public class ManageUser extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet ManageUser</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageUser at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            Users u = (Users) request.getSession().getAttribute("admin");
            if (u == null || u.getRoleID().getRoleID() != 1) {
                response.sendRedirect("admin");
            } else {
                String action = request.getParameter("action");
                action = action != null ? action : "";
                DAO dao = new DAO();
                switch (action) {
                    case "delete":
                        this.delete(request, response);
                        break;
                    default:
                        List<Users> listUsers = dao.getAllStaffWithCinema();
                        request.setAttribute("USERS", listUsers);
                        request.getRequestDispatcher("/WEB-INF/views/admin-views/managerAccountUsers.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    private void delete(HttpServletRequest request, HttpServletResponse response) {
        try {
            String userIDs = request.getParameter("userID");        
            String phone = request.getParameter("phone");

            if (userIDs != null) {
                DAO dao = new DAO();
                boolean reuslt = dao.deleteStaff(Integer.parseInt(userIDs), phone);
                if (reuslt) {
                    response.sendRedirect("manager_user?success=Delete this staff successfully");
                } else {
                    response.sendRedirect("manager_user?error=Delete this staff failed");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
