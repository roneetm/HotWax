package corejavaassignment.assignment2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShapeMain {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        try {
            while (true) {

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

                    switch (number) {

                        case 1:
                            System.out.println("Enter the Radius of the Circle");
                            try {
                                double radiusOfCircle = scanner.nextInt();
                                if (radiusOfCircle < 0) {
                                    throw new Exception("Radius cannot be less than 0");
                                }
                                Circle circle = new Circle();
                                System.out.println("Area of the Circle is " + circle.area(radiusOfCircle));
                                System.out.println("Area of the Circle is " + circle.circumference(radiusOfCircle));
                            } catch (InputMismatchException inputMismatchException) {
                                System.out.println("Invalid Input. Please enter numbers between 0-9");

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 2:
                            try {
                                System.out.println("Enter the length of the Rectangle");
                                double length = scanner.nextInt();
                                if (length < 0) {
                                    throw new Exception("Length cannot be less than 0");
                                }

                                System.out.println("Enter the breadth of the Rectangle");
                                double breadth = scanner.nextInt();
                                if (breadth < 0) {
                                    throw new Exception("Breadth cannot be less than 0");
                                }

                                Rectangle rectangle = new Rectangle();
                                System.out.println("Area of Rectangle is " + rectangle.area(length, breadth));
                                System.out.println("Perimeter fo Rectangle is " + rectangle.perimeter(length, breadth));
                            } catch (InputMismatchException inputMismatchException) {
                                System.out.println("Invalid Input. Please enter numbers between 0-9");
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 3:
                            try {
                                System.out.println("Enter the Length of the Square");
                                double lengthOfSquare = scanner.nextInt();
                                if (lengthOfSquare < 0) {
                                    throw new Exception("Length cannot be less than 0");
                                }
                                Square square = new Square();
                                System.out.println("Area of Square is " + square.area(lengthOfSquare));
                                System.out.println("Perimeter of Square is " + square.perimeter(lengthOfSquare));
                            } catch (InputMismatchException inputMismatchException) {
                                System.out.println("Invalid Input. Please enter numbers between 0-9");
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 4:
                            try {
                                System.out.println("Enter the height of the Triangle");
                                double height = scanner.nextInt();
                                if (height < 0) {
                                    throw new Exception("Height cannot be less than 0");
                                }

                                System.out.println("Enter the Base of the Triangle");
                                double base = scanner.nextInt();

                                if (base < 0) {
                                    throw new Exception("Base cannot be less than 0");
                                }

                                System.out.println("Enter the side of the Triangle");
                                double side = scanner.nextInt();
                                if (side < 0) {
                                    throw new Exception("Side cannot be less than 0");
                                }

                                Triangle triangle = new Triangle();
                                System.out.println("Area of Triangle is " + triangle.area(height, base));
                                System.out.println("Perimeter of Triangle is " + triangle.perimeter(height, base, side));
                            } catch (InputMismatchException inputMismatchException) {
                                System.out.println("Invalid Input. Please enter numbers between 0-9");
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 5:
                            System.out.println("Enter the Radius of the Sphere");
                            try {
                                double radiusOfSphere = scanner.nextInt();
                                Sphere sphere = new Sphere();

                                if (radiusOfSphere < 0) {
                                    throw new Exception("Radius Cannot be a Negative Number.");
                                }
                                System.out.println("Area of Sphere is " + sphere.area(radiusOfSphere));
                                System.out.println("Perimeter of Square is " + sphere.volume(radiusOfSphere));
                            } catch (InputMismatchException inputMismatchException) {
                                System.out.println("Invalid Input. Please enter numbers between 0-9");
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 6:
                            try {
                                System.out.println("Enter the Radius of the Cylinder");
                                double radiusOfCylinder = scanner.nextInt();

                                if (radiusOfCylinder < 0) {
                                    throw new Exception("Radius cannot be less than 0");
                                }
                                System.out.println("Enter the Height of the Cylinder");
                                double heightOfCylinder = scanner.nextInt();
                                Cylinder cylinder = new Cylinder();

                                if (heightOfCylinder < 0) {
                                    throw new Exception("Height cannot be less than 0");
                                }

                                cylinder.area(radiusOfCylinder, heightOfCylinder);
                                cylinder.volume(radiusOfCylinder, heightOfCylinder);
                            } catch (InputMismatchException inputMismatchException) {
                                System.out.println("Invalid Input. Please enter numbers between 0-9");
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 7:
                            System.out.println("Good Bye!");
                            System.exit(0);

                        default:
                            System.out.println("Invalid Choice");
                    }
            }
        }
        catch (InputMismatchException inputMismatchException){
            System.out.println("Enter number in the given range");
        }
    }
}