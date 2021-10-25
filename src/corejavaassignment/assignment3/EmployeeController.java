package corejavaassignment.assignment3;

import java.io.*;
import java.util.Scanner;

public class EmployeeController {
    public static void main(String[] args) throws IOException {

        File file = new File("src/corejavaassignment/assignment3/Employee.txt");
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("#### Please Enter Your Choice ####");
            System.out.println("1. Add an Employee");
            System.out.println("2. Delete an Employee");
            System.out.println("3. Search for an Employee");
            System.out.println("4. Display All Employee");
            System.out.println("5. Exit \n");
            int choice = scanner.nextInt();

            switch (choice){

                case 1: // Implementation Addition of the Employee
                    System.out.println("Enter the Details of the Employee");
                    System.out.print("Enter the ID of the Employee: ");
                    Long id = scanner.nextLong();
                    System.out.print("Enter the Name of the Employee: ");
                    String name = scanner.next();
                    System.out.print("Enter the email of the Employee: ");
                    scanner.nextLine();
                    String email = scanner.next();
                    System.out.print("Enter the Age of the Employee: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter the DOB of the Employee in DD/MM/YYYY format: ");
                    String dateOfBirth = scanner.next();

                    try(FileWriter fileWriter = new FileWriter(file, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                        bufferedWriter.write("Id: "+ id + " Name: "+ name + " Email: "+ email + " Age: "+ age + " Date of Birth: "+ dateOfBirth + "\n");

                    } catch (IOException e){
                        System.out.println("Unable to Read File");
                    }

                    break;

                case 2: // Implementing Delete Operation
                    System.out.print("Please enter the Employee ID ");
                    Long deleteId = scanner.nextLong();
                    File tempFile = new File("temp.txt");
                    try (FileWriter fileWriter = new FileWriter(tempFile);
                         BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                         FileReader fileReader = new FileReader(file);
                         BufferedReader bufferedReader = new BufferedReader(fileReader)){

                        String line;
                        while( (line = bufferedReader.readLine()) != null ){
                            if(line.contains(String.valueOf(deleteId))){
                                continue;
                            }
                            else {
                                bufferedWriter.write(line);
                            }
                        }
                        file.delete();
                        tempFile.renameTo(file);

                    }catch (IOException e){
                        e.getMessage();
                    }
                    break;

                case 3: // Implementing Search Operation
                    System.out.print("Please enter the Employee ID ");
                    Long searchId = scanner.nextLong();

                    try (FileReader fileReader = new FileReader(file);
                         BufferedReader bufferedReader = new BufferedReader(fileReader)){

                        String line;
                        while( (line = bufferedReader.readLine()) != null ){

                            if(line.contains(String.valueOf(searchId))){
                                System.out.println(line);
                            }
                        }
                    }
                    break;

                case 4:
                    try (FileReader fileReader = new FileReader(file);
                         BufferedReader bufferedReader = new BufferedReader(fileReader)){

                        String line;
                        while( (line = bufferedReader.readLine()) != null ){
                               System.out.println(line);
                            }
                        }
                    break;

                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
