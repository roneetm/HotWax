package CoreJavaAssignment.Assignment2;

import java.util.Scanner;

public class Sphere {

    public double area(double radius) {

        try {
            return 4 * Math.PI * ( Math.pow(radius, 2));
        }
        catch (ArithmeticException arithmeticException){
            arithmeticException.printStackTrace();
            return 0.0;
        }
    }

    public double volume(double radius) {

        try {
            return (4/3) * Math.PI * Math.pow(radius, 3);
        }
        catch (ArithmeticException arithmeticException){
            arithmeticException.printStackTrace();
            return 0.0;
        }

    }
}
