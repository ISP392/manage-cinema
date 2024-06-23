/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mysql.cj.protocol.a.MysqlTextValueDecoder;
import java.security.NoSuchAlgorithmException;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import modal.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import modal.Genres;
import modal.MovieGenres;
import modal.Role;

import modal.Movies;
import modal.Users;
import util.Encrypt;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author MISS NGA
 */
public class DAO extends DBContext {

    
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
                        rs.getString("trailerUrl")
                );
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
                        rs.getString("trailerURL")
                );
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

    //check email and password == null
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
        String sql = "SELECT * FROM Users join Roles on Users.roleID = Roles.roleID where username= " + "'" + username + "'" + "and password = " + "'" + pass + "'";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Role r = new Role(rs.getInt("roleID"), rs.getString("name"));
                return new Users(rs.getInt("userID"), rs.getString("displayName"), rs.getString("userName"),
                        rs.getString("password"), rs.getString("email"), r, rs.getInt("point"), rs.getString("providerID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // check login of admin
    public Users checkLoginAdmin(String username, String password) {
        String pass = "";
        try {
            pass = Encrypt.toSHA1(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM Users join Roles on Users.roleID = Roles.roleID where username= " + "'" + username + "'" + "and password = " + "'" + pass + "'" + "AND Roles.roleID = 1";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Role r = new Role(rs.getInt("roleID"), rs.getString("name"));
                return new Users(rs.getInt("userID"), rs.getString("displayName"), rs.getString("userName"),
                        rs.getString("password"), rs.getString("email"), r, rs.getInt("point"), rs.getString("providerID"));
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
        String sql = "SELECT * FROM Movies m WHERE m.releaseDate BETWEEN DATE_ADD(CURDATE(), INTERVAL -30 DAY) AND CURDATE() ORDER BY m.releaseDate asc;";
        if (isLimit) {
            sql = sql.substring(0, sql.length() - 1) + " limit 4;";
        }
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

    public List<Movies> getMovieByGenreID(int genreID) {
        List<Movies> list = new ArrayList<>();
        String sql = "SELECT * FROM Movies m JOIN MovieGenres mg ON m.movieID = mg.movieID JOIN Genres g ON mg.genreID = g.genreID WHERE mg.genreID = ? AND m.releaseDate >= DATE_ADD(CURDATE(), INTERVAL -30 DAY);";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, genreID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"), rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"), rs.getInt("display"), rs.getString("trailerUrl"), rs.getString("name"));
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

    //update displayname by email
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

    //update user
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

    //get user by username
    public Users getUserByUsername(String username) {
        String sql = "select * from Users where username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Role r = new Role(rs.getInt("roleID"));
                Users u = new Users(rs.getInt("userID"), rs.getString("displayName"), rs.getString("username"), rs.getString("password"), rs.getString("email"), r, rs.getInt("point"), rs.getString("providerID"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //get user by email
    public Users getUserByEmail(String email) {
        String sql = "select * from Users where email = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Role r = new Role(rs.getInt("roleID"));
                Users u = new Users(rs.getInt("userID"), rs.getString("displayName"), rs.getString("username"), rs.getString("password"), rs.getString("email"), r, rs.getInt("point"), rs.getString("providerID"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //void get list<movieGenres> by movieID
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
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"), rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"), rs.getInt("display"), rs.getString("trailerUrl"));
                MovieGenres mg = new MovieGenres(rs.getInt("movieGenresID"), g, m);
                list.add(mg);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //get count of like by movieID
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

    //insert new movie
    public void insertNewMovie(String title, String description, Date releaseDate, String uniqueFileName, int duration, String trailerUrl) {
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

    //get movie recently added
    public Movies getMovieRecentlyAdded() {
        String sql = "SELECT * FROM Movies ORDER BY movieID DESC LIMIT 1";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"), rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"), rs.getInt("display"), rs.getString("trailerUrl"));
                return m;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //insert movie genre
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

    //update password by email
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

    //update movie by movieID
    public void updateMovieByID(String title, String description, Date releaseDate, String posterImage, int duration, String trailerUrl, int movieID) {
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

    //delete movie genre by movieID
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
    
    //count paging tickets by userID
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

    //paging list tickets by userID
    public List<Tickets> pagingTickets(int userID, int index) {
        List<Tickets> list = new ArrayList<>();
        String sql = "SELECT t.ticketID, u.userID, u.displayName, u.username, u.password, u.email, u.providerID, u.point, "
                + "r.roleID, r.name, "
                + "m.movieID, m.title, m.description, m.releaseDate, m.posterImage, m.duration, m.display, "
                + "c.cinemaID, c.name, c.movieDate, "
                + "l.locationID, l.name, "
                + "st.screeningID, st.startTime, st.endTime, "
                + "th.theaterID, th.theaterNumber, th.totalSeats, "
                + "s.seatID, s.seatNumber, s.seatStatus, "
                + "o.orderID, o.quantity, o.allPrice, "
                + "t.price, t.purchaseDate "
                + "FROM Tickets t "
                + "JOIN Users u ON t.userID = u.userID "
                + "JOIN Roles r ON u.roleID = r.roleID "
                + "JOIN Movies m ON t.movieID = m.movieID "
                + "JOIN Cinemas c ON t.cinemaID = c.cinemaID "
                + "JOIN Location l ON l.locationID = c.locationID "
                + "JOIN Seats s ON t.seatID = s.seatID "
                + "JOIN ScreeningTimes st ON st.screeningID = s.screeningID "
                + "JOIN Theaters th ON st.theaterID = th.theaterID "
                + "JOIN Orders o ON t.orderID = o.orderID "
                + "WHERE u.userID = ? "
                + "ORDER BY t.ticketID "
                + "LIMIT 5 OFFSET ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userID);
            ps.setInt(2, (index - 1) * 5);//calculates the number of records to skip
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role r = new Role(rs.getInt("roleID"), rs.getString("name"));
                Users u = new Users(rs.getInt("userID"), rs.getString("displayName"), rs.getString("username"), rs.getString("password"), rs.getString("email"), r, rs.getInt("point"), rs.getString("providerID"));
                Location l = new Location(rs.getInt("locationID"), rs.getString("name"));
                Cinemas c = new Cinemas(rs.getInt("cinemaID"), rs.getString("name"), rs.getDate("movieDate"), l);
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"), rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"), rs.getInt("display"));
                Theaters th = new Theaters(rs.getInt("theaterID"), c, rs.getInt("theaterNumber"), rs.getInt("totalSeats"));
                ScreeningTimes st = new ScreeningTimes(rs.getInt("screeningID"), th, m, rs.getTimestamp("startTime"), rs.getTimestamp("endTime"));
                Seats s = new Seats(rs.getInt("seatID"), st, rs.getString("seatNumber"), rs.getString("seatStatus"));
                Orders o = new Orders(rs.getInt("orderID"), u, m, rs.getInt("quantity"), rs.getString("allPrice"));
                Tickets t = new Tickets(rs.getInt("ticketID"), u, m, c, rs.getString("price"), rs.getTimestamp("purchaseDate"), s, o);
                list.add(t);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }


    //get list screening time
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
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"), rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"), rs.getInt("display"));
                ScreeningTimes st = new ScreeningTimes(rs.getInt("screeningID"), t, m, rs.getTimestamp("startTime"), rs.getTimestamp("endTime"));
                list.add(st);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //get all cinemas with movieID, date, direction
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
                Cinemas c = new Cinemas(rs.getInt("cinemaID"), rs.getString("cinemas"), rs.getDate("movieDate"), new Location(rs.getInt("locationID"), rs.getString("location")));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //get all direction
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
            //if (rs.next()) {
            while (rs.next()) {
                Location l = new Location(rs.getInt("locationID"), rs.getString("location"));
                Cinemas c = new Cinemas(rs.getInt("cinemaID"), rs.getString("cinemasName"), rs.getDate("movieDate"), l);
                Theaters t = new Theaters(rs.getInt("theaterID"), c, rs.getInt("theaterNumber"));
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"), rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"), rs.getInt("display"));
                ScreeningTimes st = new ScreeningTimes(rs.getInt("screeningID"), t, m, rs.getTimestamp("startTime"), rs.getTimestamp("endTime"));
                Seats s = new Seats(rs.getInt("SeatID"), rs.getString("seatNumber"), st);
                SeatWithScreeningTime SWS = new SeatWithScreeningTime(s, st);
                list.add(SWS);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //get list screening time by id
    public ScreeningTimes getScreeningTimesByID(int screeningID) {
        String sql = "select m.display,l.locationID, l.name as location, c.cinemaID, c.name as cinemasName, c.movieDate, t.theaterID, t.theaterNumber, st.screeningID, st.startTime, st.endTime, m.movieID,m.title, m.description, m.releaseDate, m.posterImage, m.duration from Location l join Cinemas c on l.locationID = c.locationID join Theaters t on c.cinemaID = t.cinemaID join ScreeningTimes st on t.theaterID = st.theaterID join Movies m on st.movieID = m.movieID where st.screeningID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, screeningID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Location l = new Location(rs.getInt("locationID"), rs.getString("location"));
                Cinemas c = new Cinemas(rs.getInt("cinemaID"), rs.getString("cinemasName"), rs.getDate("movieDate"), l);
                Theaters t = new Theaters(rs.getInt("theaterID"), c, rs.getInt("theaterNumber"));
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"), rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"), rs.getInt("display"));
                ScreeningTimes st = new ScreeningTimes(rs.getInt("screeningID"), t, m, rs.getTimestamp("startTime"), rs.getTimestamp("endTime"));
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

    //insert new cinemas
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

    //get cinemasID recently added
    public int getCinemasRecentlyAdded() {
        String sql = "select * from Cinemas order by cinemaID desc limit 1 ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("cinemaID");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    //insert into theaters with cinemaID, theaterNumber
    public void insertTheaters(int cinemaID, int theaterNumber) {
        String sql = "insert into Theaters (cinemaID, theaterNumber) values(?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cinemaID);
            ps.setInt(2, theaterNumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //get theatersID recently added
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

    //insert into screeningTimes with movieID, theaterID, startTime, endTime
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

    //void get movie by movieID
    public Movies getMovieByID(int movieID) {
        String sql = "SELECT * FROM Movies AS m WHERE m.movieID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, movieID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"), rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"), rs.getInt("display"), rs.getString("trailerUrl"), rs.getString("slug"));
                return m;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

     public static void main(String[] args) {
        DAO dao = new DAO();
        //test get movie by id
        Movies m = dao.getMovieByID(159);
        System.out.println(m.getSlug());

       
    }

}
