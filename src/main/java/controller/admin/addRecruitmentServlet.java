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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modal.Cinemas;
import modal.Recruiments;
import modal.Users;

/**
 *
 * @author ACER
 */
@WebServlet(name = "addRecruitmentServlet", urlPatterns = {"/addRecruitment"})
public class addRecruitmentServlet extends HttpServlet {

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
            out.println("<title>Servlet addRecruitmentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addRecruitmentServlet at " + request.getContextPath() + "</h1>");
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
            DAO dao = new DAO();
            ArrayList<Cinemas> cinemas = (ArrayList<Cinemas>) dao.getAllCinemas();
            request.setAttribute("cinemas", cinemas);
            request.getRequestDispatcher("/WEB-INF/views/addOther/addRecruitment.jsp").forward(request, response);
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
        String vacancies = request.getParameter("vacancies");
        int numberNeeded = Integer.parseInt(request.getParameter("numberNeeded"));
        String[] addresses = request.getParameterValues("addresses");
        String startDate = request.getParameter("startDate");
        String type = request.getParameter("type");
        String endDate = request.getParameter("endDate");
        String description = request.getParameter("description");
        boolean isDisplayOn = request.getParameter("display") != null;

                DAO dao = new DAO();

        if (addresses == null) {
            ArrayList<Cinemas> cinemas = (ArrayList<Cinemas>) 
                    dao.getAllCinemas();
            request.setAttribute("cinemas", cinemas);
            request.setAttribute("error", "You must choose at least one theater");
            request.getRequestDispatcher("/WEB-INF/views/addOther/addRecruitment.jsp").forward(request, response);
            return;
        }
        int id = 0;
        try {
            id = dao.insertRecruiemnt(new Recruiments(0, vacancies, numberNeeded, startDate, endDate, description, isDisplayOn, type, null));
            if (id != 0) {
                for (String addresse : addresses) {
                    int cinemaId = Integer.parseInt(addresse);
                    dao.insertRecruiemntCinema(id, cinemaId);
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(addRecruitmentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("listRecruitments");

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
