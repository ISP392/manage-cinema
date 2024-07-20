/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.information;

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
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import modal.Cinemas;
import modal.StaffStatus;
import util.Email;

/**
 *
 * @author ACER
 */
@WebServlet(name = "EmploymentInformationServlet", urlPatterns = {"/employmentInformation"})
@MultipartConfig
public class EmploymentInformationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

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
            out.println("<title>Servlet EmploymentInformationServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmploymentInformationServlet at " + request.getContextPath() + "</h1>");
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
        DAO dao = new DAO();
        List<Cinemas> cinema = dao.getAllCinemas();
        request.setAttribute("cinema", cinema);
        request.getRequestDispatcher("/WEB-INF/views/employmentInformation.jsp").forward(request, response);
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

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String position = request.getParameter("position");
        String cinema = request.getParameter("cinemaId");
        Part filePart = request.getPart("cv");
        int cinemaId = Integer.parseInt(cinema);
        DAO dao = new DAO();
        
        boolean emailExists = dao.checkEPstaff(email, null); 
        boolean phoneExists = dao.checkEPstaff(null, phone); 
        boolean emailAndPhoneExist = dao.checkEPstaff(email, phone); 

        if (emailExists && !phoneExists) {
            request.setAttribute("errorEmail", "Email is already existed");
        } else if (!emailExists && phoneExists) {
            request.setAttribute("errorPhone", "Phone number is already existed");
        } else if (emailAndPhoneExist) {
            request.setAttribute("errorEP", "Email and Phone number is already existed");
        }
        List<Cinemas> list = dao.getAllCinemas();
        request.setAttribute("cinema", list);

        if (emailExists || phoneExists) {
            request.getRequestDispatcher("/WEB-INF/views/employmentInformation.jsp").forward(request, response);
            return;
        }
        String cinemaName = "";
        List<Cinemas> cinemas = dao.getAllCinemas();
        for (Cinemas c : cinemas) {
            if(c.getCinemaID() == cinemaId){
                cinemaName= c.getName();
            }
        }
        String textContent = "Name: " + name + "\n"
                + "Email: " + email + "\n"
                + "Phone: " + phone + "\n"
                + "Date of Birth: " + dob + "\n"
                + "Address: " + address + "\n"
                + "Position: " + position + "\n"
                + "cinema: " + cinemaName;
        InputStream fileContent = filePart.getInputStream();
        // Define the path to save the file
        String newFileName = generateFileName(filePart);

        Dotenv dotenv = Dotenv.load();
        String folder = dotenv.get("URL_UPLOAD_CV");

        File file = new File(folder, newFileName);
        // Create output stream to write the file
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            int read;
            final byte[] bytes = new byte[1024];
            while ((read = fileContent.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }
        fileContent.close();
        boolean isSuccess = Email.sendEmailWithFile("New employment application received:", address, textContent, folder, newFileName);
        if (isSuccess) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date dobDate = null;
            try {

                dobDate = dateFormat.parse(dob);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
            StaffStatus staff = new StaffStatus(phone, "Pending", address, dobDate, name, email);
            staff.setCinemaId(cinemaId);
            dao.addStaff(staff);
            request.setAttribute("success", "Your application was submitted successfully!");
        } else {
            request.setAttribute("error", "Interal server error!!");
        }
        List<Cinemas> list2 = dao.getAllCinemas();
        request.setAttribute("cinema", list2);
        request.getRequestDispatcher("/WEB-INF/views/employmentInformation.jsp").forward(request, response);

    }

    private String generateFileName(Part filePart) {
        UUID uuid = UUID.randomUUID();
        String originalFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        // Find the last dot to separate the base name and extension
        int lastDot = originalFileName.lastIndexOf('.');
        String baseName = (lastDot == -1) ? originalFileName : originalFileName.substring(0, lastDot);
        String extension = (lastDot == -1) ? "" : originalFileName.substring(lastDot);

        // Return the new file name with the UUID before the extension
        System.out.println(baseName + "-" + uuid.toString() + extension);
        return baseName + "-" + uuid.toString() + extension;
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
