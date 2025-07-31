package com.tap.servlet.main;


import java.io.*;
import java.sql.*;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/getalldata")
public class GetAll extends HttpServlet {
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
            
           
           
            ResultSet result = statement.executeQuery("SELECT * FROM products;");

           
            while (result.next()) {
                pw.println(result.getInt(1) + " " + result.getString(2) + " " + result.getString(3) + " "
                        + result.getInt(4) + " " + result.getInt(5) + " " + result.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}






    