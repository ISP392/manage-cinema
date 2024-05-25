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
            String url = "jdbc:mySQL://localhost:3306/project_cinema_update";
            String username = "root";
            String password = "sa123";
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
