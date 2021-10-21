package corejavaassignment.assignment3;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Scanner;

public class EmployeeController {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File file = new File("src/corejavaassignment/assignment3/Employee.txt");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> list = new ArrayList<>();
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        ListIterator listIterator = null;

                objectInputStream = new ObjectInputStream(new FileInputStream(file));
                list = (ArrayList<Employee>) objectInputStream.readObject();
                objectInputStream.close();

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

                    list.add((new Employee(id, name, email, age, dateOfBirth)));
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
                    objectOutputStream.writeObject(list);
                    objectOutputStream.close();

                    break;

                case 2: // Implementing Delete Operation
                    System.out.print("Please enter the Employee ID ");
                    Long deleteId = scanner.nextLong();

                    listIterator = list.listIterator();
                    while(listIterator.hasNext()){
                        Employee e = (Employee) listIterator.next();
                        if(Objects.equals(e.getId(), deleteId)){
                            list.remove(e);
                            System.out.println("Deleted Successfully");
                        }
                        else {
                            System.out.println("Employee Doesn't Exist!");
                        }
                    }
                    break;

                case 3: // Implementing Search Operation
                    System.out.print("Please enter the Employee ID ");
                    //String searchName = scanner.next();
                    Long searchId = scanner.nextLong();

                    listIterator = list.listIterator();
                    while(listIterator.hasNext()){
                        Employee e = (Employee) listIterator.next();
                        if(e.getId() == searchId){
                            System.out.println(e.toString());
                        }
                        System.out.println("Record Not Available");
                    }
                    break;

                case 4:
                    // Displaying all the Employee Records
                    listIterator = list.listIterator();
                    while(listIterator.hasNext()){
                        System.out.println(listIterator.next());
                    }
                    break;

                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
