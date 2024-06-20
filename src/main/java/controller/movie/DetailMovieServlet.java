/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.movie;

import DAO.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;
import modal.MovieGenres;
import modal.Movies;
import modal.UserLikeMovie;
import modal.Users;

/**
 *
 * @author caoha
 */
@WebServlet(name="DetailMovieServlet", urlPatterns={"/detail-movie"})
public class DetailMovieServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet DetailMovieServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DetailMovieServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        Users user = (Users) request.getSession().getAttribute("account");
        String movieID = request.getParameter("movieID");
        DAO d = new DAO();
        UserLikeMovie userLikeMovie = d.getLikeCount(Integer.parseInt(movieID));
        Movies m = d.getMovieByID(Integer.parseInt(movieID));
        List<MovieGenres> list = d.getMovieGenres(Integer.parseInt(movieID));
        request.setAttribute("movie", m);
            if (isValidURL(m.getTrailerURL())) {
                request.setAttribute("isTrailer", true);
            } else {
                request.setAttribute("isTrailer", false);
            }
        //create a boolean if m.getReleaseDate() is after now then it is false
        boolean isCommingSoon = false; // Mặc định là false
        Date today = new Date(); // Lấy ngày hiện tại

        // Kiểm tra xem bộ phim có phải là "đang sắp ra mắt" không
        if (m.getReleaseDate().after(today)) {
            isCommingSoon = true;
        }
        if(user != null) {
            if (userLikeMovie == null) {
                request.setAttribute("isLiked", false);
                request.setAttribute("userLikeMovie", 0);
                request.setAttribute("isCommingSoon", isCommingSoon);
                
                request.setAttribute("listGenres", list);
                request.getRequestDispatcher("/WEB-INF/views/detailMovie.jsp").forward(request, response);
                return;
            } else {
                String[] arr = userLikeMovie.getUserID().split(",");
                for (String s : arr) {
                    if (Integer.parseInt(s) == user.getUserID()) {
                        request.setAttribute("isLiked", true);
                        break;
                    } else {
                        request.setAttribute("isLiked", false);
                    }
                }
            }
        }
        request.setAttribute("userLikeMovie", userLikeMovie == null ? 0 : userLikeMovie.getLikeCount());
        request.setAttribute("isCommingSoon", isCommingSoon);
        
        request.setAttribute("listGenres", list);
        request.getRequestDispatcher("/WEB-INF/views/detailMovie.jsp").forward(request, response);
    } 

    public boolean isValidURL(String urlString) {
    try {
        URL url = new URL(urlString);
        HttpURLConnection huc = (HttpURLConnection) url.openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        return (responseCode == HttpURLConnection.HTTP_OK);
    } catch (Exception e) {
        return false;
    }
}

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
