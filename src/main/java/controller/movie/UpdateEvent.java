/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.movie;

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
import modal.Events;

/**
 *
 * @author LÊ PHƯƠNG MAI
 */
@WebServlet(name = "UpdateEvent", urlPatterns = {"/updateEvent"})
@MultipartConfig
public class UpdateEvent extends HttpServlet {

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
            out.println("<title>Servlet UpdateEvent</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateEvent at " + request.getContextPath() + "</h1>");
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
         int eventID = Integer.parseInt(request.getParameter("eventID"));
        DAO dao = new DAO();
        Events event = dao.getEventById(eventID);
        request.setAttribute("event", event);
        request.getRequestDispatcher("/WEB-INF/views/updateEvent.jsp").forward(request, response);
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
        String eventName = null;
        String eventDescription = null;
        String startTimeStr = null;
        String endTimeStr = null;
        int eventID = 0;

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
                } else if (name.equals("eventID")) {
                    eventID = Integer.parseInt(extractFormData(part));
                }
            }

            // Kiểm tra ngày thời điểm hiện tại
            java.util.Date currentDate = new java.util.Date();

            // Xử lý ngày thời điểm bắt đầu và kết thúc
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date startTime = null;
            java.util.Date endTime = null;

            try {
                if (startTimeStr != null && !startTimeStr.isEmpty()) {
                    startTime = sdf.parse(startTimeStr);
                }
                if (endTimeStr != null && !endTimeStr.isEmpty()) {
                    endTime = sdf.parse(endTimeStr);
                }
            } catch (ParseException e) {
                request.setAttribute("message", "Invalid date format");
                request.getRequestDispatcher("/WEB-INF/views/updateEvent.jsp").forward(request, response);
                return;
            }

            // Kiểm tra nếu thiếu thông tin bắt buộc
            if (eventName == null || eventName.isBlank() || eventDescription == null || eventDescription.isBlank() || startTime == null || endTime == null) {
                request.setAttribute("message", "Event name, description, and dates must be provided");
                request.getRequestDispatcher("/WEB-INF/views/updateEvent.jsp").forward(request, response);
                return;
            }

            // Kiểm tra nếu ngày bắt đầu là trước ngày hiện tại
            if (startTime.before(currentDate) || endTime.before(startTime)) {
                request.setAttribute("message", "Start date, End date must be in the future");
                request.getRequestDispatcher("/WEB-INF/views/updateEvent.jsp").forward(request, response);
                return;
            }

            // Xử lý tệp hình ảnh
            Part filePart = request.getPart("eventImg");
            String fileName = null;
            String relativePath = null;
            if (filePart != null && filePart.getSize() > 0) {
                fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                relativePath = File.separator + fileName;
                String absolutePath = getServletContext().getRealPath("") + File.separator + relativePath;
                File uploadDir = new File(getServletContext().getRealPath("") + File.separator );
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                try (InputStream fileContent = filePart.getInputStream()) {
                    Files.copy(fileContent, Paths.get(absolutePath), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    request.setAttribute("message", "File upload failed");
                    request.getRequestDispatcher("/WEB-INF/views/updateEvent.jsp").forward(request, response);
                    return;
                }
            }

            // Cập nhật sự kiện vào cơ sở dữ liệu
            try {
                dao.updateEvent(eventID, eventName, eventDescription, new java.sql.Date(startTime.getTime()), new java.sql.Date(endTime.getTime()), relativePath);
                response.sendRedirect("home"); // Chuyển hướng về trang chủ sau khi cập nhật thành công
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("message", "An error occurred while updating the event");
                request.getRequestDispatcher("/WEB-INF/views/updateEvent.jsp").forward(request, response);
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
            request.setAttribute("message", "Error processing form data");
            request.getRequestDispatcher("/WEB-INF/views/updateEvent.jsp").forward(request, response);
        }
    }
 private String extractFormData(Part part) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder value = new StringBuilder();
            char[] buffer = new char[1024];
            int length;
            while ((length = reader.read(buffer)) > 0) {
                value.append(buffer, 0, length);
            }
            return value.toString();
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
