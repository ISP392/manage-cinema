package controller.staff;

import DAO.DAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.FoodItem;
import modal.Orders;
import modal.TicketInfo;

@WebServlet(name="CheckTicketServlet", urlPatterns={"/checkTicket"})
public class CheckTicketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String orderId = request.getParameter("orderID");
        if (orderId != null && !orderId.isEmpty()) {
            request.setAttribute("orderID", orderId);
        }
        request.getRequestDispatcher("/WEB-INF/views/staff-views/checkticket.jsp").forward(request, response);
    }

    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        DAO d = new DAO();
    String userId = req.getParameter("userID");
    String orderId = req.getParameter("orderID");

    // Kiểm tra nếu orderId null hoặc rỗng thì cố gắng lấy từ userId
    if (orderId == null || orderId.isEmpty()) {
        if (userId != null && !userId.isEmpty()) {
            orderId = d.getOrderIDByUserID(userId);
        } else {
            // Nếu cả orderId và userId đều null hoặc rỗng, báo lỗi
            req.setAttribute("error", "Vui lòng nhập mã đặt vé hoặc mã khách hàng.");
            req.getRequestDispatcher("/WEB-INF/views/staff-views/result.jsp").forward(req, resp);
            return;
        }
    }

    // Tiếp tục xử lý với orderId đã có
    Orders order = d.getOrderById(orderId);
    List<TicketInfo> ticketInfos = d.getTicketInfoByOrderId(orderId);
    List<FoodItem> foodItems = d.getFoodItemsByOrderId(orderId);

    if (order != null) {
        req.setAttribute("order", order);
        req.setAttribute("ticketInfos", ticketInfos);
        req.setAttribute("foodItems", foodItems);
    } else {
        req.setAttribute("error", "Thông tin không hợp lệ.");
    }
    req.getRequestDispatcher("/WEB-INF/views/staff-views/result.jsp").forward(req, resp);
    }
}
