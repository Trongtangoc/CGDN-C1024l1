import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n==== Menu Quản Lý Sinh Viên ====");
            System.out.println("1. Thêm mới sinh viên");
            System.out.println("2. Xóa sinh viên");
            System.out.println("3. Xem danh sách sinh viên");
            System.out.println("4. Tìm kiếm sinh viên");
            System.out.println("5. Xem thông tin giáo viên theo mã giáo viên");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    manager.addStudent(scanner);
                    break;
                case "2":
                    manager.deleteStudent(scanner);
                    break;
                case "3":
                    manager.listStudents();
                    break;
                case "4":
                    manager.searchStudents(scanner);
                    break;
                case "5":
                    manager.viewTeacher(scanner);
                    break;
                case "6":
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}
