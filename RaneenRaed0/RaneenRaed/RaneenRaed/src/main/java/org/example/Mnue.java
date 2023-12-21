package org.example;

import java.util.Scanner;
import java.util.logging.*;

public class Mnue {
    private static String enterChoice  = "Enter your choice: ";
    private static final Logger logger = Logger.getLogger(Mnue.class.getName());
    private Scanner scanner = new Scanner(System.in);

    static {
        // Set up custom log formatter to remove date and level from log messages
        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        for (Handler handler : handlers) {
            handler.setFormatter(new SimpleFormatter() {
                @Override
                public String format(LogRecord logrecord) {
                    return logrecord.getMessage() + "\n"; // Suppress date and level
                }
            });
        }
    }

    public void homePage() {
        logger.info("------ Welcome to Home Page ------");
        logger.info("|                                 |");
        logger.info("|          1. Sign in             |");
        logger.info("|          2. Sign up             |");
        logger.info("|          3. Exit                |");
        logger.info("|                                 |");
        logger.info("----------------------------------");
        logger.info(enterChoice);
    }

    public void singinPage() {
        logger.info("------ Welcome to Home Page ------");
        logger.info("|                                |");
        logger.info("|          1. admin             |");
        logger.info("|          2. user            |");
        logger.info("|          3. Installter            |");
        logger.info("|                                |");
        logger.info("----------------------------------");
        logger.info(enterChoice);
    }

    public void adminPage() {
        logger.info("----------------- Welcome to Admin Page -----------------------------");
        logger.info("|                ----------------------                     |");
        logger.info("|   1. Manage product categories (add, edit, delete).       |");
        logger.info("|   2. Add and update product listings.                     |");
        logger.info("|   3. View and manage customer accounts.                   |");
        logger.info("|   4. Schedule and manage installation appointments.       |");
        logger.info("|   5. logout                                               |");
        logger.info("|                                                           |");
        logger.info("-------------------------------------------------------------");
        logger.info(enterChoice);
    }

    public void tenantesPage() {
        logger.info("---------------------------- Welcome to user Page ---------------------------");
        logger.info("|                                                                             |");
        logger.info("|   1.  Browse Proudcts                                                       |");
        logger.info("|   2.  View order history                                                     |");
        logger.info("|   3.  edit profile                                                          |");
        logger.info("|   4.   installation request                                                 |");
        logger.info("|   5.  logout                                                                |");
        logger.info("|                                                                             |");
        logger.info("-------------------------------------------------------------------------------");
        logger.info(enterChoice);
    }

    public void ownerPage() {
        logger.info("--------- Welcome to installer Page ------------------");
        logger.info("|                                                  |");
        logger.info("|   1. View Installation                |");
        logger.info("|   2. Request and schedule appointment               |");
        logger.info("|   3. logout                                      |");
        logger.info("|                                                  |");
        logger.info("----------------------------------------------------");
        logger.info(enterChoice);

    }

    public int scanner() {
        int c;
        while (true) {
            try {
                c = scanner.nextInt();
                break; // Exit the loop if integer input is successfully read
            } catch (java.util.NoSuchElementException e) {
                logger.log(Level.SEVERE, "Invalid input. Please enter a valid integer.", e);
            }
        }
        scanner.nextLine(); // Clear the input buffer
        return c;
    }

    public void adminCheck() {
        logger.info("Enter your username: ");
        String username = scanner.nextLine();

        logger.info("Enter your password: ");
        String password = scanner.nextLine();




        if (username.equals("omar") && password.equals("12341234")) {
            logger.info("Login successful. Welcome, omar !");
        } else {
            logger.warning("Login failed. Please try again.");
            adminCheck();
        }
    }



}