package com.tcf.service;

import com.tcf.db.DatabaseConnection;
import com.tcf.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public void insertStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students (id, name, grade) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, student.getId());
            stmt.setString(2, student.getName());
            stmt.setInt(3, student.getGrade());
            stmt.executeUpdate();
            System.out.println("Inserted student: " + student.getName());
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("grade")));
            }
        }
        return students;
    }

    public void updateStudentGrade(int id, int newGrade) throws SQLException {
        String sql = "UPDATE students SET grade = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, newGrade);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Updated student ID: " + id);
        }
    }

    public void deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Deleted student with ID: " + id);
        }
    }
}
