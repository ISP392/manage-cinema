package DAO;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcontext {
    public static Connection getConnection() {
        Connection c = null;
        try{
            //load .env fileshare lephuon
            Dotenv dotenv = Dotenv.configure()
                    .directory("src/main/resources")
                    .load();
            // register the driver
             
            //information connection
            String url = dotenv.get("DB_URL");
            String username = dotenv.get("DB_USERNAME");
            String password = dotenv.get("DB_PASSWORD");

            //create a connection
            c = DriverManager.getConnection(url, username, password);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static void main(String[] args){
        Connection c = DBcontext.getConnection();
        if(c != null){
            System.out.println("Connect successfully");
        }else{
            System.out.println("Connect failure");
        }
    }
}
