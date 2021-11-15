package corejavaassignment.assignment5;

import java.io.*;
import java.util.ArrayList;

public class DeserializationTest {
    public static void main(String[] args) throws FileNotFoundException {

        try (FileInputStream fileInputStream = new FileInputStream("src/assignment5/")) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

                ArrayList<Student> students = (ArrayList<Student>) objectInputStream.readObject();

                if (students != null) {
                    for (Student student : students) {
                        System.out.println(student.toString());
                    }
                }

            } catch (FileNotFoundException f) {
                f.getMessage();
            } catch (IOException ioException) {
                ioException.getMessage();
            } catch (ClassNotFoundException e) {
                e.getMessage();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
