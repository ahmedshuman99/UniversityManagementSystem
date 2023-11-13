
package Process;

/**
 *
 * @author ahmedshuman
 */
import Accounts.AdminAccount;
import Accounts.StudentAccount;
import Accounts.TeacherAccount;
import Exceptions.BalanceNotEnoughExceptionHandling;
import Exceptions.EmailUsedBeforeExceptionHandling;
import Exceptions.InvaledEmailExceptionHandling;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class HomeCommandLine implements CommandLine{
    
    private static HomeCommandLine instance;
    public static HomeCommandLine getInstance() {
        if (instance == null) {
            instance = new HomeCommandLine();
        }
        return instance;
    }

    
     @Override
    public void commandline(String userType) {
         System.out.println("1"+""+" help");
            System.out.println("2"+""+"createStudentAccount");
            System.out.println("3"+""+"createTeacherAccount");
            System.out.println("4"+""+"adminSignIn");
            System.out.println("5"+""+"studentSignIn");
            System.out.println("6"+""+"teacherSignIn");
       try {
            Scanner in = new Scanner(System.in);
            String identity = in.next();
            switch (identity) {
                
                case "1" :
                    help();
                    break;
                case "2":
                    createStudentAccount();
                    break;
                case "3":
                    createTeacherAccount();
                    break;
                case "4": 
                    adminSignIn();
                    break;
                case "5" :
                    studentSignIn();
                    break;
                case "6" :
                    teacherSignIn();
                    break;
                default :
                    System.out.println("Invalid action. Please try again.");
                    break;
                
            }
        
           
        } catch (IOException ex) {
            Exceptions.Exceptions.handleException(ex);
        }
    }
    
   private void help() {
        System.out.println("please enter the number of the command you want\nCommands:\n1-help\n2-create student account\n3-create teacher account\n4-admin sign in\n5-student sign in\n6-teacher sign in\n7-uni president sign in");
    }

   private void createStudentAccount() throws IOException {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter your name: ");
    String name = in.next();
    System.out.println("Enter your id: ");
    int id = in.nextInt();
    System.out.println("Enter your email: ");
    String email = in.next();
    System.out.println("Enter your password: ");
    String password = in.next();
    System.out.println("Enter your balance: ");
    double balance = in.nextDouble();
    System.out.println("Enter your specialization: ");
    String specialization = in.next();

    boolean emailAssigned = checkIfEmailAssigned(email);

    if (emailAssigned ) {
        if(balance<20){
        BalanceNotEnoughExceptionHandling.balanceNotEnough(email);
        }
       EmailUsedBeforeExceptionHandling.emailUsedBefore(email);
        return;
    }

    try (FileWriter fileWriter = new FileWriter("Student.txt", true)) {
        fileWriter.write(name + "," + id + "," + email + "," + password + "," + balance + "," + specialization + "\n");
    }

    StudentAccount.Builder studentBuilder = new StudentAccount.Builder()
    .setName(name)
    .setId(id)
    .setEmail(email)
    .setPassword(password)
    .setBalance(balance)
    .setSpecialization(specialization);
    
StudentAccount student = studentBuilder.build();
    System.out.println("Student account created successfully.");
    System.out.println("You are welcome at home");
    System.out.println("*_________________________________________*");

    StudentCommandLine command = StudentCommandLine.getInstance();
    command.commandline(student);
}

   private void createTeacherAccount() throws IOException {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter your name: ");
    String name = in.next();
    System.out.println("Enter your id: ");
    int id = in.nextInt();
    System.out.println("Enter your email: ");
    String email = in.next();
    System.out.println("Enter your password: ");
    String password = in.next();
    System.out.println("Enter your specialization: ");
    String specialization = in.next();
    
    

    if (isEmailExists(email)) {
       EmailUsedBeforeExceptionHandling.emailUsedBefore(email);
        return;
    }
  
    TeacherAccount teacher = new TeacherAccount.Builder()
            .setName(name)
            .setId(id)
            .setEmail(email)
            .setPassword(password)
            .setSpecialization(specialization)
            .build();

    try (BufferedWriter writer = new BufferedWriter(new FileWriter("teacher.txt", true))) {
        writer.write(
                teacher.getName() + "," + teacher.getId() + "," + teacher.getEmail() + "," + teacher.getPassword() + "," + teacher.getSpecialization() + "\n");
    }

    System.out.println("Teacher account created successfully.");
    System.out.println("You are welcome at home.");

    TeacherCommandLine command = TeacherCommandLine.getInstance();
    command.CommandLine(teacher);
}

   private void adminSignIn(){
           String email , password;
           AdminAccount admin;
         Scanner in = new Scanner(System.in);
            System.out.println("For security reasons, please enter your email and password ");
            System.out.println("Please enter your email");
            email = in.next( );
            System.out.println("Please enter your password ");
            password = in.next();
            if (email.equals("admin@gmail.com") && password.equals("admin")){
            System.out.println("Welcome! Thank you for your understanding.");
            System.out.print("You are welcome at home ");
               AdminCommandLine command = AdminCommandLine.getInstance();
               command.commandline(email);
            }else{
                InvaledEmailExceptionHandling.handleExceptionSign(email);
             
            }
           
            
      }
   
   private void studentSignIn()throws FileNotFoundException, IOException{
       Scanner in = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email = in.nextLine().trim();
        System.out.println("Enter your password: ");
        String password = in.nextLine().trim();

        File file = new File("Student.txt");
        Scanner scanner = new Scanner(file);
        boolean isLoggedIn = false;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            if (parts.length >= 4) {
                  String storeName = parts[0].trim();
                int storeID = Integer.parseInt(parts[1].trim());
                String storedEmail = parts[2].trim();
                String storedPassword = parts[3].trim();
                double balance = Integer.parseInt(parts[4].trim());
                String storesetSpecialization = parts[5].trim();
                if (email.equals(storedEmail) && password.equals(storedPassword)) {
                    System.out.println("Success! You are logged in.");
                    System.out.println("You are welcome at home.");
                    isLoggedIn = true;
         
        StudentAccount student = new StudentAccount.Builder()
        .setName(storeName)
        .setId(storeID)
        .setEmail(storedEmail)
        .setPassword(storedPassword)
        .setBalance(balance)
        .setSpecialization(storesetSpecialization)
        .build();
                    //_____Home________
                    
               

         StudentCommandLine command = StudentCommandLine.getInstance();
       
         command.commandline(student);
      
                }
            }
        }

        if (!isLoggedIn) {
            InvaledEmailExceptionHandling.handleExceptionSign(email);
        }
   }
        
   private void teacherSignIn() throws FileNotFoundException, IOException {
     Scanner in = new Scanner(System.in);
    System.out.println("Enter your email: ");
    String email = in.next();
    System.out.println("Enter your password: ");
    String password = in.next();

    File file = new File("teacher.txt");
    Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException ex) {
         InvaledEmailExceptionHandling.handleExceptionSign(email);
        }
    boolean isLoggedIn = false;

    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] parts = line.split(",");
        String storeName = parts[0];
            int storeId = Integer.parseInt(parts[1].trim());
            String storedEmail = parts[2];
            String storedPassword = parts[3];
            String storesetSpecialization = parts[4].trim();

        if (email.equals(storedEmail) && password.equals(storedPassword)) {
            System.out.println("Success! You are logged in.");
             System.out.print("You are welcome at home ");
            isLoggedIn = true;
                //_______home_______
               TeacherAccount teacher = new TeacherAccount.Builder()
                        .setName(storeName)
                        .setId(storeId)
                        .setEmail(storedEmail)
                        .setPassword(storedPassword)
                        .setSpecialization(storesetSpecialization)
                        .build();
              
                TeacherCommandLine command = TeacherCommandLine.getInstance();
                command.CommandLine(teacher);
                break;
            }
        
    }

    if (!isLoggedIn) {
       InvaledEmailExceptionHandling.handleExceptionSign(email);
    }

    // scanner.close();
}
   
   

   private static boolean isEmailExists(String email) throws IOException {
       try (BufferedReader reader = new BufferedReader(new FileReader("teacher.txt"))) {
           String line;
           while ((line = reader.readLine()) != null) {
               String[] parts = line.split(",");
               if (parts.length >= 3 && parts[2].equals(email)) {
                   reader.close();
                   return true;
               }
           }
       }
        return false;
    }
    
   
   private boolean checkIfEmailAssigned(String email) {
    try {
        List<String> lines = Files.readAllLines(Paths.get("Student.txt"));
        for (String line : lines) {
            String[] studentData = line.split(",");
            String assignedEmail = studentData[2];
            if (assignedEmail.equalsIgnoreCase(email)) {
                return true; 
            }
        }
    } catch (IOException e) {
        InvaledEmailExceptionHandling.handleExceptionSign(email);
    }

    return false; 
}

   

   

}
