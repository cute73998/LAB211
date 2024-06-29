package com.mycompany.studentmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Controller {
    Scanner sc = new Scanner(System.in);
    List <Student> students = new ArrayList<>();
    List <Student> saveTemporary = new ArrayList<>();
    
    public void showMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.println("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        Student sova = new Student();
        switch (choice) {
            case 1:
                this.createStudent();
                break;
            case 2:
                this.findAndSort();
                break;
            case 3:
                this.updateOrDeleteStudent();
                break;
            case 4:
                this.generateReport();
                break;
            case 5:
                System.out.println("Exit successfully!");
                System.exit(0);
                break;
        }
    }
    
    public void createStudent(){
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while (true) {
            count++;
            System.out.println("Enter id of student " + count + ": ");
            String id = sc.nextLine();
            System.out.println("Enter name of student: ");
            String name = sc.nextLine();
            System.out.println("Enter semester: ");
            int semester = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter course name: ");
            String courseName = sc.nextLine();
            if (courseName.equalsIgnoreCase("Java") || courseName.equalsIgnoreCase(".Net") || courseName.equalsIgnoreCase("C/C++")) {
                Student infor = new Student(id, name, semester, courseName);
                students.add(infor);
            } else if (!courseName.equalsIgnoreCase("Java") || !courseName.equalsIgnoreCase(".Net") || !courseName.equalsIgnoreCase("C/C++")) {
                System.out.println("Invalid course name !");
                System.out.println("Please enter (Java, .Net, C/C++)");
                count = count - 1;
            }
            if (count >= 10) {
                System.out.println("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen.");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("Y")) {

                } else if (choice.equalsIgnoreCase("N")) {
                    this.showMenu();
                    break;
                } else {
                    System.out.println("Invalid course name !");
                    System.out.println("Please enter Y or N");
                    if (choice.equalsIgnoreCase("Y")) {

                    } else if (choice.equalsIgnoreCase("N")) {
                        this.showMenu();
                        break;
                    }
                }
            }
        }
    }
    public void findAndSort(){
       System.out.println("Enter student name or a part of student name");
        String searchName = sc.nextLine().toLowerCase();
 
        boolean found = false;
        for (Student student : students) {
            if (student.getStudentName().toLowerCase().contains(searchName)) {
                saveTemporary.add(student);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No students found with the name containing: " + searchName);
        } else {
            // Sort saveTemporary list by student name
            Collections.sort(saveTemporary, (s1, s2) -> s1.getStudentName().compareToIgnoreCase(s2.getStudentName()));
            
            // Display sorted list
            for (Student student : saveTemporary) {
                System.out.println("ID: " +student.getId()+"Name: " + student.getStudentName() + ", Semester: " + student.getSemester() + ", Course: " + student.getCourseName());
            }
        }
    }
    public void updateOrDeleteStudent() {
        System.out.println("Enter student ID to update or delete:");
        String id = sc.nextLine();
        boolean found = false;
        
        for (Student student : students) {
            if (student.getId().equals(id)) {
                found = true;
                System.out.println("Student found:");
                System.out.println("ID: " + student.getId() + ", Name: " + student.getStudentName() + ", Semester: " + student.getSemester() + ", Course: " + student.getCourseName());
                
                System.out.println("Do you want to update (U) or delete (D) this student?");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("U")) {
                    System.out.println("Enter your choice");
                    System.out.println("(Select 1 to change all information(name, semester, course name), select 2 to change part of information)");
                    String choiceOption = sc.nextLine();
                    if(choiceOption.equals("1")){
                         System.out.println("Set name: ");
                        String studentName = sc.nextLine();
                        student.setStudentName(studentName);
                         System.out.println("Set semester: ");
                         int semester = sc.nextInt();
                         sc.nextLine();
                         student.setSemester(semester);
                        System.out.println("Set course name: ");
                        String courseName = sc.nextLine();
                        student.setCourseName(courseName);
                    }
                    else if(choiceOption.equals("2")){
                        System.out.println("1. Set id");
                        System.out.println("2. Set name");
                        System.out.println("3. Set semester");
                        System.out.println("4. Set course name");
                        System.out.println("Choice your option 1 to 4");
                        int option = sc.nextInt();
                        switch(option){
                            case 1:
                                System.out.println("Set id: ");
                        String id2 = sc.nextLine();
                        student.setId(id2);
                        break;
                            case 2:
                                 System.out.println("Set name: ");
                        String studentName = sc.nextLine();
                        student.setStudentName(studentName);
                                break;
                            case 3:
                                System.out.println("Set semester: ");
                         int semester = sc.nextInt();
                         student.setSemester(semester);
                                break;
                            case 4:
                                System.out.println("Set course name: ");
                        String courseName = sc.nextLine();
                        student.setCourseName(courseName);
                                break;
                        }
                    }
                    else{
                        System.out.println("Input invalid!");
                        System.out.println("please enter agains");
                        this.updateOrDeleteStudent();
                        break;
                    }
                    System.out.println("Update successfully! .");
                    this.showMenu();
                } else if (choice.equalsIgnoreCase("D")) {
                    // Implement delete logic here
                    students.remove(student);
                    System.out.println("Student deleted successfully.");
                    this.showMenu();
                    break;
                } else {
                    System.out.println("Invalid choice. Returning to main menu.");
                    this.showMenu();
                }
                
                break; // Exit loop after processing student
            }
        }
        
        if (!found) {
            System.out.println("No student found with ID: " + id);
            System.out.println("Please enter againt!");
            this.updateOrDeleteStudent();
        }
    }
    
    public void generateReport() {
        Map<String, Integer> courseCounts = new HashMap<>();
        
        for (Student student : students) {
            String key = student.getStudentName() + " | " + student.getCourseName();
            courseCounts.put(key, courseCounts.getOrDefault(key, 0) + 1);
        }
        
        System.out.println("Report:");
        for (Map.Entry<String, Integer> entry : courseCounts.entrySet()) {
            System.out.println(entry.getKey() + " | Total: " + entry.getValue());
        }
    }
    
}

