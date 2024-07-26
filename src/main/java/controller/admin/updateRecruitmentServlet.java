/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import DAO.DAO;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modal.Users;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import modal.Cinemas;
import modal.FoodItem;
import modal.RecruimentCinemas;
import modal.Recruiments;

@WebServlet(name = "updateRecruitmentServlet", urlPatterns = {"/update_recruitment"})
public class updateRecruitmentServlet extends HttpServlet {

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
            out.println("<title>Servlet updateFoodServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateFoodServlet at " + request.getContextPath() + "</h1>");
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
        Users u = (Users) request.getSession().getAttribute("admin");
        if (u == null || u.getRoleID().getRoleID() != 1) {
            response.sendRedirect("admin");
        } else {
            DAO dao = new DAO();
            String recruitmentID = request.getParameter("recruitmentID");
            ArrayList<Cinemas> cinemas = (ArrayList<Cinemas>) dao.getAllCinemas(); 
            request.setAttribute("cinemas", cinemas);
            Recruiments r = dao.getRecruimentById(Integer.parseInt(recruitmentID));
            request.setAttribute("item", r);
            List<RecruimentCinemas> recruitmentCinemas = r.getRecruimentCinemas();
            List<Integer> cinemaIds = recruitmentCinemas.stream()
                .map(RecruimentCinemas::getCinemaId)
                .collect(Collectors.toList());
            request.setAttribute("recruitmentCinemas", cinemaIds);
            request.getRequestDispatcher("/WEB-INF/views/addOther/updateRecruitment.jsp").forward(request, response);
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
        String recruitmentId = request.getParameter("recruitmentId");
        int numberNeeded = Integer.parseInt(request.getParameter("numberNeeded"));
        String[] addresses = request.getParameterValues("addresses");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String description = request.getParameter("description");
        boolean isDisplayOn = request.getParameter("display") != null;
        String type = request.getParameter("type");
        DAO dao = new DAO();
        
        if (addresses == null) {
            ArrayList<Cinemas> cinemas = (ArrayList<Cinemas>) 
                    dao.getAllCinemas();
            request.setAttribute("cinemas", cinemas);
            request.setAttribute("error", "You must choose at least one theater");
            request.getRequestDispatcher("/WEB-INF/views/addOther/updateRecruitment.jsp").forward(request, response);
            return;
        }
        try {
            dao.updateRecruitment(new Recruiments(Integer.parseInt(recruitmentId), vacancies, numberNeeded, startDate, endDate, description, isDisplayOn,type,null));
            
            
            ArrayList<RecruimentCinemas> list = dao.GetRecruimentCinemasByRecruimentId(Integer.parseInt(recruitmentId));
            
            List<Integer> cinemaIdsOld = list.stream()
                .map(RecruimentCinemas::getCinemaId)
                .collect(Collectors.toList());
            
             List<Integer> cinemaIdsNew = Arrays.stream(addresses)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
             
            dao.UpdateRecruitmentCinema(cinemaIdsOld, cinemaIdsNew, Integer.parseInt(recruitmentId));
        } catch (ParseException ex) {
            Logger.getLogger(updateRecruitmentServlet.class.getName()).log(Level.SEVERE, null, ex);
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
