import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter the size of the array: ");
            size = sc.nextInt();
            if (size > 20) {
                System.out.println("Size does not exceed 20");
            }
        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter the " + (i + 1) + " element: ");
            array[i] = sc.nextInt();
            i++;
        }
        System.out.printf("%-20s", "Element in array: ");
        for(int j = 0; j < array.length; j++) {
            System.out.printf("%-4d", array[j]);
        }
        for (int j = 0; j < array.length/2; j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }
        System.out.printf("\n%-20s","Reverse array");
        for(int j = 0; j < array.length; j++) {
            System.out.printf("%-4d", array[j]);
        }
    }



}