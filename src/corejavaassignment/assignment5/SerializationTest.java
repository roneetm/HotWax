package corejavaassignment.assignment5;

import java.io.*;
import java.util.ArrayList;

public class SerializationTest {
    public static void main(String[] args) {

        //constructs four different Student objects
        Address address1 = new Address("Indore", "Madhya Pradesh", 452016, "India");
        Student student1 = new Student("Roneet Michael", "10/11/1995", address1);

        Address address2 = new Address("Mumbai", "Maharashtra", 452010, "India");
        Student student2 = new Student("Michael Scofield", "03/20/1993", address2);

        Address address3 = new Address("Delhi", "Delhi", 472010, "India");
        Student student3 = new Student("Dominic Toretto", "26/01/1994", address3);

        Address address4 = new Address("Kochi", "Kerela", 420001, "India");
        Student student4 = new Student("Marshall Mathers", "17/10/1984", address4);

        //Placing Students in list
        ArrayList<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);

        try{
            FileOutputStream fileOutputStream = new FileOutputStream("src/assignment5/");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);

        }
        catch (FileNotFoundException fileNotFoundException){
            fileNotFoundException.getMessage();
        }
        catch (IOException ioException){
            ioException.getMessage();
        }
    }
}
