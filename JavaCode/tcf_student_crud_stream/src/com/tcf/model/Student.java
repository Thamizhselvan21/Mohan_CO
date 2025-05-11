package com.tcf.model;

public class Student {
    private int id;
    private String name;
    private int grade;

    public Student(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getGrade() { return grade; }

    public void setGrade(int grade) { this.grade = grade; }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', grade=" + grade + "}";
    }
}
