package org.example.admainoptions;

import org.example.lists.UsersList;
import org.example.model.Users;

import java.util.List;
import java.util.Scanner;

public class MangeUsers {

    public void showAndEditUserData() {
        Scanner scanner = new Scanner(System.in);

        List<Users> usersList = UsersList.getUsersList();

        // Display all users' data
        System.out.println("Users Data:");
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("| %-20s | %-5s | %-15s | %-15s | %-7s |%n", "Name", "Age", "Majors", "Username", "Password");
        System.out.println("--------------------------------------------------------------------");

        for (Users user : usersList) {
            System.out.printf("| %-20s | %-5d | %-15s | %-15s | %-7s |%n",
                    user.getName(), user.getAge(), user.getMajors(), user.getUserName(), user.getPassWord());
        }

        System.out.println("--------------------------------------------------------------------");

        // Ask if the admin wants to edit user data
        System.out.print("Do you want to edit any user data? (yes/no): ");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("yes")) {
            // Ask for the username to edit
            System.out.print("Enter the username you want to edit: ");
            String username = scanner.nextLine();

            // Find the user with the given username
            Users userToEdit = null;
            for (Users user : usersList) {
                if (user.getUserName().equals(username)) {
                    userToEdit = user;
                    break;
                }
            }

            if (userToEdit != null) {
                // Ask which field to edit
                System.out.println("Choose the field to edit:");
                System.out.println("1. Name");
                System.out.println("2. Age");
                System.out.println("3. Majors");
                System.out.println("4. Password");
                System.out.print("Enter the field number: ");

                int fieldChoice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                // Edit the chosen field
                switch (fieldChoice) {
                    case 1:
                        System.out.print("Enter the new name: ");
                        String newName = scanner.nextLine().trim();
                        userToEdit.setName(newName);
                        break;
                    case 2:
                        System.out.print("Enter the new age: ");
                        int newAge = scanner.nextInt();
                        userToEdit.setAge(newAge);
                        break;
                    case 3:
                        System.out.print("Enter the new majors: ");
                        String newMajors = scanner.nextLine().trim();
                        userToEdit.setMajors(newMajors);
                        break;
                    case 4:
                        System.out.print("Enter the new password: ");
                        String newPassword = scanner.nextLine().trim();
                        userToEdit.setPassWord(newPassword);
                        break;
                    default:
                        System.out.println("Invalid field number.");
                        break;
                }

                System.out.println("User data updated successfully.");
            } else {
                System.out.println("User not found with the specified username.");
            }
        } else {
            System.out.println("No changes made.");
        }
    }
}
