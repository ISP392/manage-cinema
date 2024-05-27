package controller.Google;

import DAO.DAO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import modal.UserGoogleDto;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import modal.Users;

@WebServlet(name = "LoginGoogleHandler", value = "/LoginGoogleHandler")
public class LoginGoogleHandler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String accessToken = getToken(code);
        UserGoogleDto user = getUserInfo(accessToken);
        Users u = new Users(user.getEmail(), user.getName());
        HttpSession session = request.getSession();
        DAO d = new DAO();
        if (!d.checkEmail(user.getEmail())) {
            if (!d.checkLoginGoogle(user.getEmail())) {
                d.addLoginGoogle(u);
                session.setAttribute("account", u);
            } else {
                session.setAttribute("account", u);
            }
            session.setAttribute("account", u);
            response.sendRedirect("home");
        } else {
            session.setAttribute("error_1", "Your email is already used");
            response.sendRedirect("signin");
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
