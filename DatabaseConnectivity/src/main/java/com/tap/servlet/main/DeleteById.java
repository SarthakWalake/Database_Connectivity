package com.tap.servlet.main;

import java.io.*;
import java.sql.*;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/deletebyid")

public class DeleteById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            String URL = "jdbc:mysql://localhost:3306/tflecommerce";
            String Username = "root";
            String Password = "Sarthak@2004";
            Connection connection;

            PrintWriter pw = response.getWriter();
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, Username, Password);
            Statement statement = connection.createStatement();

            statement.executeUpdate("DELETE FROM products WHERE id = 1;");
            pw.println("Data deleted Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
