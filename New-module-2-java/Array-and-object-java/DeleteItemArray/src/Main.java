import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] numbers = {10,4,6,7,8,6,0,0,0,0,0};
        System.out.println("Nhap phan tu can xoa");
        Scanner sc = new Scanner(System.in);
        int valueRemove = sc.nextInt();
        int index_del = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == valueRemove) {
                index_del = i;
            }
        }
        for (int i = index_del; i < numbers.length-1; i++) {
            numbers[i] = numbers[i+1];
            }
        numbers[numbers.length-1] = 0;
        for(int i = 0; i < numbers.length-1; i++) {
            System.out.print(numbers[i]+" ");
        }
    }
}