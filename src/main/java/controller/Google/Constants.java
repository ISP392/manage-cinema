package controller.Google;


import io.github.cdimascio.dotenv.Dotenv;

public class Constants {

    static Dotenv dotenv = Dotenv.load();
    static String localhost = dotenv.get("LOCALHOST");
    public static String GOOGLE_CLIENT_ID = "289651568773-962elblss4e85nrbgrri0i3kcor4pfl8.apps.googleusercontent.com";

    public static String GOOGLE_CLIENT_SECRET = "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";

    public static String GOOGLE_REDIRECT_URI = localhost+"/manage-cinema/LoginGoogleHandler";

    public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";

    public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";

    public static String GOOGLE_GRANT_TYPE = "authorization_code";
}
