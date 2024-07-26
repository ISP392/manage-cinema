/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import DAO.DAO;
import com.mysql.cj.Messages;
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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.UUID;
import java.util.stream.Collectors;
import modal.Movies;
import modal.Users;

/**
 *
 * @author ACER
 */
@WebServlet(name = "addVoucherServlet", urlPatterns = {"/addVoucher"})
@MultipartConfig
public class addVoucherServlet extends HttpServlet {

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
            out.println("<title>Servlet addVoucherServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addVoucherServlet at " + request.getContextPath() + "</h1>");
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
            request.getRequestDispatcher("/WEB-INF/views/addOther/addVoucher.jsp").forward(request, response);
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
        DAO dao = new DAO();
        String name = getPartValue(request.getPart("voucherName"));
        String description = getPartValue(request.getPart("description"));
        float discount = Float.parseFloat(request.getParameter("discountAmount"));
        Date startDate = Date.valueOf(getPartValue(request.getPart("startDate")));
        Date endDate = Date.valueOf(getPartValue(request.getPart("endDate")));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String code = getPartValue(request.getPart("code"));
        Dotenv dotenv = Dotenv.load();

        // Tạo đối tượng Path từ đường dẫn thực tế
        try {
            //check if date is 30 days from now will return a error message
            Date sd = new Date(System.currentTimeMillis());
            Date ed = new Date(System.currentTimeMillis());
            long diff = sd.getTime() - ed.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            if (diffDays > 30) {
                request.setAttribute("message", "Release date must be at most 30 days before now");
                request.getRequestDispatcher("/WEB-INF/views/addQther/addVoucher.jsp").forward(request, response);
            } 
                
                dao.insertAddVoucher(name, description, discount, startDate, endDate, quantity, code);
                Movies movie = dao.getMovieRecentlyAdded();
               
                response.sendRedirect("addVoucher");
            }

        catch (IOException | ServletException e) {
            e.printStackTrace();
        }
}

    private String getPartValue(Part part) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining("\n"));
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
