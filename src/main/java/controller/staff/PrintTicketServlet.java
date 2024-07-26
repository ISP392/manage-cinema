package controller.staff;

import java.io.IOException;
import DAO.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "PrintTicketServlet", urlPatterns = {"/printTicket"})
public class PrintTicketServlet extends HttpServlet {

    DAO dao = new DAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orderID = Integer.parseInt(request.getParameter("orderID"));

        // Update the ticket status to 'used' in the database
        dao.updateTicketStatusToUsed(orderID);

        // Redirect back to the result page with updated status
        response.sendRedirect("homeStaff");
    }
}
