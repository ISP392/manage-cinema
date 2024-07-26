/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import modal.Record;

/**
 *
 * @author baoquoc
 */
public class admin_DAO extends DBContext {
    public int getTotalTicket(){
        int total = 0;
        String sql = "select count(*) from Tickets";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                total = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return total;
    }

    public int getTotalMoney(){
        int total = 0;
        String sql = "select sum(allPrice) from Orders";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                total = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return total;
    }

    public int getTotalStaff(){
        int total = 0;
        String sql = "select count(roleID) from Users where roleID = 3"; 
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                total = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return total;
    }

    public int getTotalUser(){
        int total = 0;
        String sql = "select count(roleID) from Users where roleID = 2";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                total = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return total;
    }

    public List<Record> getCinemaData(String cinemaName){
        List<Record> list = new ArrayList<>();
        String sql = "select u.displayName, s.startTime,s.endTime, s.endAmount - s.startAmount as profit, c.name, s.startAmount, s.endAmount, s.tranferPayment from Shift s join Users u on s.phone = u.userID join staffstatus ss on ss.phone = u.phone join Cinemas c on c.cinemaID = ss.cinemaID where c.name = ? order by startTime desc";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cinemaName);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String displayName = rs.getString(1);
                Timestamp startTime = rs.getTimestamp(2);
                Timestamp endTime = rs.getTimestamp(3);
                int profit = rs.getInt(4);
                String name = rs.getString(5);
                int startAmount = rs.getInt(6);
                int endAmount = rs.getInt(7);
                int tranferPayment = rs.getInt(8);
                list.add(new Record(displayName, startTime, endTime, profit, name, startAmount, endAmount, tranferPayment));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        admin_DAO ad = new admin_DAO();
        List<Record> list = ad.getCinemaData("BANNY Vincom Center Bà Triệu");
        for (Record record : list) {
            System.out.println(record.getTranferPayment());
        }
    }
}
