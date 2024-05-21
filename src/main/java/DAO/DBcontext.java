package DAO;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcontext {
    public static Connection getConnection() {
        Connection c = null;
        try{
            //load .env file
            Dotenv dotenv = Dotenv.configure()
                    .directory("src/main/resources")
                    .load();
            // register the driver
             
            //information connection
            String url = dotenv.get("jdbc:mySQL://localhost:3306/project_cinema_update");
            String username = dotenv.get("root");
            String password = dotenv.get("12345");

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
