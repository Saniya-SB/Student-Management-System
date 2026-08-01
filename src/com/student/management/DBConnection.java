package com.student.management;

import java.sql.*;

public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/student_management";
    private static final String user = "root";
    private static final String psw = "S@niy@sql2026";

        public static Connection getConnection(){
        try{
                Connection con= DriverManager.getConnection(url,user,psw);


            System.out.println("Database Connected successfully");
            return con;


        }
        catch(SQLException e){
            System.out.println("Failed to connect database");
            e.printStackTrace();
            return null;
        }
    }
}
