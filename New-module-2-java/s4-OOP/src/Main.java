import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager(15);
        userManager.addUser(new User(0,"trong","trong@gmail.com",20));

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add User");
            System.out.println("2. Show User List");
            System.out.println("3. Remove User");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Xử lý dòng thừa sau khi nhập số

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Xử lý dòng thừa

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Xử lý dòng thừa

                    userManager.addUser(new User(id, name, email, age));
                    System.out.println("User added successfully!");
                    break;

                case 2:
//                    System.out.println("User List:");
                    userManager.showListUser();
                    break;

                case 3:
                    System.out.print("Enter ID to remove: ");
                    int removeId = scanner.nextInt();
                    userManager.removeUser(removeId);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }}}}