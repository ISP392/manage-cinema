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

import modal.Users;

/**
 *
 * @author MISS NGA
 */
public class DAO extends DBcontext {



    public void add(Users u) {
        String sql = "INSERT INTO Users (displayName, username, password, roleID, email, point) VALUES (?, ?, ?, 2,?,0)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, u.getDisplayName());
            ps.setString(2, u.getUserName());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getEmail());
            ps.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean checkUsername(String username){
        String sql = "SELECT * FROM Users WHERE username = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkEmail(String email){
        String sql = "SELECT * FROM Users WHERE email = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public List<Users> getUsers(){
        String sql = "SELECT * FROM Users";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Users> list = new ArrayList<>();
            while(rs.next()){
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
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        if(dao.checkUsername("abc")){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }

    
}
