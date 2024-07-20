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
import java.io.InputStream;
import java.io.InputStreamReader;
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
@WebServlet(name = "addFoodServlet", urlPatterns = {"/addFood"})
@MultipartConfig
public class addFoodServlet extends HttpServlet {

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
            out.println("<title>Servlet addFoodServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addFoodServlet at " + request.getContextPath() + "</h1>");
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
            request.getRequestDispatcher("/WEB-INF/views/addOther/addFood.jsp").forward(request, response);
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

        String foodName = getPartValue(request.getPart("foodName")).trim();
        String description = getPartValue(request.getPart("description"));
        int price = Integer.parseInt(request.getParameter("price"));
        //int quantity = Integer.parseInt(request.getParameter("quantity"));

        Dotenv dotenv = Dotenv.load();
        String realPath = dotenv.get("URL_UPLOAD_IMAGE");

        // Tạo đối tượng Path từ đường dẫn thực tế
        Path dirPath = Paths.get(realPath);
        try {
            // Kiểm tra nếu thư mục không tồn tại thì tạo mới
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }
            // Lấy phần của request chứa file ảnh
            Part part = request.getPart("imgFoodItems");
            // Lấy tên file gốc
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            // Tạo tên file duy nhất để tránh trùng lặp
            String uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;
            // Tạo đường dẫn tới file ảnh trong thư mục uploads
            Path imagePath = Paths.get(realPath, uniqueFileName);
            // Ghi dữ liệu từ input stream của file ảnh vào đường dẫn vừa tạo
            try (InputStream input = part.getInputStream()) {
                Files.copy(input, imagePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            dao.insertAddFood(foodName, description, price, uniqueFileName, 0);
            response.sendRedirect("listFood");

        } catch (IOException | ServletException e) {
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
