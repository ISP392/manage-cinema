/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modal.Users;

/**
 *
 * @author MISS NGA
 */
public class DAO extends DBcontext {
    private Connection con;
    private PreparedStatement prst;
    private ResultSet rs;

    public boolean checkUser(String username) {
        String sql = "SELECT * FROM Users WHERE username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public void add(Users u) {
        String sql = "INSERT INTO Users (displayName, username, password, roleID) VALUES (?, ?, ?, 2)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, u.getDisplayName());
            ps.setString(2, u.getUsername());
            ps.setString(3, u.getPassword());
            ps.executeUpdate();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    
}
