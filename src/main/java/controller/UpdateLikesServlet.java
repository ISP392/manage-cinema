package controller;

import DAO.DAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import modal.UserLikeMovie;
import modal.Users;

import java.io.IOException;

@WebServlet(name = "UpdateLikesServlet", value = "/updateLikesServlet")
public class UpdateLikesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy ID của phim từ yêu cầu
        String movieId = request.getParameter("id");
        String userID = request.getParameter("userID");


        // Lấy trạng thái "thích" từ yêu cầu
        boolean userHasLiked = Boolean.parseBoolean(request.getParameter("like"));
        // Cập nhật số lượt thích trong cơ sở dữ liệu
        // Giả sử bạn có một lớp MovieService để thực hiện các thao tác với cơ sở dữ liệu
        DAO movieService = new DAO();
        if (userHasLiked) {
            movieService.incrementLikes(movieId, userID);
        } else {
            movieService.decrementLikes(movieId, userID);
        }
        UserLikeMovie u = movieService.getLikeCount(Integer.parseInt(movieId));
        int newLikeCount = 0;
        if(u != null){
            newLikeCount = movieService.getLikeCount(Integer.parseInt(movieId)).getLikeCount();
        }

        // Trả về số lượt thích mới
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(String.valueOf(newLikeCount));
    }
}