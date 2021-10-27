package corejavaassignment.assignment2;

public class Square {


    public double area(double length) {

        try {
            return Math.pow(length, 2);
        }
        catch (ArithmeticException arithmeticException){
            arithmeticException.printStackTrace();
            return 0.0;
        }
    }

    public double perimeter(double length) {

        try {
            return 4 * length;
        }
        catch (ArithmeticException arithmeticException){
            arithmeticException.printStackTrace();
            return 0.0;
        }

    }
}
