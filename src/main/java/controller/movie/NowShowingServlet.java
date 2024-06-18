package controller.movie;

import DAO.DAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import modal.Movies;

@WebServlet(name = "NowShowingServlet", value = "/nowShowing")
public class NowShowingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO d = new DAO();
        List<Movies> movies = d.getMovie(false);
        request.setAttribute("movies", movies);
        request.getRequestDispatcher("/WEB-INF/views/nowShowing.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}