import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers;
        System.out.println("Enter a size of array: ");
        int Size = sc.nextInt();
        numbers = new int[Size]; // Khoi tao Mang So nguyen voi size phan tu
        for (int i = 0; i < Size; i++) {
            System.out.println("Enter value at index " + i);
            numbers[i] = sc.nextInt();
        }

        int minValue = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
            }
        }
        sc.close();
        System.out.println("Min value is " + minValue);
    }
}