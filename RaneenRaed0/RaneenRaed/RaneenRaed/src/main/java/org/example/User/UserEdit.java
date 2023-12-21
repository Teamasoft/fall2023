package org.example.User;

import org.example.lists.UsersList;
import org.example.model.Users;

import java.util.List;
import java.util.Scanner;

public class UserEdit {

    public void editUserData() {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter their username
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        List<Users> usersList = UsersList.getUsersList();

        for (Users user : usersList) {
            if (user.getUserName().equals(username)) {
                // Display current user data
                System.out.println("Current User Data:");
                System.out.println("Name: " + user.getName());
                System.out.println("Age: " + user.getAge());
                System.out.println("Majors: " + user.getMajors());
                System.out.println("Password: " + user.getPassWord());

                // Ask the user for new data
                System.out.println("Enter new data (press Enter to keep current value):");
                System.out.print("New Name: ");
                String newName = scanner.nextLine().trim();
                if (!newName.isEmpty()) {
                    user.setName(newName);
                }

                System.out.print("New Age: ");
                String newAgeStr = scanner.nextLine().trim();
                if (!newAgeStr.isEmpty()) {
                    try {
                        int newAge = Integer.parseInt(newAgeStr);
                        user.setAge(newAge);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age format. Keeping current age.");
                    }
                }

                System.out.print("New Majors: ");
                String newMajors = scanner.nextLine().trim();
                if (!newMajors.isEmpty()) {
                    user.setMajors(newMajors);
                }

                System.out.print("New Password: ");
                String newPassword = scanner.nextLine().trim();
                if (!newPassword.isEmpty()) {
                    user.setPassWord(newPassword);
                }

                System.out.println("User data updated successfully.");
                return;
            }
        }

        System.out.println("User not found. Please check your username.");
    }
}
