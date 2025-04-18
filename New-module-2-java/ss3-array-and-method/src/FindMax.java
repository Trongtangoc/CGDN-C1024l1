import java.util.Scanner;

public class FindMax {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter the size of the array");
            size = sc.nextInt();
            if(size > 20){
                System.out.println("The array contains more than 20 elements");
            }
        } while(size > 0);
        array = new int[size];
        int i = 0;
        while(i < array.length){
            System.out.println("Enter the element" + (i + 1) + " : ");
            array[i] = sc.nextInt();
            i++;
        }
        System.out.println("Property list: ");
        for(int j = 0; j < array.length; j++){
            System.out.println(array[j] + "\t");

        }
        int max = array[0];
        int index = 1;
        for(int j = 1; j < array.length; j++){}
    }
}
