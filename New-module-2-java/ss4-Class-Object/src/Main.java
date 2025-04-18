import baitap.Rectangle;
import baitap.StopWatch;
import baitap.Fan;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mainChoice;

        do {
            System.out.println("========== MENU ==========");
            System.out.println("1. Test Stopwatch");
            System.out.println("2. Test Fan");
            System.out.println("3. Test Rectangle");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            mainChoice = sc.nextInt();

            switch (mainChoice) {
                case 1:
                    testStopwatch(sc);
                    break;
                case 2:
                    testFan();
                    break;
                case 3:
                    testRectangle();
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (mainChoice != 0);

        sc.close();
    }

    private static void testStopwatch(Scanner sc) {
        StopWatch sw = new StopWatch();
        int[] arr = new int[100000];
        Random rand = new Random();
        boolean isRunning = false;
        int subChoice;

        // Tạo mảng số ngẫu nhiên
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100000);
        }

        do {
            System.out.println("===== STOPWATCH SUB-MENU =====");
            System.out.println("1. Start Stopwatch");
            System.out.println("2. End Stopwatch");
            System.out.println("3. Measure Selection Sort Time");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            subChoice = sc.nextInt();

            switch (subChoice) {
                case 1:
                    if (!isRunning) {
                        sw.start();
                        isRunning = true;
                        System.out.println("Stopwatch started.");
                    } else {
                        System.out.println("Stopwatch is already running!");
                    }
                    break;
                case 2:
                    if (isRunning) {
                        sw.stop();
                        isRunning = false;
                        System.out.println("Stopwatch stopped.");
                        System.out.println("Elapsed time: " + sw.getElapsedTime() + " milliseconds.");
                    } else {
                        System.out.println("Stopwatch is not running!");
                    }
                    break;
                case 3:
                    System.out.println("Executing Selection Sort...");
                    sw.start();
                    selectionSort(arr);
                    sw.stop();
                    System.out.println("Selection Sort completed.");
                    System.out.println("Elapsed time: " + sw.getElapsedTime() + " milliseconds.");
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (subChoice != 0);
    }

    private static void testFan() {
        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);

        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);

        System.out.println("Fan 1: " + fan1);
        System.out.println("Fan 2: " + fan2);
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void testRectangle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the width of the rectangle: ");
        double width = sc.nextDouble();
        System.out.print("Enter the height of the rectangle: ");
        double height = sc.nextDouble();
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println("Your rectangle is: " + rectangle.display());
        System.out.println("Perimeter of the rectangle is: " + rectangle.getPerimeter());
        System.out.println("Area of the rectangle is: " + rectangle.getArea());

    }
}
