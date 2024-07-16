/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.account;

import DAO.DAO;

import java.io.IOException;
import java.io.PrintWriter;

import controller.Google.Constants;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;
import modal.Shift;
import modal.StaffStatus;
import modal.Users;

/**
 * @author baoquoc
 */
@WebServlet(name = "SignIn", urlPatterns = {"/signin"})
public class SignInServlet extends HttpServlet {

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
            out.println("<title>Servlet SignIn</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignIn at " + request.getContextPath() + "</h1>");
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
        //load .env file
        Dotenv dotenv = Dotenv.load();
        String localhost = dotenv.get("LOCALHOST");
        HttpSession session = request.getSession();

        String error = (String) session.getAttribute("error");
        session.removeAttribute("error");

        request.setAttribute("localhost", localhost);
        request.setAttribute("error", error);
        request.getRequestDispatcher("/WEB-INF/views/signIn.jsp").forward(request, response);
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        DAO d = new DAO();
        Users user = d.checkLogin(username, password);
        if (user == null) {
            request.getSession().setAttribute("error", "Username or password was incorrect!!");
            response.sendRedirect("signin");
        } else {
            HttpSession session = request.getSession();
            int roleID = user.getRoleID().getRoleID();

            if (roleID == 2) {
                session.setAttribute("account", user);
                response.sendRedirect("home");
            } else if (roleID == 3) {
                 StaffStatus status = user.getPhone();
                if (status == null || !"approve".equals(status.getStatus())) {
                    request.getSession().setAttribute("error", "Your account is not approved!");
                    response.sendRedirect("signin");
                    return;
                }

                // Get current time
                Timestamp currentTime = new Timestamp(System.currentTimeMillis());
                Shift shift = d.getShiftForUser(status.getPhone());

                if (shift == null || currentTime.before(shift.getStartTime()) || currentTime.after(shift.getEndTime())) {
                    request.getSession().setAttribute("error", "You are not in your shift time!");
                    response.sendRedirect("signin");
                } else {
                    session.setAttribute("account", user);
                    response.sendRedirect("homeStaff");
                }
            } else {
                // If the role is not 2 or 3, redirect back to signin with an error
                request.getSession().setAttribute("error", "Invalid user role!");
                response.sendRedirect("signin");
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
