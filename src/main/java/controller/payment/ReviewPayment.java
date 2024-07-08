/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.payment;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.OrderDetail;
import modal.Users;

/**
 *
 * @author baoquoc
 */
@WebServlet(name = "ReviewPayment", urlPatterns = { "/review_payment" })
public class ReviewPayment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Users user = (Users) request.getSession().getAttribute("account");
        OrderDetail OD = (OrderDetail) request.getSession().getAttribute("orderDetail");
        if (user == null || OD == null) {
            response.sendRedirect("home");
            return;
        } else {
            request.getRequestDispatcher("/WEB-INF/views/review_payment.jsp").forward(request,
                    response);
        }
    }
}
