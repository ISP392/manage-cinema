package controller.staff;

import DAO.DAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modal.Users;

/**
 * Servlet implementation class ChooseCustomer
 */
@WebServlet(name = "ChooseCustomer", urlPatterns = {"/chooseCustomer"})
public class ChooseCustomer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/staff-views/listCustomer.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String action = request.getParameter("action");

        if ("guest".equals(action)) {
            session.setAttribute("customerID", null);
            response.sendRedirect("order");
            request.getRequestDispatcher("/WEB-INF/views/staff-views/listCustomer.jsp").forward(request, response);
            return;
        }

        if (email == null || email.isEmpty() || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            request.setAttribute("error", "Email khách hàng không hợp lệ.");
            request.getRequestDispatcher("/WEB-INF/views/staff-views/listCustomer.jsp").forward(request, response);
            return;
        }

        DAO dao = new DAO();
        Users user = dao.getUserByEmail(email);

        if (user != null) {
            session.setAttribute("customerID", user.getUserID());
            request.setAttribute("user", user);
        } else {
            request.setAttribute("error", "Không tìm thấy thông tin khách hàng.");
        }

        request.getRequestDispatcher("/WEB-INF/views/staff-views/listCustomer.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
