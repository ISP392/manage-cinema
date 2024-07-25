/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DAO.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.FoodItem;
import modal.OrderDetail;
import modal.Orders;
import modal.Users;
import modal.Voucher;

/**
 *
 * @author baoquoc
 */
@WebServlet(name = "OrderServlet", urlPatterns = {"/order"})
public class OrderServlet extends HttpServlet {

    DAO dao = new DAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("orderDetail") == null) {
            response.sendRedirect("home");
        } else {
            Users user = (Users) request.getSession().getAttribute("account");

            List<Voucher> vouchers = dao.getVoucherByUserID(user.getUserID());
            OrderDetail orderDetail = (OrderDetail) request.getSession().getAttribute("orderDetail");

            String foodItems = request.getParameter("orderDetails");
            if (foodItems != null && !foodItems.isEmpty()) {
                parseOrderAndStoreInFoodMap(foodItems, orderDetail);
            }

            request.setAttribute("orderDetail", orderDetail);
            request.setAttribute("vouchers", vouchers);
            if (user.getRoleID().getRoleID() == 3) {
                request.getRequestDispatcher("/WEB-INF/views/staff-views/listCustomer.jsp").forward(request,
                        response);
            } else {
                request.getRequestDispatcher("/WEB-INF/views/order.jsp").forward(request,
                        response);
            }
        }
    }
    private void parseOrderAndStoreInFoodMap(String order, OrderDetail orderDetail) {
        String[] items = order.split(", ");
        Map<FoodItem, Integer> foodMap = new HashMap<>();

        for (int i = 0; i < items.length; i += 2) {
            FoodItem foodItem = dao.getFoodByName(items[i]);
            int quantity = Integer.parseInt(items[i + 1]);

            foodMap.put(foodItem, quantity);
        }
        orderDetail.setFoodMap(foodMap);
    }
}
