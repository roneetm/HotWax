package corejavaassignment.assignment2;

public class Rectangle {

    public double perimeter(double length, double breadth) {
       try {
           return 2 * (length * breadth);
       }
       catch (ArithmeticException arithmeticException){
           arithmeticException.printStackTrace();
           return 0.0;
       }
    }

    public double area(double length, double breadth) {

        try {
            return length * breadth;
        } catch (ArithmeticException arithmeticException){
            arithmeticException.printStackTrace();
            return 0.0;
        }
    }
}
