package CoreJavaAssignment.Assignment2;

public class Cylinder {

    public double area(double radius, double height) {

        try {
            return Math.PI * Math.pow(radius, 2);
        }
        catch (ArithmeticException arithmeticException){
            arithmeticException.printStackTrace();
            return 0.0;
        }
    }

    public double volume(double radius, double height) {

        try {
            return Math.PI * Math.pow(radius, 2) * height;
        }
        catch (ArithmeticException arithmeticException){
            arithmeticException.printStackTrace();
            return 0.0;
        }
    }
}