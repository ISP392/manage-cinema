//package controller.admin;
//
//import DAO.DAO;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import modal.Users;
//import java.io.IOException;
//import java.util.List;
//import java.util.Random;
//
//@WebServlet(name = "manageCandidates", urlPatterns = {"/manageCandidates"})
//public class manageCandidates extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        try {
//            DAO d = new DAO();
//
//            // Lấy danh sách tất cả người dùng và lưu tạm vào session
//            List<Users> allUsers = getAllUsersTemp(session);
//            session.setAttribute("accountsForApproval", allUsers);
//
//            // Lấy người dùng được phê duyệt từ database
//            List<Users> approvedUsers = d.getApprovedUsers();
//            request.setAttribute("approvedUsers", approvedUsers);
//
//            // Lấy người dùng bị từ chối và lưu tạm vào session
//            List<Users> rejectedUsers = getRejectedUsersTemp(session);
//            session.setAttribute("rejectedUsers", rejectedUsers);
//
//            request.getRequestDispatcher("/WEB-INF/views/admin-views/manageCandidates.jsp").forward(request, response);
//        } catch (Exception e) {
//            throw new ServletException(e);
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String action = request.getParameter("action");
//        int userID = Integer.parseInt(request.getParameter("userID"));
//
//        try {
//            DAO d = new DAO();
//            if ("approve".equals(action)) {
//                String randomUsername = generateRandomString(8);
//                String randomPassword = generateRandomString(12);
//                d.approveUser(userID, randomUsername, randomPassword);
//            } else if ("reject".equals(action)) {
//                d.rejectUser(userID);
//            }
//            response.sendRedirect("manageCandidates");
//        } catch (Exception e) {
//            throw new ServletException(e);
//        }
//    }
//
//    private List<Users> getAllUsersTemp(HttpSession session) {
//        // Thay thế bằng logic thực tế để lấy danh sách tạm thời từ session
//        return (List<Users>) session.getAttribute("accountsForApproval");
//    }
//
//    private List<Users> getRejectedUsersTemp(HttpSession session) {
//        // Thay thế bằng logic thực tế để lấy danh sách tạm thời từ session
//        return (List<Users>) session.getAttribute("rejectedUsers");
//    }
//
//    private String generateRandomString(int length) {
//        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//        StringBuilder stringBuilder = new StringBuilder();
//        Random random = new Random();
//        while (stringBuilder.length() < length) {
//            int index = (int) (random.nextFloat() * chars.length());
//            stringBuilder.append(chars.charAt(index));
//        }
//        return stringBuilder.toString();
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }
//}
