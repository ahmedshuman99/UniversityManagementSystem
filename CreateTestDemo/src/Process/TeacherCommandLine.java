/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import Accounts.TeacherAccount;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author ahmedshuman
 */
public class TeacherCommandLine implements CommandLine  {

 
    private static TeacherCommandLine instance;
    public static TeacherCommandLine getInstance() {
        if (instance == null) {
            instance = new TeacherCommandLine();
        }
        return instance;
    }
    
    
    public static void CommandLine(TeacherAccount teacher) throws IOException {
        while(true){
        Scanner in = new Scanner(System.in);
        System.out.println("1. About You");
        System.out.println("2. register on Courses");
        System.out.println("3. Show emails of students registered in the course"); 
        System.out.println("4. assign Degrees of courses");
        System.out.println("5. showAllCourseRegisteredIt");
        
            String choice = in.next();  
        switch (choice) {
            case "1":
                about(teacher);
                break;
            case "2":  
                registerOfCourses(teacher);
                break;
            case "3":
                showListOfStudentAtEachCourse();
                break;
            case "4":
                 AssignDegreeOfCourses();
                break;
            case "5":
                showAllCourseRegisteredIt();
                break;

        }
        continue;
        }
         
   }
    
    private static void about(TeacherAccount teacher) {
        System.out.println("Your name is: " + teacher.getName());
        System.out.println("Your email is: " + teacher.getEmail());
        System.out.println("Your specialization is: " + teacher.getSpecialization());
    }
     
    private static void registerOfCourses(TeacherAccount teacher) throws FileNotFoundException {
    System.out.println("Select your course");
    printCourseInfoFromFile();
    Scanner in = new Scanner(System.in);
    String courseName = in.next();
    File file = new File(courseName + ".txt");
    Scanner scanner = new Scanner(file);
    String email = teacher.getEmail();
    boolean emailAssigned = false;

    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (line.equals(email)) {
            emailAssigned = true;
            break;
        }
    }
    scanner.close();

    if (emailAssigned) {
        System.out.println("Warning: Email already assigned to the selected course.");
    } else {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            writer.println(email);
            System.out.println("Email assigned successfully to the selected course.");
        } catch (IOException e) {
            System.out.println("Error occurred while assigning email to the course: " + e.getMessage());
        }
    }
}
    
    
    public static void showListOfStudentAtEachCourse() throws FileNotFoundException {
    System.out.println("Select your course");
    printCourseInfoFromFile();
    Scanner in = new Scanner(System.in);
    String courseName = in.next();
    File file = new File(courseName + ".txt");
    try {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
              System.out.println(scanner.nextLine());
              }
        } catch (FileNotFoundException ex) {
              Exceptions.Exceptions.handleException(ex);
              }
 
    }
    
    public static void AssignDegreeOfCourses() throws IOException {
    System.out.println("Select Your course");
    printCourseInfoFromFile();
    Scanner in = new Scanner(System.in);
    String courseName = in.next();
    File file = new File(courseName + "Degree.txt");

    try (BufferedWriter degree = new BufferedWriter(new FileWriter(file, true))) {
        System.out.println("Enter your email address:");
        String emailAddress = in.next();

        System.out.println("Enter your degree (A, B, or C):");
        String degreeValue = in.next();

        degree.write(emailAddress);
        degree.newLine();
        degree.write(degreeValue);
        degree.newLine();
    }
}
    
     public static void showAllCourseRegisteredIt() {
    System.out.println("Select your course");
    printCourseInfoFromFile();
    Scanner in = new Scanner(System.in);
    String courseName = in.next();
    File file = new File(courseName + ".txt");
    

    Scanner emailScanner = new Scanner(System.in);
    System.out.println("Enter your email");
    String email = emailScanner.next();

    try {
        Scanner fileScanner = new Scanner(file);
        boolean emailFound = false;

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            if (line.equals(email)) {
                emailFound = true;
                break;
            }
        }

        fileScanner.close();

        if (emailFound) {
            System.out.println("Already registered");
        } else {
            System.out.println("Not registered");
        }
    } catch (FileNotFoundException e) {
        System.out.println("Error occurred while reading the course file: " + e.getMessage());
    }
}
   
     
     public static void printCourseInfoFromFile() {
    try (BufferedReader br = new BufferedReader(new FileReader("courses.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] elements = line.split(",");
            if (elements.length == 2) {
                String courseName = elements[0].trim();
                System.out.println("Name of course is: " + courseName);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    @Override
    public void commandline(String userType) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

   

   
    

