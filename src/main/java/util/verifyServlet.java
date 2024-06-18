package util;

import DAO.DAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import modal.UpdateInformation;
import modal.Users;
import util.Email;

import java.io.IOException;
import java.util.Random;

@WebServlet(name = "verifyServlet", value = "/verify")
public class verifyServlet extends HttpServlet {

    int code = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users user = (Users) request.getSession().getAttribute("account");
        Users userAccount = (Users) request.getSession().getAttribute("user");
        if (user == null && userAccount == null) {
            response.sendRedirect("signin");
        } else {
            Random random = new Random();
            code = random.nextInt(900000) + 100000;

            Users u = (Users) request.getSession().getAttribute("user");
            UpdateInformation UI = (UpdateInformation) request.getSession().getAttribute("information");
            if (UI != null) {
                if (UI.getInformation().equals("information")) {
                    if (UI.getOldEmail().equals(u.getEmail()) && !UI.getOldDisplayName().equals(u.getDisplayName())) {
                        Email.sendEmail(u.getEmail(), "Code", "You just updated your display name from " + UI.getOldDisplayName() + " to " + u.getDisplayName() + ", Your code is: " + code);
                    } else if (!UI.getOldEmail().equals(u.getEmail()) && UI.getOldDisplayName().equals(u.getDisplayName())) {
                        Email.sendEmail(u.getEmail(), "Code", "You just updated your email from " + UI.getOldEmail() + " to " + u.getEmail() + ", Your code is: " + code);
                    } else if (!UI.getOldEmail().equals(u.getEmail()) && !UI.getOldDisplayName().equals(u.getDisplayName())) {
                        Email.sendEmail(u.getEmail(), "Code", "You just updated your display name from " + UI.getOldDisplayName() + " to " + u.getDisplayName() + " and your email from " + UI.getOldEmail() + " to " + u.getEmail() + ", Your code is: " + code);
                    }
                } else if (UI.getInformation().equals("password")) {
                    // Thay đổi chỉ mật khẩu
                    if (!UI.getOldPassword().equals(u.getPassword()) && UI.getOldEmail().equals(u.getEmail()) && UI.getOldDisplayName().equals(u.getDisplayName())) {
                        Email.sendEmail(u.getEmail(), "Code", "You just updated your password. Your code is: " + code);
                    } // Thay đổi mật khẩu và display name
                    else if (!UI.getOldPassword().equals(u.getPassword()) && !UI.getOldDisplayName().equals(u.getDisplayName()) && UI.getOldEmail().equals(u.getEmail())) {
                        Email.sendEmail(u.getEmail(), "Code", "You just updated your display name from " + UI.getOldDisplayName() + " to " + u.getDisplayName() + " and your password. Your code is: " + code);
                    } // Thay đổi mật khẩu và email
                    else if (!UI.getOldPassword().equals(u.getPassword()) && !UI.getOldEmail().equals(u.getEmail()) && UI.getOldDisplayName().equals(u.getDisplayName())) {
                        Email.sendEmail(u.getEmail(), "Code", "You just updated your email from " + UI.getOldEmail() + " to " + u.getEmail() + " and your password. Your code is: " + code);
                    } // Thay đổi mật khẩu, display name và email
                    else if (!UI.getOldPassword().equals(u.getPassword()) && !UI.getOldEmail().equals(u.getEmail()) && !UI.getOldDisplayName().equals(u.getDisplayName())) {
                        Email.sendEmail(u.getEmail(), "Code", "You just updated your display name from " + UI.getOldDisplayName() + " to " + u.getDisplayName() + ", your email from " + UI.getOldEmail() + " to " + u.getEmail() + " and your password. Your code is: " + code);
                    }
                } else if (UI.getInformation().equals("email")) {
                    Email.sendEmail(u.getEmail(), "Code", "You just updated your display name from " + UI.getOldDisplayName() + " to " + u.getDisplayName() + ", Your code is: " + code);
                } else if (UI.getInformation().equals("forgot")) {
                    Email.sendEmail(userAccount.getEmail(), "Code", "You have just requested to change your password, Your code is: " + code);
                }
            } else {
                Email.sendEmail(u.getEmail(), "Code", "You have just registered a new account, Your code is: " + code);
            }
            request.getRequestDispatcher("/WEB-INF/views/verify.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO dao = new DAO();
        try {
            if (Integer.parseInt(request.getParameter("otp-code")) == code) {
                Users u = (Users) request.getSession().getAttribute("user");
                UpdateInformation UI = (UpdateInformation) request.getSession().getAttribute("information");
                if (UI != null) {
                    if (UI.getInformation().equals("information")) {
                        dao.updateDisplayNameAndEmail(u.getDisplayName(), u.getEmail(), u.getUserName());
                        request.getSession().removeAttribute("information");
                        response.sendRedirect("signin");
                    } else if (UI.getInformation().equals("password")) {
                        dao.updateUser(u);
                        request.getSession().removeAttribute("information");
                        response.sendRedirect("signin");
                    } else if (UI.getInformation().equals("email")) {
                        dao.updateDisplayNameByEmail(u.getEmail(), u.getDisplayName());
                        request.getSession().removeAttribute("information");
                        response.sendRedirect("signin");
                    } else if (UI.getInformation().equals("forgot")) {
                        request.getSession().removeAttribute("information");
                        response.sendRedirect("new_password");
                    }

                } else {
                    request.getSession().removeAttribute("user");
                    dao.add(u);
                    request.getRequestDispatcher("/WEB-INF/views/signIn.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("error", "Invalid code");
                request.getRequestDispatcher("/WEB-INF/views/verify.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid code");
            request.getRequestDispatcher("/WEB-INF/views/verify.jsp").forward(request, response);
        }

    }
}
