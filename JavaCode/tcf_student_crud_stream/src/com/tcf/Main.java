package com.tcf;

import com.tcf.model.Student;
import com.tcf.service.StudentService;
import com.tcf.stream.StudentStreamProcessor;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        StudentStreamProcessor processor = new StudentStreamProcessor();

        try {
            System.out.println("--- Inserting Students ---");
            service.insertStudent(new Student(1, "Alice", 91));
            service.insertStudent(new Student(2, "Bob", 76));
            service.insertStudent(new Student(3, "Charlie", 84));

            System.out.println("\n--- Fetching All Students ---");
            List<Student> students = service.getAllStudents();
            students.forEach(System.out::println);

            System.out.println("\n--- Updating Student (ID=2) ---");
            service.updateStudentGrade(2, 82);

            System.out.println("\n--- Fetching All Students After Update ---");
            students = service.getAllStudents();
            students.forEach(System.out::println);

            System.out.println("\n--- Deleting Student (ID=1) ---");
            service.deleteStudent(1);

            System.out.println("\n--- Fetching All Students After Deletion ---");
            students = service.getAllStudents();
            students.forEach(System.out::println);

            System.out.println();
            processor.process(students);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}