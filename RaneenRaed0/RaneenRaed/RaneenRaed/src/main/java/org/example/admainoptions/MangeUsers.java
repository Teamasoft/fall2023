package org.example.admainoptions;

import org.example.lists.UsersList;
import org.example.model.Users;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class MangeUsers {
    private static final Logger logger = Logger.getLogger(MangeUsers.class.getName());
    private static final String lama = "--------------------------------------------------------------------";

    public void showAndEditUserData() {
        Scanner scanner = new Scanner(System.in);

        List<Users> usersList = UsersList.getUsersList();

        // Log users' data
        logger.info("Users Data:");
        logger.info(lama);
        logger.info(String.format("| %-20s | %-5s | %-15s | %-15s | %-7s |%n", "Name", "Age", "Majors", "Username", "Password"));
        logger.info(lama);

        for (Users user : usersList) {
            logger.info(String.format("| %-20s | %-5d | %-15s | %-15s | %-7s |%n",
                    user.getName(), user.getAge(), user.getMajors(), user.getUserName(), user.getPassWord()));
        }

        logger.info(lama);

        // Ask if the admin wants to edit user data
        logger.info("Do you want to edit any user data? (yes/no): ");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("yes")) {
            // Ask for the username to edit
            logger.info("Enter the username you want to edit: ");
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
                logger.info("Choose the field to edit:");
                logger.info("1. Name");
                logger.info("2. Age");
                logger.info("3. Majors");
                logger.info("4. Password");
                logger.info("Enter the field number: ");

                int fieldChoice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                // Edit the chosen field
                switch (fieldChoice) {
                    case 1:
                        logger.info("Enter the new name: ");
                        String newName = scanner.nextLine().trim();
                        userToEdit.setName(newName);
                        break;
                    case 2:
                        logger.info("Enter the new age: ");
                        int newAge = scanner.nextInt();
                        userToEdit.setAge(newAge);
                        break;
                    case 3:
                        logger.info("Enter the new majors: ");
                        String newMajors = scanner.nextLine().trim();
                        userToEdit.setMajors(newMajors);
                        break;
                    case 4:
                        logger.info("Enter the new password: ");
                        String newPassword = scanner.nextLine().trim();
                        userToEdit.setPassWord(newPassword);
                        break;
                    default:
                        logger.warning("Invalid field number.");
                        break;
                }

                logger.info("User data updated successfully.");
            } else {
                logger.warning("User not found with the specified username.");
            }
        } else {
            logger.info("No changes made.");
        }
    }
}
