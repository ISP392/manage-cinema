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
import modal.*;
import util.Encrypt;
import java.sql.Timestamp;
import java.util.Arrays;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author MISS NGA
 */
public class DAO extends DBContext {

    public List<FoodItem> getFoodByPage(int page, int pageSize) {
        List<FoodItem> list = new ArrayList<>();
        String sql = "SELECT * FROM FoodItems ORDER BY foodItemID ASC LIMIT ? OFFSET ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, pageSize);
            ps.setInt(2, (page - 1) * pageSize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FoodItem f = new FoodItem(rs.getInt("FoodItemID"),
                        rs.getString("foodName"),
                        rs.getString("description"),
                        rs.getInt("price"), 
                        rs.getString("imgFoodItems"),
                        rs.getInt("display"),
                        rs.getInt("quantity")
                );
                list.add(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean checkEPstaff(String email, String phone) {
        String sql = "SELECT * FROM staffstatus WHERE staffEmail = ? or phone = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, phone);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkEPusers(String email, String phone) {
        String sql = "SELECT * FROM users WHERE email = ? or phone = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.setString(1, email);
            ps.setString(2, phone);
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Movies> searchMovies(String query) {
        List<Movies> list = new ArrayList<>();
        try {
            String sql = "select * from movies where title like ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + query + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movies movie = new Movies(
                        rs.getInt("movieID"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDate("releaseDate"),
                        rs.getString("posterImage"),
                        rs.getInt("duration"),
                        rs.getInt("display"),
                        rs.getString("trailerURL"),
                        rs.getString("slug"));
                list.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public String getPoint(int userId) {
        String sql = "SELECT point FROM Users where userID = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int point = rs.getInt("point");
                if (point >= 1000) {
                    return "Platinum";
                } else if (point >= 500) {
                    return "gold";
                } else if (point >= 100) {
                    return "Silver";
                } else {
                    return "Bronze";
                }
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return " ";
    }

    public void insertAddFood(String foodName, String description, int price, String imgFoodItems, int quantity) {
        String sql = "INSERT INTO FoodItems (foodName, description, price, imgFoodItems, quantity, display) VALUES (?, ?, ?, ?, ?, 1)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, foodName);
            ps.setString(2, description);
            ps.setInt(3, price);
            ps.setString(4, imgFoodItems);
            ps.setInt(5, quantity);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateFoodById(String foodName, String description, int price, String imgFoodItems, int quantity, int foodItemId) {
        String sql = "UPDATE FoodItems SET foodName = ?, description = ?, price = ?, imgFoodItems = ?, quantity = ? WHERE foodItemId = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, foodName);
            ps.setString(2, description);
            ps.setInt(3, price);
            ps.setString(4, imgFoodItems);
            ps.setInt(5, quantity);
            ps.setInt(6, foodItemId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    
    public void insertAddVoucher(String voucherName, String voucherdescription, float discountAmount, Date startDate,
            Date endDate, int quantity) {
        String sql = "INSERT INTO Voucher (voucherName, voucherdescription, discountAmount, startDate, endDate, quantity) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, voucherName);
            ps.setString(2, voucherdescription);
            ps.setFloat(3, discountAmount);
            ps.setDate(4, startDate);
            ps.setDate(5, endDate);
            ps.setInt(6, quantity);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public Movies getMovieByIDForAddSlot(int movieID) {
        String sql = "select * from Movies as m where movieID = ? and releaseDate BETWEEN DATE_ADD(CURDATE(), INTERVAL -30 DAY) AND CURDATE() ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, movieID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movies m = new Movies(
                        rs.getInt("movieID"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDate("releaseDate"),
                        rs.getString("posterImage"),
                        rs.getInt("duration"),
                        rs.getInt("display"),
                        rs.getString("trailerUrl"));
                return m;
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for better debugging
        }
        return null;
    }
    
    public void updateDisplayMovieByMovieID(int movieID, int display) {
        String sql = "update Movies set display = ? where Movies.movieID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, display);
            ps.setInt(2, movieID);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    
    public void updateDisplayFoodByFoodID(int foodID, int display) {
        String sql = "update FoodItems set display = ? where foodItemId = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, display);
            ps.setInt(2, foodID);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Movies> getMoviesByPage(int page, int pageSize) {
        List<Movies> list = new ArrayList<>();
        String sql = "SELECT * FROM Movies ORDER BY releaseDate DESC LIMIT ? OFFSET ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, pageSize);
            ps.setInt(2, (page - 1) * pageSize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movies m = new Movies(
                        rs.getInt("movieID"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDate("releaseDate"),
                        rs.getString("posterImage"),
                        rs.getInt("duration"),
                        rs.getInt("display"),
                        rs.getString("trailerURL"));
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public int getMovieCount() {
        String sql = "SELECT COUNT(*) FROM Movies";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public List<Movies> getAllMovieCommingSoon() {
        String sql = "SELECT * FROM Movies m WHERE m.releaseDate > CURDATE()";
        List<Movies> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"),
                        rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"),
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

    // check email and password == null
    public boolean checkEmailAndPasswordNull(String email) {
        String sql = "SELECT * FROM Users WHERE email = ? AND (password = '' or password is null)";
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
    
    public List<Users> getUsers(int offset, int noOfRecords) {
        String sql = "SELECT * FROM Users LIMIT ?, ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, offset);
            ps.setInt(2, noOfRecords);
            ResultSet rs = ps.executeQuery();
            List<Users> list = new ArrayList<>();
            while (rs.next()) {
                Role r = new Role(rs.getInt("roleID"));
                Users u = new Users();
                u.setUserID(rs.getInt("userID"));
                u.setDisplayName(rs.getString("displayName"));
                u.setUserName(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setPoint(rs.getInt("point"));
                u.setRoleID(r);
                list.add(u);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int getNoOfRecords() {
        String sql = "SELECT COUNT(*) FROM Users";
        try (
                PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public List<Users> getUserById(int id) {
        String sql = "SELECT * FROM Users where userID=" + id;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Users> list = new ArrayList<>();
            while (rs.next()) {
                Role r = new Role(rs.getInt("roleID"));
                
                Users u = new Users();
                u.setUserID(rs.getInt("userID"));
                u.setDisplayName(rs.getString("displayName"));
                u.setUserName(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setPoint(rs.getInt("point"));
                u.setRoleID(r);
                list.add(u);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update the user's role in the database
    public void updateUserRole(int userID, int roleID) {
        String sql = "UPDATE Users SET roleID = ? WHERE userID = ?";
        try (
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, roleID);
            stmt.setInt(2, userID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // check login of user
    public Users checkLogin(String username, String password) {
        String pass = "";
        try {
            pass = Encrypt.toSHA1(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM Users join Roles on Users.roleID = Roles.roleID where username= " + "'" + username
                + "'" + "and password = " + "'" + pass + "'";
        try {
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                StaffStatus phone = getStaffStatus(rs.getString("phone"));
                Role r = new Role(rs.getInt("roleID"), rs.getString("name"));
                return new Users(rs.getInt("userID"), rs.getString("displayName"), rs.getString("userName"), rs.getString("password"),
                        r, rs.getString("email"), rs.getString("providerID"), rs.getInt("point"), phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public StaffStatus getStaffStatus(String phone) {
        StaffStatus status = null;
        String query = "SELECT * FROM staffstatus WHERE phone = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                status = new StaffStatus();
                status.setPhone(rs.getString("phone"));
                status.setStatus(rs.getString("status"));
                status.setAddress(rs.getString("address"));
                status.setDob(rs.getDate("dob"));
                status.setStaffName(rs.getString("staffName"));
                status.setStaffEmail(rs.getString("staffEmail"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
        
    }

    public List<Shift> getShiftsForUser(String phone) {
        List<Shift> shifts = new ArrayList<>();
        String query = "SELECT Shift.*, ss.status, ss.address, ss.dob, ss.staffName, ss.staffEmail, Users.phone AS staffPhone "
                + "FROM Shift "
                + "JOIN Users ON Shift.phone = Users.userID "
                + "JOIN staffstatus ss ON Users.phone = ss.phone "
                + "WHERE Shift.phone = ?";
    
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StaffStatus staffStatus = new StaffStatus(rs.getString("staffPhone"), rs.getString("status"), rs.getString("address"), rs.getDate("dob"), rs.getString("staffName"), rs.getString("staffEmail"));
                Shift shift = new Shift(rs.getInt("shiftID"), staffStatus, rs.getTimestamp("startTime"), rs.getTimestamp("endTime"), rs.getDouble("startAmount"), rs.getDouble("endAmount"));
                shifts.add(shift);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shifts;
    }

    public boolean isUserInCurrentShift(String phone) {
        List<Shift> shifts = getShiftsForUser(phone);
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        for (Shift shift : shifts) {
            if (currentTime.after(shift.getStartTime()) && currentTime.before(shift.getEndTime())) {
                return true;
            }
        }
        return false;
    }

    // check login of admin
    public Users checkLoginAdmin(String username, String password) {
        String pass = "";
        try {
            pass = Encrypt.toSHA1(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM Users join Roles on Users.roleID = Roles.roleID where username= " + "'" + username
                + "'" + "and password = " + "'" + pass + "'" + "AND Roles.roleID = 1";
        try {
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Role r = new Role(rs.getInt("roleID"), rs.getString("name"));
                return new Users(rs.getInt("userID"), rs.getString("displayName"), rs.getString("userName"),
                        rs.getString("password"), rs.getString("email"), r, rs.getInt("point"),
                        rs.getString("providerID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void addLoginGoogle(Users u) {
        String sql = "INSERT INTO Users (displayName, roleID, email,providerID, point) VALUES ( ?, 2, ?,'google', 0)";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setString(1, u.getDisplayName());
            pr.setString(2, u.getEmail());
            
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Movies> getMovie(boolean isLimit) {
        String sql = "SELECT * FROM project_cinema_update.Movies m WHERE m.releaseDate BETWEEN DATE_ADD(CURDATE(), INTERVAL -30 DAY) AND CURDATE() ORDER BY m.releaseDate asc;";
        if (isLimit) {
            sql = sql.substring(0, sql.length() - 1) + " limit 4;";
        }
        List<Movies> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"),
                        rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"),
                        rs.getInt("display"), rs.getString("trailerURL"));
                list.add(m);
            }
            return list;
        } catch (Exception e) {
            System.err.print(e);
        }
        return null;
    }

    // lấy những phim đang chiếu để add slot
    public List<Movies> getMovie() {
        String sql = "SELECT * FROM Movies m WHERE m.releaseDate BETWEEN DATE_ADD(CURDATE(), INTERVAL -30 DAY) AND CURDATE() ORDER BY m.releaseDate asc";
        
        List<Movies> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"),
                        rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"),
                        rs.getInt("display"), rs.getString("trailerURL"));
                list.add(m);
            }
            return list;
        } catch (Exception e) {
            System.err.print(e);
        }
        return null;
    }
    
    public Movies getMovieByName(String name) {
        String sql = "select  * from project_cinema_update.Movies where title =   ?";
        
        Movies list = new Movies();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"),
                        rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"),
                        rs.getInt("display"), rs.getString("trailerURL"));
                return m;
            }
            return list;
        } catch (Exception e) {
            System.err.print(e);
        }
        return null;
    }
    
    public List<Movies> getMovieByGenreID(int genreID) {
        List<Movies> list = new ArrayList<>();
        String sql = "SELECT * FROM Movies m JOIN MovieGenres mg ON m.movieID = mg.movieID JOIN Genres g ON mg.genreID = g.genreID WHERE mg.genreID = ? AND m.releaseDate >= DATE_ADD(CURDATE(), INTERVAL -30 DAY);";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, genreID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"),
                        rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"),
                        rs.getInt("display"), rs.getString("trailerUrl"), rs.getString("name"));
                list.add(m);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public boolean checkPass(String password, String username) {
        String sql = "select password from Users where username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String acctualPass = rs.getString("password");
                return Encrypt.toSHA1(password).equals(acctualPass);
            }
        } catch (SQLException | NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return false;
    }
    
    public void updateDisplayNameAndEmail(String displayName, String email, String username) {
        String sql = "update Users set displayName = ?, email = ? where username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, displayName);
            ps.setString(2, email);
            ps.setString(3, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // update displayname by email
    public void updateDisplayNameByEmail(String email, String displayName) {
        String sql = "update Users set displayName = ? where email = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, displayName);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // update user
    public void updateUser(Users u) {
        String sql = "update Users set displayName = ?, email = ?, password = ? where username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, u.getDisplayName());
            ps.setString(2, u.getEmail());
            ps.setString(3, Encrypt.toSHA1(u.getPassword()));
            ps.setString(4, u.getUserName());
            ps.executeUpdate();
        } catch (SQLException | NoSuchAlgorithmException e) {
            System.out.println(e);
        }
    }

    // get user by username
    public Users getUserByUsername(String username) {
        String sql = "select * from Users where username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Role r = new Role(rs.getInt("roleID"));
                Users u = new Users(rs.getInt("userID"), rs.getString("displayName"), rs.getString("username"),
                        rs.getString("password"), rs.getString("email"), r, rs.getInt("point"),
                        rs.getString("providerID"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // get user by email
    public Users getUserByEmail(String email) {
        String sql = "select * from Users where email = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                StaffStatus phone = getStaffStatus(rs.getString("phone"));
                Role r = new Role(rs.getInt("roleID"));
                Users u = new Users(rs.getInt("userID"), rs.getString("displayName"), rs.getString("userName"), rs.getString("password"),
                        r, rs.getString("email"), rs.getString("providerID"), rs.getInt("point"), phone);
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // void get list<movieGenres> by movieID
    public List<MovieGenres> getMovieGenres(int movieID) {
        List<MovieGenres> list = new ArrayList<>();
        String sql = "select * from MovieGenres mg "
                + "join Movies m on mg.movieID = m.movieID "
                + "join Genres g on mg.genreID = g.genreID "
                + "where m.movieID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, movieID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Genres g = new Genres(rs.getInt("genreID"), rs.getString("name"));
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"),
                        rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"),
                        rs.getInt("display"), rs.getString("trailerUrl"));
                MovieGenres mg = new MovieGenres(rs.getInt("movieGenresID"), g, m);
                list.add(mg);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // get count of like by movieID
    public UserLikeMovie getLikeCount(int movieID) {
        String sql = "SELECT movieID, COUNT(userID) AS likeCount, GROUP_CONCAT(userID) AS userID FROM UserLikes WHERE movieID = ? GROUP BY movieID";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, movieID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new UserLikeMovie(rs.getString("userID"), rs.getInt("movieID"), rs.getInt("likeCount"));
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void incrementLikes(String movieId, String userID) {
        String sql = "INSERT INTO UserLikes (movieID, userID) VALUES (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(movieId));
            ps.setInt(2, Integer.parseInt(userID));
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void decrementLikes(String movieId, String userID) {
        String sql = "DELETE FROM UserLikes WHERE movieID = ? AND userID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(movieId));
            ps.setInt(2, Integer.parseInt(userID));
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public String getGenreNameByID(int genreID) {
        String sql = "SELECT name FROM Genres WHERE genreID = ?";
        String genreName = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, genreID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                genreName = rs.getString("name");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return genreName;
    }

    // insert new movie
    public void insertNewMovie(String title, String description, Date releaseDate, String uniqueFileName, int duration,
            String trailerUrl) {
        String sql = "INSERT INTO Movies (title, description, releaseDate, posterImage, duration, trailerUrl, likeCount, display) VALUES (?, ?, ?, ?, ?, ?, 0, 1)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, description);
            ps.setDate(3, releaseDate);
            ps.setString(4, uniqueFileName);
            ps.setInt(5, duration);
            ps.setString(6, trailerUrl);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // get movie recently added
    public Movies getMovieRecentlyAdded() {
        String sql = "SELECT * FROM Movies ORDER BY movieID DESC LIMIT 1";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"),
                        rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"),
                        rs.getInt("display"), rs.getString("trailerUrl"));
                return m;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // insert movie genre
    public void insertMovieGenre(int genreID, int movieID) {
        String sql = "INSERT INTO MovieGenres (genreID, movieID) VALUES (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, genreID);
            ps.setInt(2, movieID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // update password by email
    public void updatePasswordByEmail(String email, String password) {
        String sql = "UPDATE Users SET password = ? WHERE email = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // update movie by movieID
    public void updateMovieByID(String title, String description, Date releaseDate, String posterImage, int duration,
            String trailerUrl, int movieID) {
        String sql = "UPDATE Movies SET title = ?, description = ?, releaseDate = ?, posterImage = ?, duration = ?, trailerUrl = ? WHERE movieID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, description);
            ps.setDate(3, releaseDate);
            ps.setString(4, posterImage);
            ps.setInt(5, duration);
            ps.setString(6, trailerUrl);
            ps.setInt(7, movieID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    

    // delete movie genre by movieID
    public void deleteMovieGenreByMovieID(int movieID) {
        String sql = "DELETE FROM MovieGenres WHERE movieID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, movieID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // count paging tickets by userID
    public int countPagingTickets(int userID) {
        String sql = "select count(*) from Tickets where userID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rs.getInt(1);// Get first integer value of rs and assign count
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    // paging list tickets by userID
    public List<Tickets> pagingTickets(int userID, int index) {
        List<Tickets> list = new ArrayList<>();
        List<Integer> ticketIDs = new ArrayList<>();
        String sql = "SELECT t.ticketID, u.userID, u.displayName, u.username, u.password, u.email, u.providerID, u.point, "
                + "r.roleID, r.name AS roleName, "
                + "m.movieID, m.title, m.description, m.releaseDate, m.posterImage, m.duration, m.display, "
                + "c.cinemaID, c.name AS cinemaName, c.movieDate, "
                + "l.locationID, l.name AS locationName, "
                + "st.screeningID, st.startTime, st.endTime, "
                + "th.theaterID, th.theaterNumber, "
                + "s.seatID, s.seatNumber, s.seatStatus, "
                + "o.orderID, o.quantity, o.allPrice, "
                + "t.price, t.purchaseDate "
                + "FROM Tickets t "
                + "JOIN Users u ON t.userID = u.userID "
                + "JOIN Roles r ON u.roleID = r.roleID "
                + "JOIN Movies m ON t.movieID = m.movieID "
                + "JOIN Cinemas c ON t.cinemaID = c.cinemaID "
                + "JOIN Location l ON c.locationID = l.locationID "
                + "JOIN Seats s ON t.seatID = s.seatID "
                + "JOIN ScreeningTimes st ON s.screeningID = st.screeningID "
                + "JOIN Theaters th ON st.theaterID = th.theaterID "
                + "JOIN Orders o ON t.orderID = o.orderID "
                + "WHERE t.userID = ? LIMIT ?, 5";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userID);
            ps.setInt(2, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role(rs.getInt("roleID"), rs.getString("roleName"));
                Users user = new Users(rs.getInt("userID"), rs.getString("displayName"), rs.getString("username"), rs.getString("password"), rs.getString("email"), role, rs.getInt("point"), rs.getString("providerID"));
                Location location = new Location(rs.getInt("locationID"), rs.getString("locationName"));
                Cinemas cinema = new Cinemas(rs.getInt("cinemaID"), rs.getString("cinemaName"), rs.getDate("movieDate"), location);
                Movies movie = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"), rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"), rs.getInt("display"));
                Theaters theater = new Theaters(rs.getInt("theaterID"), cinema, rs.getInt("theaterNumber"));
                ScreeningTimes screeningTime = new ScreeningTimes(rs.getInt("screeningID"), theater, movie, rs.getTimestamp("startTime"), rs.getTimestamp("endTime"));
                Seats seat = new Seats(rs.getInt("seatID"), screeningTime, rs.getString("seatNumber"), rs.getString("seatStatus"));
                Orders order = new Orders(rs.getInt("orderID"), user, movie, rs.getInt("quantity"), rs.getString("allPrice"));
                Tickets ticket = new Tickets(rs.getInt("ticketID"), user, movie, cinema, rs.getString("price"), rs.getTimestamp("purchaseDate"), seat, order);

                ticketIDs.add(ticket.getTicketID());

                List<OrderFoodItem> orderFoods = selectAllOrderFoodItems(ticket.getOrderID().getOrderID());
                for (OrderFoodItem orderFood : orderFoods) {
                    orderFood.setFoods(getFoodItemById(orderFood.getFoodItemID()));
                }
                ticket.getOrderID().setOrderFood(orderFoods);
                list.add(ticket);
            }
            // Fetch seats for the list of ticket IDs
            List<Seats> allSeats = selectSeatsByTicketID(ticketIDs);
            for (Tickets ticket : list) {
                List<Seats> seatsForTicket = new ArrayList<>();
                for (Seats seat : allSeats) {
                    if (seat.getScreeningID().getScreeningID() == ticket.getSeatID().getScreeningID().getScreeningID()) {
                        seatsForTicket.add(seat);
                    }
                }
                ticket.setSeats(seatsForTicket);
                ticket.setTicketIDs(ticketIDs);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Seats> selectSeatsByTicketID(List<Integer> ticketIDs) {
        List<Seats> seats = new ArrayList<>();
        if (ticketIDs.isEmpty()) {
            return seats;
        }

        String sql = "SELECT s.seatID, s.seatNumber, s.seatStatus, st.screeningID, st.startTime, st.endTime, th.theaterID, th.theaterNumber, m.movieID, m.title, m.description, m.releaseDate, m.posterImage, m.duration, m.display "
                + "FROM Seats s "
                + "JOIN ScreeningTimes st ON s.screeningID = st.screeningID "
                + "JOIN Theaters th ON st.theaterID = th.theaterID "
                + "JOIN Movies m ON st.movieID = m.movieID "
                + "WHERE s.seatID IN (SELECT seatID FROM Tickets WHERE ticketID IN (" + ticketIDs.stream().map(String::valueOf).collect(Collectors.joining(",")) + "))";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Theaters theater = new Theaters(rs.getInt("theaterID"), null, rs.getInt("theaterNumber"));
                Movies movie = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"), rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"), rs.getInt("display"));
                ScreeningTimes screening = new ScreeningTimes(rs.getInt("screeningID"), theater, movie, rs.getTimestamp("startTime"), rs.getTimestamp("endTime"));
                Seats seat = new Seats(rs.getInt("seatID"), screening, rs.getString("seatNumber"), rs.getString("seatStatus"));
                seats.add(seat);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return seats;
    }


    public List<OrderFoodItem> selectAllOrderFoodItems(int orderId) {
        List<OrderFoodItem> orderFoodItems = new ArrayList<>();
        String sql = "SELECT * FROM OrderDetails where orderID=?";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, orderId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int orderID = rs.getInt("orderID");
                int foodItemID = rs.getInt("foodItemID");
                int quantity = rs.getInt("quantity");
                orderFoodItems.add(new OrderFoodItem(id, orderID, foodItemID, quantity));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return orderFoodItems;
    }
    
    public FoodItem getFoodItemById(int id) {
        List<FoodItem> foodItems = new ArrayList<>();
        String sql = "SELECT * FROM FoodItems where foodItemID=?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FoodItem foodItem = new FoodItem();
                foodItem.setFoodItemID(rs.getInt("foodItemID"));
                foodItem.setFoodName(rs.getString("foodName"));
                foodItem.setDescription(rs.getString("description"));
                foodItem.setPrice(rs.getInt("price"));
                foodItem.setImgFoodItems(rs.getString("imgFoodItems"));
                return foodItem;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public StaffStatus getAllStaffByPhone(String phone) {
        List<StaffStatus> staffList = new ArrayList<>();
        String sql = "SELECT phone, status, address, dob, staffName, staffEmail FROM staffstatus where  phone=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, phone);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String status = rs.getString("status");
                String address = rs.getString("address");
                java.util.Date dob = rs.getDate("dob");
                String staffName = rs.getString("staffName");
                String staffEmail = rs.getString("staffEmail");
                
                StaffStatus staff = new StaffStatus(phone, status, address, dob, staffName, staffEmail);
                return staff;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }

    // updaet status staff
    public boolean updateStatus(String phone, String newStatus) {
        String sql = "UPDATE staffstatus SET status = ? WHERE phone = ?";
        try (
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setString(1, newStatus);
            stmt.setString(2, phone);
            
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
//    add staffStaus

    public boolean addStaff(StaffStatus staff) {
        String sql = "INSERT INTO staffstatus (phone, status, address, dob, staffName, staffEmail, cinemaId) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setString(1, staff.getPhone());
            stmt.setString(2, staff.getStatus());
            stmt.setString(3, staff.getAddress());
            stmt.setDate(4, new java.sql.Date(staff.getDob().getTime()));
            stmt.setString(5, staff.getStaffName());
            stmt.setString(6, staff.getStaffEmail());

            stmt.setInt(7, staff.getCinemaId());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public void addStaff(Users u, String phone) {
        String sql = "INSERT INTO Users (displayName, username, password, roleID, email, point, phone) VALUES (?, ?, ?, 3,?,0, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, u.getDisplayName());
            ps.setString(2, u.getUserName());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getEmail());
            ps.setString(5, phone);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // get all staffstatus
    public List<StaffStatus> getAllStaff() {
        List<StaffStatus> staffList = new ArrayList<>();
        String sql = "SELECT phone, status, address, dob, staffName, staffEmail FROM staffstatus";
        try (
                PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                String phone = rs.getString("phone");
                String status = rs.getString("status");
                String address = rs.getString("address");
                java.util.Date dob = rs.getDate("dob");
                String staffName = rs.getString("staffName");
                String staffEmail = rs.getString("staffEmail");
                
                StaffStatus staff = new StaffStatus(phone, status, address, dob, staffName, staffEmail);
                staffList.add(staff);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return staffList;
    }

// get list screening time
    public List<ScreeningTimes> getAllFlimList(int movieID, int cinemaID, Date movieDate, Timestamp startTime) {
        List<ScreeningTimes> list = new ArrayList<>();
        String sql = "select m.display, l.locationID, l.name as location, c.cinemaID, c.name as cinemasName, c.movieDate, t.theaterID, t.theaterNumber, st.screeningID, st.startTime, st.endTime, m.movieID,m.title, m.description, m.releaseDate, m.posterImage, m.duration from Location l join Cinemas c on l.locationID = c.locationID join Theaters t on c.cinemaID = t.cinemaID join ScreeningTimes st on t.theaterID = st.theaterID join Movies m on st.movieID = m.movieID where m.movieID = ? and c.cinemaID = ? and c.movieDate = ? and st.startTime > DATE_ADD(?, INTERVAL 1 HOUR)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, movieID);
            ps.setInt(2, cinemaID);
            ps.setDate(3, movieDate);
            ps.setTimestamp(4, startTime);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Location l = new Location(rs.getInt("locationID"), rs.getString("location"));
                Cinemas c = new Cinemas(rs.getInt("cinemaID"), rs.getString("cinemasName"), rs.getDate("movieDate"), l);
                Theaters t = new Theaters(rs.getInt("theaterID"), c, rs.getInt("theaterNumber"));
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"),
                        rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"),
                        rs.getInt("display"));
                ScreeningTimes st = new ScreeningTimes(rs.getInt("screeningID"), t, m, rs.getTimestamp("startTime"),
                        rs.getTimestamp("endTime"));
                list.add(st);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
  
    

    public List<ScreeningTimes> getAllFlimDay(String movieDate, int theaterId) {
        List<ScreeningTimes> list = new ArrayList<>();
        String sql = "select * from project_cinema_update.ScreeningTimes st join project_cinema_update.Theaters t on st.theaterID = t.theaterID join  project_cinema_update.Movies m on m.movieID = st.movieID\n"
                + " where date(st.startTime) = ? and t.theaterNumber = ? order by date(st.startTime) desc";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, movieDate);
            ps.setInt(2, theaterId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                ScreeningTimes st = new ScreeningTimes(rs.getInt("screeningID"), rs.getInt(2), rs.getInt(3), rs.getTimestamp("startTime"),
                        rs.getTimestamp("endTime"));
                list.add(st);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // get all cinemas with movieID, date, direction
    public List<Cinemas> getAllCinemas(int movieID, Date movieDate, int direction) {
        List<Cinemas> list = new ArrayList<>();
        String sql = "select distinct c.cinemaID, c.name as cinemas, c.movieDate, l.locationID, l.name as location from Location l join Cinemas c on l.locationID = c.locationID join Theaters t on c.cinemaID = t.cinemaID join ScreeningTimes st on t.theaterID = st.theaterID join Movies m on st.movieID = m.movieID where m.movieID = ? and c.movieDate = ? and l.locationID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, movieID);
            ps.setDate(2, movieDate);
            ps.setInt(3, direction);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cinemas c = new Cinemas(rs.getInt("cinemaID"), rs.getString("cinemas"), rs.getDate("movieDate"),
                        new Location(rs.getInt("locationID"), rs.getString("location")));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // get all cinemas by locationID
    public List<Cinemas> getAllCinemasByLocationID(int locationID) {
        List<Cinemas> list = new ArrayList<>();
        String sql = "SELECT DISTINCT c.name FROM project_cinema_update.Cinemas c where c.locationID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, locationID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cinemas c = new Cinemas(rs.getString("name"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // get all direction
    public List<Location> getAllDirection() {
        List<Location> list = new ArrayList<>();
        String sql = "select * from Location";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Location l = new Location(rs.getInt("locationID"), rs.getString("name"));
                list.add(l);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<SeatWithScreeningTime> getSWSByID(int screeningID) {
        String sql = "select m.display, l.locationID, l.name AS location, c.cinemaID, c.name AS cinemasName, c.movieDate, t.theaterID, t.theaterNumber, st.screeningID, st.startTime, st.endTime, m.movieID, m.title, m.description, m.releaseDate, m.posterImage, m.duration, s.seatID, s.seatNumber from ScreeningTimes st join Theaters t on t.theaterID = st.theaterID join Movies m on m.movieID = st.movieID join Cinemas c on c.cinemaID = t.cinemaID join Location l on l.locationID = c.locationID JOIN Seats s on s.screeningID = st.screeningID where st.screeningID = ?";
        List<SeatWithScreeningTime> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, screeningID);
            ResultSet rs = ps.executeQuery();
            // if (rs.next()) {
            while (rs.next()) {
                Location l = new Location(rs.getInt("locationID"), rs.getString("location"));
                Cinemas c = new Cinemas(rs.getInt("cinemaID"), rs.getString("cinemasName"), rs.getDate("movieDate"), l);
                Theaters t = new Theaters(rs.getInt("theaterID"), c, rs.getInt("theaterNumber"));
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"),
                        rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"),
                        rs.getInt("display"));
                ScreeningTimes st = new ScreeningTimes(rs.getInt("screeningID"), t, m, rs.getTimestamp("startTime"),
                        rs.getTimestamp("endTime"));
                Seats s = new Seats(rs.getInt("SeatID"), rs.getString("seatNumber"), st);
                SeatWithScreeningTime SWS = new SeatWithScreeningTime(s, st);
                list.add(SWS);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // get list screening time by id
    public ScreeningTimes getScreeningTimesByID(int screeningID) {
        String sql = "select m.display,l.locationID, l.name as location, c.cinemaID, c.name as cinemasName, c.movieDate, t.theaterID, t.theaterNumber, st.screeningID, st.startTime, st.endTime, m.movieID,m.title, m.description, m.releaseDate, m.posterImage, m.duration, t.rows, t.cols from Location l join Cinemas c on l.locationID = c.locationID join Theaters t on c.cinemaID = t.cinemaID join ScreeningTimes st on t.theaterID = st.theaterID join Movies m on st.movieID = m.movieID where st.screeningID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, screeningID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Location l = new Location(rs.getInt("locationID"), rs.getString("location"));
                Cinemas c = new Cinemas(rs.getInt("cinemaID"), rs.getString("cinemasName"), rs.getDate("movieDate"), l);
                Theaters t = new Theaters(rs.getInt("theaterID"), c, rs.getInt("theaterNumber"), rs.getInt("rows"),
                        rs.getInt("cols"));
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"),
                        rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"),
                        rs.getInt("display"));
                ScreeningTimes st = new ScreeningTimes(rs.getInt("screeningID"), t, m, rs.getTimestamp("startTime"),
                        rs.getTimestamp("endTime"));
                return st;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public Timestamp getLastestEndTimeOfTheater(String cinemasName, Date movieDate, int theaterNumber) {
        String sql = "SELECT st.endTime \n"
                + "FROM Location l \n"
                + "JOIN Cinemas c ON l.locationID = c.locationID \n"
                + "JOIN Theaters t ON t.cinemaID = c.cinemaID \n"
                + "JOIN ScreeningTimes st ON st.theaterID = t.theaterID \n"
                + "WHERE c.name = ? \n"
                + "  AND c.movieDate = ? \n"
                + "  AND t.theaterNumber = ? \n"
                + "ORDER BY st.endTime DESC \n"
                + "LIMIT 1;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cinemasName);
            ps.setDate(2, movieDate);
            ps.setInt(3, theaterNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getTimestamp("endTime");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // insert new cinemas
    public void insertNewCinemas(String name, Date movieDate, int locationID) {
        String sql = "insert into Cinemas (name, movieDate, locationID) values(?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDate(2, movieDate);
            ps.setInt(3, locationID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // get cinemasID recently added
    public Cinemas getCinemasRecentlyAdded() {
        String sql = "select * from Cinemas order by cinemaID desc limit 1 ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Cinemas c = new Cinemas();
            if (rs.next()) {
                c.setName(rs.getString("name"));
                c.setCinemaID(rs.getInt("cinemaID"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // insert into theaters with cinemaID, theaterNumber
    public void insertTheaters(int cinemaID, int theaterNumber, int rows, int cols) {
        String sql = "INSERT INTO Theaters (cinemaID, theaterNumber, `rows`, `cols`) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, cinemaID);
            ps.setInt(2, theaterNumber);
            ps.setInt(3, rows);
            ps.setInt(4, cols);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error when inserting into Theaters: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // get theatersID recently added
    public int getTheaterIDRecentlyAdded() {
        String sql = "SELECT * \n"
                + "FROM Theaters \n"
                + "ORDER BY theaterID DESC \n"
                + "LIMIT 1";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("theaterID");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    // insert into screeningTimes with movieID, theaterID, startTime, endTime
    public void insertScreeningTimes(int theaterID, int movieID, Timestamp startTime, Timestamp endTime) {
        String sql = "insert into ScreeningTimes (theaterID, movieID, startTime, endTime) values(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, theaterID);
            ps.setInt(2, movieID);
            ps.setTimestamp(3, startTime);
            ps.setTimestamp(4, endTime);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public List<ScreeningTimes> getScreeningTimesByDateAndTheater(Timestamp movieStartTime, int theaterId) {
        List<ScreeningTimes> screeningTimesList = new ArrayList<>();
        String sql = "SELECT * FROM screeningtimes WHERE theaterID = ? AND DATE(startTime) = DATE(?)";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, theaterId);
            ps.setTimestamp(2, movieStartTime);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int screeningID = rs.getInt("screeningID");
                    int theaterID = rs.getInt("theaterID");
                    int movieID = rs.getInt("movieID");
                    Timestamp startTime = rs.getTimestamp("startTime");
                    Timestamp endTime = rs.getTimestamp("endTime");

                    // Create Movie and Theater objects
                    Movies movie = new Movies();
                    movie.setMovieID(movieID);
                    
                    Theaters theater = new Theaters();
                    theater.setTheaterID(theaterID);

                    // Create ScreeningTimes object
                    ScreeningTimes screeningTimes = new ScreeningTimes(screeningID, theater, movie, startTime, endTime);
                    screeningTimesList.add(screeningTimes);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return screeningTimesList;
    }
    
    public int getTheaterID(int cinemaID, int theaterNumber) {
        int theaterID = -1;
        String sql = "SELECT theaterID FROM project_cinema_update.theaters WHERE cinemaID = ? AND theaterNumber = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, cinemaID);
            ps.setInt(2, theaterNumber);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    theaterID = rs.getInt("theaterID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return theaterID;
    }
    
    public void updateScreeningTimes(int theaterID, int movieID, Timestamp startTime, Timestamp endTime, int sid) {
        String sql = "UPDATE project_cinema_update.ScreeningTimes\n"
                + "SET theaterID = ?, movieID = ?, startTime = ?, endTime = ?\n"
                + "WHERE screeningID = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, theaterID);
            ps.setInt(2, movieID);
            ps.setTimestamp(3, startTime);
            ps.setTimestamp(4, endTime);
            ps.setInt(5, sid);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // void get movie by movieID
    public Movies getMovieByID(int movieID) {
        String sql = "SELECT * FROM project_cinema_update.Movies AS m WHERE m.movieID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, movieID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"),
                        rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"),
                        rs.getInt("display"), rs.getString("trailerUrl"), rs.getString("slug"));
                return m;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // get screening time by movie date and cinema name
    public List<ScreeningTimes> getScreeningTimeOfMovieByMovieDateAndCinemaName(Date sqlDate, String cinemaName,
            int movieID, Timestamp startTime) {
        String sql = "select st.movieID, l.name,l.locationID, m.title, m.posterImage, st.screeningID, st.startTime, st.endTime, t.theaterID from Location l join Cinemas c on l.locationID = c.locationID join Theaters t on t.cinemaID = c.cinemaID join ScreeningTimes st on st.theaterID = t.theaterID join Movies m on m.movieID = st.movieID where c.movieDate = ? and m.releaseDate BETWEEN DATE_ADD(CURDATE(), INTERVAL -30 DAY) AND CURDATE() and c.name = ? and m.movieID = ? and st.startTime > DATE_ADD(?, INTERVAL 10 MINUTE)";
        List<ScreeningTimes> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, sqlDate);
            ps.setString(2, cinemaName);
            ps.setInt(3, movieID);
            ps.setTimestamp(4, startTime);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Location l = new Location(rs.getInt("locationID"), rs.getString("name"));
                Cinemas c = new Cinemas(rs.getString("name"), l);
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("posterImage"));
                Theaters t = new Theaters(rs.getInt("theaterID"), c);
                ScreeningTimes st = new ScreeningTimes(rs.getInt("screeningID"), m, rs.getTimestamp("startTime"),
                        rs.getTimestamp("endTime"), t);
                list.add(st);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // get list movie by movie date and cinema name
    public List<Movies> getMovieByMovieDateAndCinemaName(Date sqlDate, String cinemaName) {
        String sql = "select DISTINCT m.title, m.movieID, m.posterImage from Location l join Cinemas c on l.locationID = c.locationID join Theaters t on t.cinemaID = c.cinemaID join ScreeningTimes st on st.theaterID = t.theaterID join Movies m on m.movieID = st.movieID where c.movieDate = ? and m.releaseDate BETWEEN DATE_ADD(CURDATE(), INTERVAL -30 DAY) AND CURDATE() and c.name = ?";
        List<Movies> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, sqlDate);
            ps.setString(2, cinemaName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("posterImage"));
                list.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<FoodItem> getFood() {
        List<FoodItem> foodItems = new ArrayList<>();
        String sql = "SELECT * FROM FoodItems where display = '1'";
        try (
                PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                FoodItem foodItem = new FoodItem();
                foodItem.setFoodItemID(rs.getInt("foodItemID"));
                foodItem.setFoodName(rs.getString("foodName"));
                foodItem.setDescription(rs.getString("description"));
                foodItem.setPrice(rs.getInt("price"));
                foodItem.setImgFoodItems(rs.getString("imgFoodItems"));
                foodItem.setQuantity(rs.getInt("quantity"));
                foodItem.setDisplay(rs.getInt("display"));
                foodItems.add(foodItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foodItems;
    }
    
    // get all cinemas
    public List<Cinemas> getAllCinemas() {
        List<Cinemas> list = new ArrayList<>();
        String sql = "SELECT DISTINCT c.name FROM project_cinema_update.Cinemas c where c.name not like 'CGV%'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String sql1 = "SELECT * FROM project_cinema_update.Cinemas c where c.name = ? LIMIT 1";
                Cinemas c = new Cinemas(rs.getString("name"));
                PreparedStatement ps1 = connection.prepareStatement(sql1);
                ps1.setString(1, c.getName());
                ResultSet rs1 = ps1.executeQuery();
                while (rs1.next()) {
                    c.setCinemaID(rs1.getInt("CinemaId"));
                }
                list.add(c);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // get ScreeningTimes in one week
    public List<Cinemas> getAllMovieDateInOneWeek(Date startDate, Date endDate, String cinemasName,
            int theaterNumber) {
        List<Cinemas> list = new ArrayList<>();
        String sql = "select distinct c.movieDate from Location l join Cinemas c on l.locationID = c.locationID join Theaters t on t.cinemaID = c.cinemaID join ScreeningTimes st on st.theaterID = t.theaterID join Movies m on m.movieID = st.movieID where c.movieDate BETWEEN ? AND ? and c.name = ? and t.theaterNumber = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, startDate);
            ps.setDate(2, endDate);
            ps.setString(3, cinemasName);
            ps.setInt(4, theaterNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cinemas c = new Cinemas();
                c.setMovieDate(rs.getDate("movieDate"));
                list.add(c);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //get all day has shift of staff in one week
    public List<ShiftCurrent> getAllDayHasShiftAWeek(Date startDate, Date endDate, String cinemasName) {
        List<ShiftCurrent> list = new ArrayList<>();
        String sql = "SELECT DISTINCT CAST(sh.startTime AS date) as startDate FROM Shift sh JOIN Users u ON u.userID = sh.phone JOIN staffstatus ss ON ss.phone = u.phone JOIN Cinemas c ON c.cinemaID = ss.cinemaID where CAST(sh.startTime AS date) between ? and ? and c.name = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, startDate);
            ps.setDate(2, endDate);
            ps.setString(3, cinemasName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ShiftCurrent sc = new ShiftCurrent();
                sc.setStartTime(rs.getTimestamp("startDate"));
                list.add(sc);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //get all shift time of staff each day
    public List<ShiftCurrent> getAllShiftTimeOfStaffEachDay(Date thisDate, String cinemasName) {
        List<ShiftCurrent> list = new ArrayList<>();
        String sql = "SELECT sh.startTime as startDate, u.displayName, sh.phone FROM Shift sh JOIN Users u ON u.userID = sh.phone JOIN staffstatus ss ON ss.phone = u.phone JOIN Cinemas c ON c.cinemaID = ss.cinemaID where CAST(sh.startTime AS date) = ? and c.name = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, thisDate);
            ps.setString(2, cinemasName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Users u = new Users();
                u.setDisplayName(rs.getString("displayName"));
                ShiftCurrent sc = new ShiftCurrent(rs.getTimestamp("startDate"), u);
                list.add(sc);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // get all Screening time in each day
    public List<ScreeningTimes> getAllScreeningTimesEachDay(Date movieDate, String cinemaName) {
        List<ScreeningTimes> list = new ArrayList<>();
        String sql = "select st.movieID, l.name,l.locationID, m.title, m.posterImage, st.screeningID, st.startTime, st.endTime, t.theaterID from Location l join Cinemas c on l.locationID = c.locationID join Theaters t on t.cinemaID = c.cinemaID join ScreeningTimes st on st.theaterID = t.theaterID join Movies m on m.movieID = st.movieID where c.movieDate = ? and m.releaseDate BETWEEN DATE_ADD(CURDATE(), INTERVAL -30 DAY) AND CURDATE() and c.name = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, movieDate);
            ps.setString(2, cinemaName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movies movie = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("posterImage"));
                Cinemas c = new Cinemas(rs.getString("title"));
                Theaters t = new Theaters(rs.getInt("theaterID"), c);
                ScreeningTimes st = new ScreeningTimes(rs.getInt("screeningID"), t, movie, rs.getTimestamp("startTime"), rs.getTimestamp("endTime"));
                list.add(st);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public ScreeningTimes getAllScreeningById(int id) {
        ScreeningTimes list = new ScreeningTimes();
        String sql = "SELECT * FROM project_cinema_update.ScreeningTimes a where a.screeningID = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ScreeningTimes st = new ScreeningTimes(
                        rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getTimestamp("startTime"), rs.getTimestamp("endTime"));
                return st;
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // get list voucher user can use
    public List<Voucher> getVoucherByUserID(int userID) {
        List<Voucher> list = new ArrayList<>();
        String sql = "SELECT v.voucherID, v.voucherName, v.voucherDescription, v.discountAmount, v.startDate, v.endDate, v.quantity, v.code FROM Voucher v LEFT JOIN Orders o ON v.voucherID = o.voucherID AND o.userID = ? WHERE o.orderID IS NULL and CURDATE() BETWEEN v.startDate AND v.endDate and v.quantity > 0";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Voucher v = new Voucher(rs.getString("voucherName"), rs.getString("voucherDescription"),
                        rs.getInt("discountAmount"), rs.getDate("startDate"), rs.getDate("endDate"),
                        rs.getInt("quantity"), rs.getString("code"));
                v.setVoucherID(rs.getInt("voucherID"));
                list.add(v);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // get voucher by id
    public Voucher getVoucherByID(int voucherID) {
        String sql = "SELECT * FROM Voucher WHERE voucherID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, voucherID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Voucher v = new Voucher(rs.getString("voucherName"), rs.getString("voucherDescription"),
                        rs.getInt("discountAmount"), rs.getDate("startDate"), rs.getDate("endDate"),
                        rs.getInt("quantity"), rs.getString("code"));
                v.setVoucherID(rs.getInt("voucherID"));
                return v;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // get food by name
    public FoodItem getFoodByName(String foodName) {
        String sql = "SELECT f.foodItemID, f.foodName, f.description, f.price FROM FoodItems f WHERE foodName = ?";
        FoodItem foodItem = new FoodItem();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, foodName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                foodItem.setFoodItemID(rs.getInt("foodItemID"));
                foodItem.setFoodName(rs.getString("foodName"));
                foodItem.setDescription(rs.getString("description"));
                foodItem.setPrice(rs.getInt("price"));
                return foodItem;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return foodItem;
    }

    // get food by id
    public FoodItem getFoodByID(int foodItemID) {
        String sql = "SELECT f.foodItemID, f.foodName, f.description, f.price, f.imgFoodItems, f.quantity FROM FoodItems f WHERE foodItemID = ?";
        FoodItem foodItem = new FoodItem();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, foodItemID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                foodItem.setFoodItemID(rs.getInt("foodItemID"));
                foodItem.setFoodName(rs.getString("foodName"));
                foodItem.setDescription(rs.getString("description"));
                foodItem.setImgFoodItems(rs.getString("imgFoodItems"));
                foodItem.setPrice(rs.getInt("price"));
                foodItem.setQuantity(rs.getInt("quantity"));
                return foodItem;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return foodItem;
    }

    // insert seat with screeningID and seatNumber
    public void insertSeats(int screeningID, String seatNumber) {
        String sql = "INSERT INTO Seats (screeningID, seatNumber) VALUES (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, screeningID);
            ps.setString(2, seatNumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // get seat by screeningID and seatNumber
    public Seats getSeatByScreeningIDAndSeatNumber(int screeningID, String seatNumber) {
        String sql = "SELECT * FROM Seats WHERE screeningID = ? AND seatNumber = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, screeningID);
            ps.setString(2, seatNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Seats s = new Seats(rs.getInt("seatID"), rs.getString("seatNumber"),
                        getScreeningTimesByID(screeningID));
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // insert order
    public void insertOrder(int userID, int movieID, int quantity, String allPrice, int voucherID) {
        String sql = "INSERT INTO Orders (userID, movieID, quantity, allPrice, voucherID) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userID);
            ps.setInt(2, movieID);
            ps.setInt(3, quantity);
            ps.setString(4, allPrice);
            ps.setInt(5, voucherID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String getOrderIDByUserID(String userID) {
        String orderID = null;
        String sql = "SELECT orderID FROM Orders WHERE userID = ? ORDER BY orderID DESC LIMIT 1";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                orderID = rs.getString("orderID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderID;
    }
    
    // get order detail by orderID
    public Orders getOrderById(String orderId) {
        Orders od = null;
        String sql = "SELECT o.*, u.username, od.isChecked "
                + "FROM Orders o "
                + "JOIN Users u ON o.userID = u.userID "
                + "LEFT JOIN OrderDetails od ON o.userID = od.orderID "
                + "WHERE o.orderID = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, orderId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                od = new Orders();
                od.setOrderID(rs.getInt("orderID"));

                Users user = new Users();
                user.setUserID(rs.getInt("userID"));
                user.setUserName(rs.getString("username"));
                od.setUserID(user);

                Movies movie = new Movies();
                movie.setMovieID(rs.getInt("movieID"));
                od.setMovieID(movie);

                od.setQuantity(rs.getInt("quantity"));
                od.setAllPrice(rs.getString("allPrice"));

                TicketInfo tk = new TicketInfo();
                tk.setIsChecked(rs.getBoolean("isChecked"));
                od.setTicketInfo(tk);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return od;
    }

    // get info list ticket for bill by orderID
    public List<TicketInfo> getTicketInfoByOrderId(String orderId) {
        List<TicketInfo> ticketInfos = new ArrayList<>();
        String sql = "SELECT DISTINCT m.title, st.startTime, st.endTime, t.ticketID, c.name AS nameCinema, s.seatNumber, t.price AS priceTicket, th.theaterNumber "
                + "FROM Tickets t "
                + "JOIN Seats s ON t.seatID = s.seatID "
                + "JOIN Movies m ON t.movieID = m.movieID "
                + "JOIN Cinemas c ON t.cinemaID = c.cinemaID "
                + "JOIN Theaters th ON t.cinemaID = th.cinemaID "
                + "JOIN ScreeningTimes st ON s.screeningID = st.screeningID "
                + "WHERE t.orderID = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, orderId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TicketInfo ticketInfo = new TicketInfo();
                ticketInfo.setTicketID(rs.getInt("ticketID"));
                ticketInfo.setTitle(rs.getString("title"));
                ticketInfo.setStartTime(rs.getTimestamp("startTime"));
                ticketInfo.setEndTime(rs.getTimestamp("endTime"));
                ticketInfo.setNameCinema(rs.getString("nameCinema"));
                ticketInfo.setTheaterNumber(rs.getString("theaterNumber"));
                ticketInfo.setSeatNumber(rs.getString("seatNumber"));
                ticketInfo.setPriceTicket(rs.getString("priceTicket"));

                ticketInfos.add(ticketInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticketInfos;
    }

    // get food item by orderID
    public List<FoodItem> getFoodItemsByOrderId(String orderId) {
        List<FoodItem> foodItems = new ArrayList<>();

        String sql = "SELECT f.foodItemID, f.foodName, f.price, od.quantity FROM FoodItems f "
                + "JOIN OrderDetails od ON f.foodItemID = od.foodItemID "
                + "WHERE od.orderID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, orderId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FoodItem item = new FoodItem();
                item.setFoodItemID(rs.getInt("foodItemID"));
                item.setFoodName(rs.getString("foodName"));
                item.setPrice(rs.getInt("price"));

                item.setQuantity(rs.getInt("quantity")); // Ensure FoodItem has this field

                foodItems.add(item);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foodItems;
    }
    return foodItems;
    }

    // insertOrderWithVoucherIDNull
    public void insertOrderWithVoucherIDNull(int userID, int movieID, int quantity, String allPrice) {
        String sql = "INSERT INTO Orders (userID, movieID, quantity, allPrice) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userID);
            ps.setInt(2, movieID);
            ps.setInt(3, quantity);
            ps.setString(4, allPrice);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // insert tickets
    public void insertTickets(int userID, int movieID, int cinemaID, String price, Timestamp purchaseDate, int seatID,
            int orderID) {
        String sql = "INSERT INTO Tickets (userID, movieID, cinemaID, price, purchaseDate, seatID, orderID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userID);
            ps.setInt(2, movieID);
            ps.setInt(3, cinemaID);
            ps.setString(4, price);
            ps.setTimestamp(5, purchaseDate);
            ps.setInt(6, seatID);
            ps.setInt(7, orderID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // get order recently added
    public int getOrderRecentlyAdded() {
        String sql = "SELECT o.orderID FROM Orders o ORDER BY orderID DESC LIMIT 1";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("orderID");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    // insert food item with orderID, foodName, quantity
    public void insertFoodItem(int orderID, int foodItemID, int quantity) {
        String sql = "INSERT INTO OrderFoodItems (orderID, foodItemID, quantity) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, orderID);
            ps.setInt(2, foodItemID);
            ps.setInt(3, quantity);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // update quantity of voucher by voucherID
    public void updateQuantityOfVoucher(int voucherID) {
        String sql = "UPDATE Voucher SET quantity = quantity - 1 WHERE voucherID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, voucherID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // update point of user by userID
    public void updatePointOfUser(int userID, int point) {
        String sql = "UPDATE Users SET point = point + ? WHERE userID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, point);
            ps.setInt(2, userID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Shift> getAllReportShifts() {
    List<Shift> shifts = new ArrayList<>();
    try {
        String sql = "SELECT s.startTime, s.endTime, s.startAmount, s.endAmount, s.tranferPayment, u.displayName " +
                     "FROM Shift s JOIN Users u ON s.phone = u.userID " +
                     "WHERE DATE(s.startTime) = CURDATE()";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Shift shift = new Shift();
            shift.setDisplayName(rs.getString("displayName"));
            shift.setStartTime(rs.getTimestamp("startTime"));
            shift.setEndTime(rs.getTimestamp("endTime"));
            shift.setStartAmount(rs.getDouble("startAmount"));
            shift.setEndAmount(rs.getDouble("endAmount"));
            shift.setTransferPayments(rs.getDouble("tranferPayment"));

            // Tính toán revenue
            double revenue = rs.getDouble("endAmount") - rs.getDouble("startAmount") + rs.getDouble("tranferPayment");
            shift.setRevenue(revenue);

            shifts.add(shift);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return shifts;
}

    
    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Shift> shifts = dao.getAllReportShifts();
        
        for (Shift shift : shifts) {
            System.out.println("Shift ID: " + shift.getShiftID());
            System.out.println("Display Name: " + shift.getDisplayName());
            System.out.println("Start Time: " + shift.getStartTime());
            System.out.println("End Time: " + shift.getEndTime());
            System.out.println("Start Amount: " + shift.getStartAmount());
            System.out.println("End Amount: " + shift.getEndAmount());
            System.out.println("Transfer Payments: " + shift.getTransferPayments());
            System.out.println("Revenue: " + shift.getRevenue());
            System.out.println("-----------------------------");
        }  
    }
}
