/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import DAO.admin_DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.Record;


/**
 *
 * @author baoquoc
 */
@WebServlet(name = "CinemaDataServlet", urlPatterns = {"/getCinemaData"})
public class CinemaDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        String cinemaName = request.getParameter("cinemaName");
        admin_DAO ad = new admin_DAO();
        List<Record> list = ad.getCinemaData(cinemaName);
        
        String json = new Gson().toJson(list);
        out.print(json);
        out.flush();
    }
}
