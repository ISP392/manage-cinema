/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import modal.Movies;
import java.util.logging.Level;
import java.util.logging.Logger;
import modal.Role;
import modal.UserGoogleDto;

import modal.Movies;
import modal.Users;
import util.Encrypt;

/**
 *
 * @author MISS NGA
 */
public class DAO extends DBContext {

    public List<Movies> getAllMovieCommingSoon() {
        String sql = "SELECT * FROM movies m WHERE m.releaseDate > CURDATE()";
        List<Movies> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"), rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"),
                        rs.getInt("display"), rs.getString("trailerURL"));
                list.add(m);
            }
            return list;
        } catch (Exception e) {
            System.err.print(e);
        }
        return null;
    }

    public void add(Users u) {
        String sql = "INSERT INTO Users (displayName, username, password, roleID, email, point) VALUES (?, ?, ?, 2,?,0)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, u.getDisplayName());
            ps.setString(2, u.getUserName());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getEmail());
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

    public Users checkLogin(String username, String password) {
        String pass = "";
        try {
            pass = Encrypt.toSHA1(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM users join roles on users.roleID = roles.roleID where username= " + "'" + username + "'" + "and password = " + "'" + pass + "'";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Role r = new Role(rs.getInt("roleID"), "name");
                return new Users(rs.getInt("userID"), rs.getString("userName"), rs.getString("displayName"),
                         rs.getString("password"), rs.getString("email"), r, rs.getInt("point"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkLoginGoogle(String email) {
        String sql = "SELECT * From users Where email = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, email);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addLoginGoogle(Users u) {
        String sql = "INSERT INTO users (displayName, roleID, email, point) VALUES ( ?, 2, ?, 0)";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setString(1, u.getDisplayName());
            pr.setString(2, u.getEmail());

            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
  
    }

}
