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
import java.util.List;
import modal.Role;
import modal.StaffStatus;
import modal.Users;
import util.Email;
import util.Encrypt;
import util.Generate;

/**
 *
 * @author Miss Nga
 */
@WebServlet(name = "ManageStaffStatusController", urlPatterns = {"/manage-staff-status"})
public class ManageStaffStatusController extends HttpServlet {

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
            out.println("<title>Servlet ManageStaffStatusController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageStaffStatusController at " + request.getContextPath() + "</h1>");
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
        Users u = (Users) request.getSession().getAttribute("admin");
        if (u == null || u.getRoleID().getRoleID() != 1) {
            response.sendRedirect("admin");
        } else {
            String action = request.getParameter("action");
            action = action != null ? action : "";
            DAO dao = new DAO();
            switch (action) {
                case "approve":
                    this.approved(request, response);
                    break;
                case "reject":
                    this.reject(request, response);
                    break;
                default:
                    List<StaffStatus> staffStatus = dao.getAllStaffStatusWithCinema();
                    request.setAttribute("staffStatus", staffStatus);
                    request.getRequestDispatcher("/WEB-INF/views/admin-views/staffStatus.jsp").forward(request, response);
            }

        }
    }

    private void approved(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            DAO dao = new DAO();
            String phoneAcc = request.getParameter("phone");
            StaffStatus staff = dao.getAllStaffByPhone(phoneAcc);
            boolean isOk = dao.updateStatus(phoneAcc, "Approve");
            if (isOk) {
                String username = "staff" + phoneAcc;
                Generate generate = new Generate();
                String password = generate.generatePassword(10);
                Role role = new Role(3);
                Encrypt en = new Encrypt();

                Users u = new Users(0, staff.getStaffName(), username, en.toSHA1No(password), staff.getStaffEmail(), role, 0, phoneAcc);
                dao.addStaff(u, staff.getPhone());
                String textContent = "Your account is approved. Please using username: " + username + "\n password: " + password + " \n. To login into the system";
                boolean isSuccess = Email.sendEmail(staff.getStaffEmail(), "Reply Application: ", textContent);
                response.sendRedirect("manage-staff-status?success=Approved this staff successfully");
            } else {
                response.sendRedirect("manage-staff-status?error=Approved this staff fail");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            response.sendRedirect("manage-staff-status");
        }
    }

    private void reject(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            DAO dao = new DAO();
            String phoneAcc = request.getParameter("phone");
            StaffStatus staff = dao.getAllStaffByPhone(phoneAcc);
            boolean isOk = dao.updateStatus(phoneAcc, "Reject");

            if (isOk) {
                String textContent = "Sorry you. You appplication are rejected. You maybe can not fit with our company. I wish I see you in our company in the feature";
                boolean isSuccess = Email.sendEmail(staff.getStaffEmail(), "Reply Application:", textContent);
                response.sendRedirect("manage-staff-status?error=Reject  this staff success");
            } else {
                response.sendRedirect("manage-staff-status?error=Reject this staff fail");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            response.sendRedirect("manage-staff-status");
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
