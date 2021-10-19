package corejavaassignment.assignment2;

public class Triangle {

    public double area(double height, double base) {

        try {
            return (height * base) / 2;
        }
        catch (ArithmeticException arithmeticException){
            arithmeticException.printStackTrace();
            return 0.0;
        }
    }

    public double perimeter(double height, double base, double side) {

        try {
            return height + base + side;
        }
        catch (ArithmeticException arithmeticException){
            arithmeticException.printStackTrace();
            return 0.0;
        }
    }
}
