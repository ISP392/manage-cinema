/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.payment;

import java.io.IOException;
import com.paypal.base.rest.PayPalRESTException;

import DAO.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.OrderDetail;
import modal.Users;
import modal.Voucher;

/**
 *
 * @author baoquoc
 */
@WebServlet(name = "Payment", urlPatterns = { "/payment" })
public class Payment extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Users user = (Users) request.getSession().getAttribute("account");
        OrderDetail OD = (OrderDetail) request.getSession().getAttribute("orderDetail");
        String totalMoney = request.getParameter("totalMoney");
        String point = request.getParameter("point");
        OD.setTotalPrice(totalMoney);

        if (user == null || OD == null) {
            response.sendRedirect("home");
            return;
        } else {
            try {
                String voucherID = request.getParameter("voucherIDSelected");
                if (voucherID != "") {
                    DAO dao = new DAO();
                    Voucher voucher = dao.getVoucherByID(Integer.parseInt(voucherID));
                    OD.setVoucherID(voucher);
                }
                OD.setPoint(Integer.parseInt(point));
                PaymentServices paymentServices = new PaymentServices();
                String approvalLink = paymentServices.authorizePayment(OD);
                response.sendRedirect(approvalLink);
            } catch (PayPalRESTException e) {
                e.printStackTrace();
            }
        }
    }

}
