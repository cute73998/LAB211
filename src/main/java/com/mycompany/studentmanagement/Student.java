package com.mycompany.studentmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {

    List<Student> save = new ArrayList<>();
    private String id;
    private String studentName;
    private int semester;
    private String courseName;

    public Student(String id, String studentName, int semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getSemester() {
        return semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "id: " + id + ", studentName: " + studentName + ", semester: " + semester + ", courseName: " + courseName;
    }

}
