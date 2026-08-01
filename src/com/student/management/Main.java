package com.student.management;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
        if(con!=null){
            System.out.println("Connection established successfully");
        }
        else{
            System.out.println("Connection failed");
        }



    }
}
