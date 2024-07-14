package controller.Google;

import DAO.DAO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import modal.UserGoogleDto;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.sql.Timestamp;
import modal.Shift;

import modal.Users;
import modal.staffstatus;

@WebServlet(name = "LoginGoogleHandler", value = "/LoginGoogleHandler")
public class LoginGoogleHandler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String accessToken = getToken(code);
        UserGoogleDto user = getUserInfo(accessToken);
        Users u = new Users(user.getEmail(), user.getName());
        u.setProviderID("google");
        HttpSession session = request.getSession();
        DAO d = new DAO();
        if (!d.checkEmail(user.getEmail())) {
            d.addLoginGoogle(u);
            session.setAttribute("account", u);
        } else {
            u = d.getUserByEmail(user.getEmail());
            session.setAttribute("account", u);
        }

        // kiểm tra ca làm việc của nhân viên
        staffstatus status = d.getStaffStatus(u.getPhone().getPhone());
        if (status == null || !"approve".equals(status.getStatus())) {
            request.getSession().setAttribute("error", "Your account is not approved!");
            response.sendRedirect("signin");
            return;
        }

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        Shift shift = d.getShiftForUser(status.getPhone());

        if (shift == null || currentTime.before(shift.getStartTime()) || currentTime.after(shift.getEndTime())) {
            request.getSession().setAttribute("error", "You are not in your shift time!");
            response.sendRedirect("signin");
        } else {
            session.setAttribute("account", u);
            // Redirect based on user role
            if (u.getRoleID().getRoleID() == 2) {
                response.sendRedirect("home");
            } else if (u.getRoleID().getRoleID() == 3) {
                response.sendRedirect("homeStaff");
            } else {
                // If the role is not 2 or 3, redirect back to signin with an error
                request.getSession().setAttribute("error", "Invalid user role!");
                response.sendRedirect("signin");
            }
        }
    }

    public static String getToken(String code) throws ClientProtocolException, IOException {
        // call api to get token

        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static UserGoogleDto getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();

        UserGoogleDto googlePojo = new Gson().fromJson(response, UserGoogleDto.class);

        return googlePojo;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
