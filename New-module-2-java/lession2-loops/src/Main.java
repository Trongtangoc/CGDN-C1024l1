import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Menu");
        System.out.println("\t1. Print the rectangle");
        System.out.println("\t2. Print the square triangle1");
        System.out.println("\t3. Print the square triangle2");
        System.out.println("\t4. Print 20 number Prime");
        System.out.println("\t5. Exit");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice [1-5]: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                printRectangle();
                break;
            case 2:
                printSquare1();
                break;
            case 3:
                printSquare2();
                break;
            case 4:
                System.out.println("Nhập số lượng số nguyên tố cần in: ");
                int n = sc.nextInt();
                printPrime(n);
                break;
            case 5:
                System.out.println("Exiting...");
                sc.close();
                return;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void printRectangle() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printSquare1() {
        for (int i = 0; i < 7; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printSquare2() {
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printPrime(int n) {

        int count = 0;
        int number = 2;
        while (count < n) {
            if (isPrime(number)) {
                System.out.print(number + " ");
                count++;
            }
            number++;
        }
        System.out.println();
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}