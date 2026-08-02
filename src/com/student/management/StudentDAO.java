package com.student.management;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {
                     // Add student
    public  boolean addStudent(Student student){
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
         int rowAffected=  ps.executeUpdate();

         return rowAffected>0;

       }
       catch(SQLException e){
           e.printStackTrace();
           return false;

       }


    }

    //Search student by id
    public Student searchStudent(int id){
        String sql="Select * From student Where id =?";
        try(
                Connection con= DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setInt(1,id);

            ResultSet rs= ps.executeQuery();

            if(rs.next()){
              int sid =rs.getInt("id");
              String name=rs.getString("name");
              int age=rs.getInt("age");
              String email=rs.getString("email");
              String course=rs.getString("course");
              String add=rs.getString("address");

              Student stu=new Student(sid, name, age,email,course,add);
              return stu;
            }

        }

        catch(SQLException e){
          e.printStackTrace();

        }
        return null;
    }

    //display or view student

    public ArrayList<Student> viewAllStudent(){
        ArrayList<Student> students=new ArrayList<>();
        String sql="SELECT * FROM student";
        try(
                Connection con=DBConnection.getConnection();
                PreparedStatement ps= con.prepareStatement(sql);
                ){

            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String course = rs.getString("course");
                String add = rs.getString("address");

                Student stu = new Student(id, name, age, email, course, add);

                students.add(stu);


            }



        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return students;

    }


   // To update student
    public  boolean updateStudent(Student student) {
        String sql = "UPDATE student SET name=?, age=?, email=?, course=?, address=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getCourse());
            ps.setString(5, student.getAddress());
            ps.setInt(6, student.getId());

            int rowUpdated = ps.executeUpdate();

            return rowUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }
               // To Delete Student
    public  boolean deleteStudent(int id ) {
        String sql = "DELETE FROM student WHERE id=? ";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1,id);

            int rowDeleted = ps.executeUpdate();

            return rowDeleted> 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }

}
