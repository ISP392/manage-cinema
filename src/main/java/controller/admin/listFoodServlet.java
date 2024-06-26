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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import modal.Movies;
import modal.Users;

/**
 *
 * @author ACER
 */
@WebServlet(name = "listFoodServlet", urlPatterns = {"/listFood"})
public class listFoodServlet extends HttpServlet {

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
            out.println("<title>Servlet listFoodServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet listFoodServlet at " + request.getContextPath() + "</h1>");
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

            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            int pageSize = 10;

            int totalMovies = dao.getMovieCount();
            int endPage = totalMovies / pageSize;
            if (totalMovies % pageSize != 0) {
                endPage++;
            }

            List<Movies> listMovies = dao.getMoviesByPage(index, pageSize);

            Date currentDate = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(currentDate);
            cal.add(Calendar.DAY_OF_MONTH, -30);
            Date date30DaysAgo = cal.getTime();

            for (Movies m : listMovies) {
                if (m.getDisplay() == 1) {
                    if (m.getReleaseDate().after(currentDate)) {
                        m.setStatus("Sắp Chiếu");
                    } else if (m.getReleaseDate().after(date30DaysAgo) && m.getReleaseDate().before(currentDate)) {
                        m.setStatus("Đang chiếu");
                    } else {
                        m.setStatus("Đã chiếu");
                    }
                } else if (m.getDisplay() == 0) {
                    m.setStatus("Hidden");
                }
            }

            request.setAttribute("endPage", endPage);
            request.setAttribute("tag", index);
            request.setAttribute("listFoods", listMovies);

            request.getRequestDispatcher("/WEB-INF/views/addOther/listFood.jsp").forward(request, response);
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
