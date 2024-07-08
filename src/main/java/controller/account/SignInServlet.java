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
            session.setAttribute("account", user);
            // Redirect based on user role
            if (user.getRoleID().getRoleID() == 2) {
                response.sendRedirect("home");
            } else if (user.getRoleID().getRoleID() == 3) {
                response.sendRedirect("homeStaff");
            } else {
                // Default or other roles can be redirected to a common page
                response.sendRedirect("nowShowing");
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
