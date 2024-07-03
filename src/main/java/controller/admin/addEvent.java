/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import DAO.DAO;
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
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import java.util.stream.Collectors;

import modal.Users;

/**
 *
 * @author LÊ PHƯƠNG MAI
 */
@WebServlet(name = "addEvent", urlPatterns = {"/addEvent"})
@MultipartConfig

public class addEvent extends HttpServlet {

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
            out.println("<title>Servlet addEvent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addEvent at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Users u = (Users) request.getSession().getAttribute("admin");
        if (u == null || u.getRoleID().getRoleID() != 1) {
            response.sendRedirect("admin");
        } else {
            request.getRequestDispatcher("/WEB-INF/views/addOther/addEvent.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        String eventName = null;
        String eventDescription = null;
        String startTimeStr = null;
        String endTimeStr = null;

        try {
            Collection<Part> parts = request.getParts();
            for (Part part : parts) {
                String name = part.getName();
                if (name.equals("eventName")) {
                    eventName = extractFormData(part);
                } else if (name.equals("eventDescription")) {
                    eventDescription = extractFormData(part);
                } else if (name.equals("startTime")) {
                    startTimeStr = extractFormData(part);
                } else if (name.equals("endTime")) {
                    endTimeStr = extractFormData(part);
                }
            }

            // Kiểm tra ngày thời điểm hiện tại
            Date currentDate = new Date();

            // Xử lý ngày thời điểm bắt đầu và kết thúc
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startTime = null;
            Date endTime = null;

            try {
                if (startTimeStr != null && !startTimeStr.isEmpty()) {
                    startTime = sdf.parse(startTimeStr);
                }
                if (endTimeStr != null && !endTimeStr.isEmpty()) {
                    endTime = sdf.parse(endTimeStr);
                }
            } catch (ParseException e) {
                request.setAttribute("message", "Invalid date format");
                request.getRequestDispatcher("/WEB-INF/views/addOther/addEvent.jsp").forward(request, response);
                return;
            }

            // Kiểm tra nếu thiếu thông tin bắt buộc
            if (eventName == null || eventName.isBlank() || eventDescription == null || eventDescription.isBlank() || startTime == null || endTime == null) {
                request.setAttribute("message", "Event name, description, and dates must be provided");
                request.getRequestDispatcher("/WEB-INF/views/addOther/addEvent.jsp").forward(request, response);
                return;
            }

            // Kiểm tra nếu ngày bắt đầu là trước ngày hiện tại
            if (startTime.before(currentDate)) {
                request.setAttribute("message", "Start date must be in the future");
                request.getRequestDispatcher("/WEB-INF/views/addOther/addEvent.jsp").forward(request, response);
                return;
            }

            // Xử lý tệp hình ảnh
            Part filePart = request.getPart("eventImg");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

            String relativePath = "uploads" + File.separator + fileName;
            String absolutePath = getServletContext().getRealPath("") + File.separator + relativePath;
            File uploadDir = new File(getServletContext().getRealPath("") + File.separator + "uploads");
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            try (InputStream fileContent = filePart.getInputStream()) {
                Files.copy(fileContent, Paths.get(absolutePath), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                request.setAttribute("message", "File upload failed");
                request.getRequestDispatcher("/WEB-INF/views/addOther/addEvent.jsp").forward(request, response);
                return;
            }

            // Thêm sự kiện vào cơ sở dữ liệu
            try {
                dao.insertAddEvent(eventName, eventDescription, new java.sql.Date(startTime.getTime()), new java.sql.Date(endTime.getTime()), relativePath);
                response.sendRedirect("home"); // Chuyển hướng về trang chủ sau khi thêm thành công
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("message", "An error occurred while adding the event");
                request.getRequestDispatcher("/WEB-INF/views/addOther/addEvent.jsp").forward(request, response);
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
            request.setAttribute("message", "Error processing form data");
            request.getRequestDispatcher("/WEB-INF/views/addOther/addEvent.jsp").forward(request, response);
        }
    }

    /**
     * Phương thức để trích xuất dữ liệu từ Part thành chuỗi.
     */
    private String extractFormData(Part part) throws IOException {
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
