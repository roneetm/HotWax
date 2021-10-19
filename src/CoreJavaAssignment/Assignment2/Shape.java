package CoreJavaAssignment.Assignment2;

import java.util.Scanner;

public class Shape {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

        try {
            while (true){

                System.out.println("### SELECT ANY SHAPE ###");
                System.out.println("1. Circle");
                System.out.println("2. Rectangle");
                System.out.println("3. Square");
                System.out.println("4. Triangle");
                System.out.println("5. Sphere");
                System.out.println("6. Cylinder");
                System.out.println("7. Exit");
                System.out.println("### ### ### ### ###");

                int number = scanner.nextInt();

                switch (number){

                    case 1:
                        System.out.println("Enter the Radius of the Circle");
                        double radiusOfCircle = scanner.nextInt();
                        Circle circle = new Circle();
                        System.out.println("Area of the Circle is "+ circle.area(radiusOfCircle));
                        System.out.println("Area of the Circle is "+ circle.circumference(radiusOfCircle));
                        break;

                    case 2: System.out.println("Enter the length of the Rectangle");
                        double length = scanner.nextInt();
                        System.out.println("Enter the breadth of the Rectangle");
                        double breadth = scanner.nextInt();
                        Rectangle rectangle = new Rectangle();
                        rectangle.area(length, breadth);
                        rectangle.perimeter(length, breadth);
                        break;

                    case 3:
                        System.out.println("Enter the Length of the Square");
                        double lengthOfSquare = scanner.nextInt();
                        Square square = new Square();
                        square.area(lengthOfSquare);
                        square.perimeter(lengthOfSquare);
                        break;

                    case 4:
                        System.out.println("Enter the height of the Triangle");
                        double height = scanner.nextInt();
                        System.out.println("Enter the Base of the Triangle");
                        double base = scanner.nextInt();
                        System.out.println("Enter the side of the Triangle");
                        double side = scanner.nextInt();
                        Triangle triangle = new Triangle();
                        triangle.area(height, base);
                        triangle.perimeter(height, base, side);
                        break;

                    case 5:
                        System.out.println("Enter the Radius of the Sphere");
                        double radiusOfSphere = scanner.nextInt();
                        Sphere sphere = new Sphere();
                        sphere.area(radiusOfSphere);
                        sphere.volume(radiusOfSphere);
                        break;

                    case 6:
                        System.out.println("Enter the Radius of the Cylinder");
                        double radiusOfCylinder = scanner.nextInt();
                        System.out.println("Enter the Height of the Cylinder");
                        double heightOfCylinder = scanner.nextInt();Cylinder cylinder = new Cylinder();
                        cylinder.area(radiusOfCylinder, heightOfCylinder);
                        cylinder.volume(radiusOfCylinder, heightOfCylinder);
                        break;

                    case 7:
                        System.out.println("Good Bye!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice");
                }
            }
        }
        catch (NullPointerException nullPointerException){
            System.out.println("Enter number in the given range");
        }
    }
}
