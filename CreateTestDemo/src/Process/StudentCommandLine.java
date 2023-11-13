/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;


import Accounts.StudentAccount;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ahmedshuman
 */
public class StudentCommandLine  implements CommandLine {
    
    private static StudentCommandLine instance;
     Scanner in = new Scanner(System.in);
    
    public static StudentCommandLine getInstance() {
        if (instance == null) {
            instance = new StudentCommandLine();
        }
        return instance;
    }
    StudentAccount student;
    
    public void commandline(StudentAccount student) throws IOException {
        String choice;

while (true) {
    System.out.println("1. About you");
    System.out.println("2. Get help");
    System.out.println("3. Select Your Course");
    System.out.println("4. Show Your Degree");
    Scanner in = new Scanner(System.in);
   choice = in.next();

    switch (choice) {
        case "1":
            About(student);
            break;
        case "2":
            Help(student);
            break;
        case "3":
            selectAndPayYourCourse(student);
            break;
        case "4":
            showDegree();
            break;
        case "5":
            printCourseInfoFromFile();
        default:
            System.out.println("Invalid choice. Please try again.");
           
             break;
    }

    continue; 
}
    
    }
   
    
    public  static void StudentActions(StudentAccount student) throws IOException {

   }
    
    private static void About(StudentAccount student) {
        System.out.println("Your name is: " + student.getName());
        System.out.println("Your email is: " + student.getEmail());
        System.out.println("Your Balance is: " + student.getBalance());
    }

    private static void Help(StudentAccount student) {
        double balances = student.getBalance();
        double updatedBalance = balances + 50;
        System.out.println("Your Balance Now is: " + updatedBalance);
    }

    public static void selectAndPayYourCourse(StudentAccount student) throws IOException {
    System.out.println("Select Your course");
    printCourseInfoFromFile();
    Scanner in = new Scanner(System.in);
    String courseName = in.next();
    File file = new File("courses.txt");
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] parts = line.split(",");
        if (parts.length >= 2) {
            String coursesName = parts[0].trim();
            int balance = Integer.parseInt(parts[1].trim());
            double updateBalance = student.getBalance() - balance;
            if (courseName.equals(coursesName)) {
    System.out.println("Your current currency is: " + updateBalance);
    String email = student.getEmail();
                System.out.println();
    if (email != null) {
        try (BufferedWriter emailWriter = new BufferedWriter(new FileWriter(coursesName + ".txt", true))) {
            emailWriter.write(email);
            emailWriter.newLine();
        } catch (IOException e) {
            Exceptions.Exceptions.handleException(e);
        }
    } else {
        System.out.println("Email is null. Cannot write to file.");
    }
}
        }
    }
}
    
    public static void showDegree() {    
    System.out.println("Select Your course");
    printCourseInfoFromFiles();
    Scanner in = new Scanner(System.in);
    String courseName = in.next();
    File file = new File(courseName + "Degree.txt");
    try {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
              System.out.println(scanner.nextLine());
              }
        } catch (FileNotFoundException ex) {
              Exceptions.Exceptions.handleException(ex);
              }
    }


   public static void printCourseInfoFromFile() {
    try (BufferedReader br = new BufferedReader(new FileReader("courses.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] elements = line.split(",");
            if (elements.length == 2) {
                String courseName = elements[0].trim();
                String courseCost = elements[1].trim();
                System.out.println("Name of course is: " + courseName + ", Cost of course is: " + courseCost);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
   }
  
    @Override
    public void commandline(String userType) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
     public static void printCourseInfoFromFiles() {
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
}
   
    
    

