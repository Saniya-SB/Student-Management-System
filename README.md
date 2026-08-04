# 🎓 Student Management System

A **menu-driven console application** developed using **Java, JDBC, and MySQL** that performs complete **CRUD (Create, Read, Update, Delete)** operations on student records.

---

## ✨ Features

- ➕ Add Student
- 🔍 Search Student by ID
- 📋 View All Students
- ✏️ Update Student Details
- 🗑️ Delete Student
- ✅ Delete Confirmation
- 📚 Menu-Driven Console Interface

---

## 🛠️ Tech Stack

- Java
- JDBC
- MySQL
- IntelliJ IDEA

---

## 📁 Project Structure

```text
Student-Management-System
│
├── src/
│   └── com/
│       └── student/
│           └── management/
│               ├── Main.java
│               ├── Student.java
│               ├── StudentDAO.java
│               └── DBConnection.java
│
├── README.md
└── .gitignore
```

---

## 🏗️ Architecture

```text
           User
             │
             ▼
        Main.java
             │
             ▼
      StudentDAO.java
             │
             ▼
     DBConnection.java
             │
             ▼
        MySQL Database
```

---

## 🗄️ Database

**Database Name**

```text
student_management
```

**Table Name**

```text
student
```

| Column | Type |
|--------|------|
| id | INT (Primary Key) |
| name | VARCHAR |
| age | INT |
| email | VARCHAR |
| course | VARCHAR |
| address | VARCHAR |

---

## 🚀 How to Run

1. Clone the repository.

```bash
git clone https://github.com/Saniya-SB/Student-Management-System.git
```

2. Open the project in IntelliJ IDEA.

3. Create the MySQL database and table.

4. Update your database credentials in `DBConnection.java`.

5. Run `Main.java`.

---

## 📚 Concepts Used

- Object-Oriented Programming (OOP)
- JDBC
- PreparedStatement
- ResultSet
- Try-with-Resources
- Exception Handling
- ArrayList
- Enhanced For Loop
- CRUD Operations

---

## 📸 Console Menu

```text
--------------------------------------------
       Student Management System
--------------------------------------------

1. Add Student
2. Search Student
3. View All Students
4. Update Student
5. Delete Student
6. Exit
```

---

## 🔮 Future Enhancements

- Input Validation
- Email Validation
- Search by Name
- Sort Students
- Export Student Data
- GUI Version (JavaFX/Swing)
- Spring Boot REST API

---

## 👩‍💻 Author

**Saniya Bano**

B.Tech Computer Science & Engineering  
Aspiring Java Backend Developer

---

⭐ If you like this project, consider giving it a star.
