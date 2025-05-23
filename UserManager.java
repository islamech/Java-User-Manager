package UserManager;

import java.util.ArrayList;
import java.util.Scanner;

class User {
    private static int count = 1;
    private int id;
    private String name;	
    private String email;

    public User(String name, String email) {
        this.id = count++;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return id + ". " + name + " - " + email;
    }
}

public class UserManager {
    private static ArrayList<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addUser();
                case 2 -> listUsers();
                case 3 -> deleteUser();
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("\n===== User Manager =====");
        System.out.println("1. Add User");
        System.out.println("2. Show Users");
        System.out.println("3. Delete User");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addUser() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        users.add(new User(name, email));
        System.out.println("User added successfully!");
    }

    private static void listUsers() {
        System.out.println("\nRegistered Users:");
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    private static void deleteUser() {
        listUsers();
        if (users.isEmpty()) return;

        System.out.print("Enter user ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        boolean removed = users.removeIf(user -> user.getId() == id);
        if (removed) {
            System.out.println("User deleted.");
        } else {
            System.out.println("User not found.");
        }
    }
}
