import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class StudentArray {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael","Camila","Sienna"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name's student: ");
        String input_name = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < students.length; i++) {
            if (input_name.equals(students[i])) {
                System.out.println("Position of the student " + input_name + " is " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found");
        }

    }

}
