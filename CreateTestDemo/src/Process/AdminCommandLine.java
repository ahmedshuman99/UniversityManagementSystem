/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import Exceptions.AdminExceptionsHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;

/**
 *
 * @author ahmedshuman
 */
public class AdminCommandLine implements CommandLine {
     public static ArrayList<String> courses = new ArrayList<>();
     private static AdminCommandLine instance;
    
    public static AdminCommandLine getInstance() {
        if (instance == null) {
            instance = new AdminCommandLine();
        }
        return instance;
    }
    
     public static  boolean semesterStarted = false;
     @Override
    public void commandline(String userType) {
        while(true){
        System.out.println("1"+""+"help");
         System.out.println("2"+""+"addCourse");
         System.out.println("3"+""+"deleteCourse");
         System.out.println("4"+""+"ShowListOfStudents");
         System.out.println("5"+""+"ShowListOfTeachers");
         System.out.println("6"+""+"ShowListOfCourses");
          Scanner in = new Scanner(System.in);
          String Choice = in.next();
        switch (Choice) {
            case "1":
                help();
                break;
            case "2":
                addCourse();
                break;
            case "3" :
                deleteCourse();
                break;
            case "4" :
                showListOfStudent();
                break;
            case "5" :
                 showListOfTeachers();
                break;
            case "6" :
               printCourseInfoFromFile();
                break;
            default :
                System.out.println("Invalid action. Please try again.");
                break;
     }
        continue;
        }
    
    }
    
    public static void help(){
      System.out.println("please enter the number of the command you want\nCommands");
    }
      

    public static void addCourse() {
    try {
        System.out.println("Enter course's name:");
        Scanner in = new Scanner(System.in);
        String courseName = in.next();

        System.out.println("Enter course's cost:");
        String cost = in.next();
 
        courses.add(courseName);
 
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + File.separator + "courses.txt";
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.println(courseName + "," + cost);
        }
        
        System.out.println("Course added successfully.");
    } catch (IOException e) {
        AdminExceptionsHandler.handleException(e);
    }
}
 
    public static void deleteCourse() {
    System.out.println("Enter course's name:");
    Scanner in = new Scanner(System.in);
    String courseName = in.next();
    
    File file = new File(courseName);
    boolean removed = file.delete();
    
    if (removed) {
        System.out.println("Course deleted: " + courseName);
    } else {
        System.out.println("Course not found.");
    }
}
    
    public static void showListOfTeachers(){
     File seFile = new File("teacher.txt");
                    try (Scanner seScan = new Scanner(seFile)) {
                        while (seScan.hasNextLine()) {
                            System.out.println(seScan.nextLine());
                        }
                    } catch (FileNotFoundException ex) {
             AdminExceptionsHandler.handleException(ex);
            }
   }
    
    public static void showListOfStudent(){
     File seFile = new File("Student.txt");
                    try (Scanner seScan = new Scanner(seFile)) {
                        while (seScan.hasNextLine()) {
                            System.out.println(seScan.nextLine());
                        }
                    } catch (FileNotFoundException ex) {
             AdminExceptionsHandler.handleException(ex);
            }

}
   
    public static void printCourseInfoFromFile() {
    File seFile = new File("Student.txt");
        while ((line = br.readLine()) != null) {
            String[] elements = line.split(",");
            if (elements.length == 2) {
                String courseName = elements[0].trim();
                String courseCost = elements[1].trim();
                System.out.println("Name of course is: " + courseName + ", Cost of course is: " + courseCost);
            }
        }
    } 
   

}
    
    
    
    
    

