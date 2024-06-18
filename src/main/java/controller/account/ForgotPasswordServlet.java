/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.account;

import DAO.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modal.UpdateInformation;
import modal.Users;

/**
 *
 * @author caoha
 */
@WebServlet(name="ForgotPasswordServlet", urlPatterns={"/forgot"})
public class ForgotPasswordServlet extends HttpServlet {
   
    //private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        DAO dao = new DAO();
        if(dao.checkEmailAndPasswordNull(email)){
            request.setAttribute("error", "Email account not valid. Please try again!!!");
            request.getRequestDispatcher("/WEB-INF/views/forgotPass.jsp").forward(request, response);
            return;
        }else if(!dao.checkEmail(email)){
            request.setAttribute("error", "Email account not valid. Please try again!!!");
            request.getRequestDispatcher("/WEB-INF/views/forgotPass.jsp").forward(request, response);
            return;
        }
        Users u = new Users(email);
        UpdateInformation UI = new UpdateInformation("forgot", u.getEmail());
        HttpSession session = request.getSession();
        session.setAttribute("user", u);
        session.setAttribute("information", UI);
        response.sendRedirect("verify");
    }

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
        request.getRequestDispatcher("/WEB-INF/views/forgotPass.jsp").forward(request, response);
    
    } 


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
