package com.student.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {

    public  void addStudent(Student student){
        String sql = "INSERT INTO student(id,name,age,email,course,address) VALUES(?,?,?,?,?,?)";

       try (        Connection con = DBConnection.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql);)
       {
           ps.setInt(1,student.getId());
           ps.setString(2, student.getName());
           ps.setInt(3,student.getAge());
           ps.setString(4,student.getEmail());
           ps.setString(5, student.getCourse());
           ps.setString(6, student.getAddress());
           ps.executeUpdate();

           System.out.println("Record Insertion successful");

       }
       catch(SQLException e){
           System.out.println("Inserting Record Unsuccessful");
           e.printStackTrace();

       }


    }


}
