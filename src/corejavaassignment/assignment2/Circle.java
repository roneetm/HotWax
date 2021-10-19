package corejavaassignment.assignment2;

public class Circle{

    public double area(double radius) {

        try {
            return Math.PI * Math.pow(radius, 2);
        }
        catch (ArithmeticException arithmeticException){
            arithmeticException.printStackTrace();
            return 0.0;
        }
    }

    public double circumference(double radius) {

        try {
            return (2 * Math.PI * radius);
        }
        catch (ArithmeticException arithmeticException){
            arithmeticException.printStackTrace();
            return 0.0;
        }
    }
}