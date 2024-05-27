package DAO;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    public Connection connection;

    public DBContext() {
        try {
            // Load các biến môi trường từ file .env
            Dotenv dotenv = Dotenv.load();

            // Lấy thông tin kết nối từ biến môi trường
            String url = dotenv.get("DB_URL");
            String username = dotenv.get("DB_USERNAME");
            String password = dotenv.get("DB_PASSWORD");

            // Đăng ký driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Tạo kết nối đến cơ sở dữ liệu
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (new DBContext().connection != null) {
            System.out.println("Connected");
        } else {
            System.out.println("Not connected");
        }
    }
}
