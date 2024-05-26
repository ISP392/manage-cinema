/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modal.Role;

import modal.Users;

/**
 *
 * @author MISS NGA
 */
public class DAO extends DBcontext {
    
    
    public void add(Users u) {
        String sql = "INSERT INTO Users (displayName, username, password, roleID, email, point) VALUES (?, ?, ?, ?,?,0)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, u.getDisplayName());
            ps.setString(2, u.getUserName());
            ps.setString(3, u.getPassword());
            ps.setInt(4, 2);
            ps.setString(5, u.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkUsername(String username) {
        String sql = "SELECT * FROM Users WHERE username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkEmail(String email) {
        String sql = "SELECT * FROM Users WHERE email = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Users> getUsers() {
        String sql = "SELECT * FROM Users";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Users> list = new ArrayList<>();
            while (rs.next()) {
                Users u = new Users();
                u.setUserID(rs.getInt("userID"));
                u.setDisplayName(rs.getString("displayName"));
                u.setUserName(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setPoint(rs.getInt("point"));
                list.add(u);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Users checkLogin(String username, String password) {
        String sql = "select * from Users join [Role] on Users.roleID = Role.roleID where username = ? and password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            Role r;
            if (rs.next()) {
                String role = "";
                if (rs.getString("name").equals("admin")) {
                    role = "admin";
                } else {
                    role = "user";
                }
                r = new Role(rs.getInt("roleID"), role);
                return new Users(rs.getInt("userID"), rs.getString("displayName"), username, 
                        password,rs.getString("email"), r, rs.getInt("point"));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public Users checkLoginGoogle(String email) {
        Users user = null;
        String sql = "SELECT userID From users Where email = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, email);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                int userID = rs.getInt("userID");
                user = new Users(userID, email);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public int AddLoginGoogle(Users user) {
        int number = 0;
        String sql = "INSERT INTO Users (displayName, password, roleID, email, point) VALUES (?, ?, 2,?,0)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getDisplayName());
            ps.setString(3, user.getPassword());

            number = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return number;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        String testEmail = "qtran6859@gmail.com";
        Users user = dao.checkLoginGoogle(testEmail);
        if (user != null) {
            System.out.println("User found: " + user.getUserID() + ", " + user.getEmail());
        } else {
            System.out.println("User not found with email: " + testEmail);
        }

    }

}
