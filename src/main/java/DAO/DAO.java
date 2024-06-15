/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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
import modal.UserGoogleDto;

import modal.Movies;
import modal.Users;
import util.Encrypt;
import java.sql.Date;


/**
 * @author MISS NGA
 */
public class DAO extends DBContext {

    public void updateDisplayMovieByMoieID(int movieID, int Display) {
        
        

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
        if(isLimit)
            sql = sql.substring(0, sql.length() -1) + " limit 4;";
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

    //void get movie by movieID
    public Movies getMovieByID(int movieID) {
        String sql = "SELECT * FROM Movies AS m WHERE m.movieID = ? ;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, movieID);
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
        String sql = "SELECT movieID, COUNT(userID) AS likeCount, GROUP_CONCAT(userID) AS userID FROM UserLikes WHERE movieID = ? GROUP BY movieID;";
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
    public void insertNewMovie(String title, String description,Date releaseDate,String uniqueFileName, int duration, String trailerUrl){
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
    public Movies getMovieRecentlyAdded(){
        String sql = "SELECT * FROM Movies ORDER BY movieID DESC LIMIT 1";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Movies m = new Movies(rs.getInt("movieID"), rs.getString("title"), rs.getString("description"), rs.getDate("releaseDate"), rs.getString("posterImage"), rs.getInt("duration"), rs.getInt("display"), rs.getString("trailerUrl"), rs.getInt("likeCount"));
                return m;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //insert movie genre
    public void insertMovieGenre(int genreID, int movieID){
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

    //update movie by movieID
    public void updateMovieByID(String title, String description, Date releaseDate, String posterImage, int duration, String trailerUrl, int movieID){
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
    public void deleteMovieGenreByMovieID(int movieID){
        String sql = "DELETE FROM MovieGenres WHERE movieID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, movieID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        List<MovieGenres> list = dao.getMovieGenres(31);
        String genresID = "";
        for(MovieGenres mg : list){
            genresID += mg.getGenreID().getGenreID() + ", ";
        }
        System.out.println(genresID);

    }

}
