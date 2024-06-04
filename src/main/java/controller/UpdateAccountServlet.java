package controller;

import DAO.DAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import modal.UpdateInformation;
import modal.Users;

import java.io.IOException;

@WebServlet(name = "UpdateAccountServlet", value = "/update")
public class UpdateAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users user = (Users) request.getSession().getAttribute("account");
        if (user == null) {
            response.sendRedirect("signin");
        } else {
            request.setAttribute("colorMain", "white");
            request.setAttribute("backgroundColorMain", "red");

            request.setAttribute("colorSecond", "#666");
            request.setAttribute("backgroundColorSecond", "#bfd2d9");
            request.getRequestDispatcher("/WEB-INF/views/updateAccount.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String displayName = request.getParameter("displayName");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        DAO d = new DAO();
        boolean b = d.checkPass(oldPassword, username);
        Users oldUser = d.getUserByUsername(username);
        Users oldUserWithEMail = d.getUserByEmail(email);
        if(username.isEmpty()) {
            UpdateInformation UI = new UpdateInformation("email", oldUserWithEMail.getEmail(), oldUserWithEMail.getDisplayName());
            Users user = new Users(oldUserWithEMail.getEmail(), displayName);
            HttpSession session = request.getSession();
            session.setAttribute("information", UI);
            session.setAttribute("user", user);
            response.sendRedirect("verify");
        }else {
            if (oldPassword.equals("") && newPassword.equals("") && confirmPassword.equals("")) {
                UpdateInformation UI = new UpdateInformation("information", oldUser.getEmail(), oldUser.getDisplayName(), oldUser.getPassword());
                if (d.getUserByUsername(username).getEmail().equals(email)) {
                    Users user = new Users(username, displayName, email);
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    session.setAttribute("information", UI);
                    response.sendRedirect("verify");
                } else if (d.checkEmail(email)) {
                    request.setAttribute("errorEmail", "Email is already existed");
                    request.getRequestDispatcher("/WEB-INF/views/updateAccount.jsp").forward(request, response);
                } else {
                    Users user = new Users(username, displayName, email);
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    session.setAttribute("information", UI);
                    response.sendRedirect("verify");
                }
            } else {
                UpdateInformation UI = new UpdateInformation("password", oldUser.getEmail(), oldUser.getDisplayName(), oldUser.getPassword());
                if (b) {
                    if (d.getUserByUsername(username).getEmail().equals(email)) {
                        Users user = new Users(displayName, username, newPassword, email);
                        HttpSession session = request.getSession();
                        session.setAttribute("user", user);
                        session.setAttribute("information", UI);
                        response.sendRedirect("verify");
                    } else if (d.checkEmail(email)) {
                        request.setAttribute("errorEmail", "Email is already existed");
                        request.getRequestDispatcher("/WEB-INF/views/updateAccount.jsp").forward(request, response);
                    } else {
                        Users user = new Users(displayName, username, newPassword, email);
                        HttpSession session = request.getSession();
                        session.setAttribute("user", user);
                        session.setAttribute("information", UI);
                        response.sendRedirect("verify");
                    }
                } else {
                    request.setAttribute("error", "Old password is incorrect");
                    request.getRequestDispatcher("/WEB-INF/views/updateAccount.jsp").forward(request, response);
                }
            }
        }
    }
}