import java.util.Scanner;

public class StudentArray {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student name: ");
        String studentName = scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < students.length; i++) {
            //equalsIgnoreCase  khong phan biet viet hoa va viet thuong
            if (students[i].equalsIgnoreCase(studentName)){
                System.out.println("Position of student " + studentName + " is " + i);
                flag = true;
                break;
            }
        }
        if (flag == false){
            System.out.println("Student not found");
        }
    }
}
