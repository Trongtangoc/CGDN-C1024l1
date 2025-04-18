import thuchanh.Shape.Circle;
import thuchanh.Shape.Shape;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1.Shape");
            System.out.println("2.Circle");
            System.out.println("3.Rectangle");
            System.out.println("4.Square");
            System.out.println("5.Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    testShape();
                    break;
                case 2:
                    //do something
                    break;
                case 3:
                    //do something
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;

            }
        } while (choice != 1);
        sc.close();
    }

    private static void testShape() {
        Shape shape = new Shape();
        System.out.println(shape);
        shape = new Shape("red", false);
        System.out.println(shape);
    }
    private static void testCircle() {
        Circle circle = new Circle();
        System.out.println(circle);
        
    }
}