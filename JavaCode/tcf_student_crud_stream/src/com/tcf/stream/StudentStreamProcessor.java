package com.tcf.stream;

import com.tcf.model.Student;
import java.util.List;
import java.util.stream.Collectors;

public class StudentStreamProcessor {
    public void process(List<Student> students) {
        System.out.println("--- Stream API Output: Students with grade > 80 sorted by name ---");
        List<Student> result = students.stream()
            .filter(s -> s.getGrade() > 80)
            .sorted((a, b) -> a.getName().compareToIgnoreCase(b.getName()))
            .collect(Collectors.toList());

        for (Student s : result) {
            System.out.println(s.getName() + " (Grade: " + s.getGrade() + ")");
        }
    }
}
