package org.example.User;

import org.example.lists.UsersList;
import org.example.model.Users;

import java.util.Scanner;
import java.util.logging.Logger;

public class UseRegistration {
    private static final Logger logger = Logger.getLogger(Users.class.getName());

    public void signUpUser() {
        Scanner scanner = new Scanner(System.in);

        logger.info("Enter your name:");
        String name = scanner.nextLine();

        logger.info("Enter your age:");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        logger.info("Enter your major:");
        String majors = scanner.nextLine();

        logger.info("Enter your username:");
        String username = scanner.nextLine();

        logger.info("Enter your password:");
        String password = scanner.nextLine();

        logger.info("Enter your proudctId:");
        int proudctId = scanner.nextInt();

        UsersList.addUser(new Users(name, age, majors, username, password));

        logger.info("User signed up successfully!");
    }

}
