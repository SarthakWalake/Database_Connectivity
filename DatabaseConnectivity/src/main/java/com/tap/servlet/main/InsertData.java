package com.tap.servlet.main;

import java.io.*;
import java.sql.*;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/insert")
public class InsertData extends HttpServlet {
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

            statement.executeUpdate(
                    "INSERT INTO products(name,description,price,stock,category_id)VALUES('PASTE','TOOTHPASTE',20,100,2);");
           pw.println("Data Inserted Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
