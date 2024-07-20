/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.movie;

import DAO.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import modal.Review;
import modal.Users;

/**
 *
 * @author Miss Nga
 */
@WebServlet(name = "ReviewServlet", urlPatterns = {"/review"})
public class ReviewServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            if (session != null && session.getAttribute("account") != null) {
                Users userLogin = (Users) session.getAttribute("account");
                
                String action = request.getParameter("action") != null ? request.getParameter("action") : "";
                switch (action) {
                    case "delete":
                        String reviewIds = request.getParameter("reviewId");
                        String movieIDs = request.getParameter("movieId");
                        if (reviewIds != null) {
                            
                            int reviewId = Integer.parseInt(reviewIds);
                            DAO dao = new DAO();
                            
                            Review review = new Review();
                            review.setReviewID(reviewId);
                            review.setUserID(userLogin.getUserID());
                            boolean result = dao.deleteCommentByUserId(review);
                            if (result) {
                                request.setAttribute("MESSAGE", "Xóa comment thành công");
                            } else {
                                request.setAttribute("ERROR", "Thất bại");
                            }
                        }
                        request.getRequestDispatcher("detail-movie?movieID="+movieIDs).forward(request, response);
//                        response.sendRedirect("detail-movie?movieID="+movieIDs);
                        break;
                }
            } else {
                response.sendRedirect("signin");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            DAO dao = new DAO();
            Users userLogin = (Users) session.getAttribute("account");
            if (userLogin != null) {
                String comment = request.getParameter("comment");
                String stars = request.getParameter("star");
                String movieIDs = request.getParameter("movieId");
                if (movieIDs != null) {
                    int star = Integer.parseInt(stars);
                    int movieId = Integer.parseInt(movieIDs);
                    
                    Review review = new Review();
                    review.setComment(comment);
                    review.setMovieID(movieId);
                    review.setStarRating(star);
                    review.setUserID(userLogin.getUserID());
                    boolean result = dao.reviewMovieByUser(review);
                    if (!result) {
                        request.setAttribute("ERROR", "Không thể comment");
                    }
                    response.sendRedirect("detail-movie?movieID=" + movieIDs);
                }
            } else {
                response.sendRedirect("signin");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
