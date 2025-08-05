package com.sarthak;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.*;
import java.sql.*;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/Database")

public class jdbcdemo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
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
            
            //  statement.executeUpdate("Delete from products Where id = 15");
            //  statement.executeUpdate("INSERT INTO products(name,discription,price,stock,category_id)VALUES('PASTE','TOOTHPASTE',20,100,21);");
            //  statement.executeUpdate("UPDATE products SET name = 'headphone' WHERE id = 2");
            ResultSet result1 =statement.executeQuery("SELECT * FROM products WHERE id = 20");
            result1.next();
           
            for(int i = 1;i<=8;i++)
            {
                pw.println(result1.getString(i));
            }
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