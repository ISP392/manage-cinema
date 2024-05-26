package DAO;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcontext {
    protected Connection connection;

    public DBcontext() {
        try {
            //load .env fileshare lephuon

            Dotenv dotenv = Dotenv.load();
            // register the driver

            //information connection
            String url = dotenv.get("DB_URL");
            String username = dotenv.get("DB_USERNAME");
            String password = dotenv.get("DB_PASSWORD");
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        if(new DBcontext().connection != null){
            System.out.println("Connected");
        }else{
            System.out.println("Not connected");
        }
    }
}
