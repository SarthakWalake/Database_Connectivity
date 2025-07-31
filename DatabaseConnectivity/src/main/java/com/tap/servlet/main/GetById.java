package com.tap.servlet.main;


import java.io.*;
import java.sql.*;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/getbyid")
public class GetById extends HttpServlet {
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
            
           
           
             ResultSet result1 =statement.executeQuery("SELECT * FROM products WHERE id = 20");
            result1.next();
           
            for(int i = 1;i<=8;i++)
            {
                pw.println(result1.getString(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}






    