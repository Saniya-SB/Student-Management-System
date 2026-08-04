package com.student.management;
import java.util.*;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao=new StudentDAO();
        int choice;

        do {
            System.out.println("\n--------------------------------------------");

            System.out.println("STUDENT MANAGEMENT SYSTEM");
            System.out.println("--------------------------------------------");

            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. View All Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.println("Enter your Choice");
            choice=sc.nextInt();

            switch(choice) {

                //Add student

                case 1:{
                    System.out.println("Enter Student id:");
                    int id = sc.nextInt();

                    //to remove leftover space after sc.nextInt and before sc.nextLine of string
                    sc.nextLine();

                    System.out.println("Enter Student name");
                    String name = sc.nextLine();

                    System.out.println("Enter Student age");
                    int age = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Enter Student email");
                    String email = sc.nextLine();

                    System.out.println("Enter Student course");
                    String course = sc.nextLine();

                    System.out.println("Enter Student address");
                    String address = sc.nextLine();


                    Student student = new Student(id, name, age, email, course, address);


                    boolean isAdded = dao.addStudent(student);
                    if (isAdded) {
                        System.out.println("Record added successfully");
                    } else {
                        System.out.println("Failure! Record didn't add successfully");
                    }
                    break;
            }
                //Search Student by Id
                case 2: {
                    System.out.println("Enter Student id");
                    int id = sc.nextInt();

                    Student foundStudent = dao.searchStudent(id);

                    if (foundStudent != null) {
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("No student of id " + id + " found");
                    }

                    break;

                }
                 //View All Student
                case 3: {

                    ArrayList<Student> students = dao.viewAllStudent();

                    if (students.isEmpty()) {
                        System.out.println("No students found");
                    } else {
                        for (Student everystudent : students) {
                            System.out.println(everystudent);
                        }

                    }
                    break;

                }
            //update student
                case 4: {
                    System.out.println("Enter Student id:");
                    int id = sc.nextInt();


                    Student student = dao.searchStudent(id);

                    if (student != null) {
                        System.out.println(student);

                        sc.nextLine();

                        System.out.println("Enter New name");
                        String name = sc.nextLine();

                        System.out.println("Enter New age");
                        int age = sc.nextInt();

                        sc.nextLine();

                        System.out.println("Enter New email");
                        String email = sc.nextLine();

                        System.out.println("Enter New course");
                        String course = sc.nextLine();

                        System.out.println("Enter New address");
                        String address = sc.nextLine();

                        Student foundStudent = new Student(id, name, age, email, course, address);

                        boolean isUpdated = dao.updateStudent(foundStudent);

                        if(isUpdated){
                            System.out.println("Record Updated Successfully");
                        }
                        else{
                            System.out.println("Failure! Recored didn't update successfully");
                        }

                    } else {
                        System.out.println("No student of id " + id + " found");
                    }
                    break;

                }

                //Delete Student
                    case 5:{
                        System.out.println("Enter Student id");
                        int id=sc.nextInt();


                        Student student = dao.searchStudent(id);

                        if (student != null) {
                            System.out.println(student);
                            System.out.println("Are you sure you want to delete this student? (Y/N)");
                            String option=sc.next();

                            if(option.equalsIgnoreCase("y")){

                            boolean isDeleted= dao.deleteStudent(id);
                            if(isDeleted){
                                System.out.println("Record Deleted Successfully");
                            }
                            else{
                                System.out.println("Record didn't delete");
                            }

                        }
                            else{
                                System.out.println("Deletion cancelled.");
                            }
                        }


                            else {
                            System.out.println("No student of id " + id + " found");
                        }
                            break;
                    }

                case 6:
                    System.out.println("Thank you for using Student Management System.\n" +
                            "Exiting...");
                    System.out.println("Application closed successfully.");
                    break;


               default:
                   System.out.println("Invalid choice! Please enter a number between 1 and 6.");

            }

        }while(choice!=6);
        sc.close();

    }
}
