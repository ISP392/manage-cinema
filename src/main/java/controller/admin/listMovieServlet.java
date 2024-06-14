package controller.admin;

import DAO.DAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import modal.Movies;

@WebServlet(name = "listMovieServlet", value = "/list_movie")
public class listMovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        request.setAttribute("listMovies", listMovies);
        request.getRequestDispatcher("/WEB-INF/views/admin-views/listMovie.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
