package org.example.User;

import org.example.lists.UsersList;
import org.example.lists.ProudctList;
import org.example.model.Users;
import org.example.model.Proudct;

import java.util.Scanner;
import java.util.logging.*;

public class UserManager {

    private static final Logger logger = Logger.getLogger(UserManager.class.getName());

    static {

        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        for (Handler handler : handlers) {
            handler.setFormatter(new SimpleFormatter() {
                @Override
                public String format(LogRecord logRecord) {
                    return logRecord.getMessage() + "\n"; // Suppress date and level
                }
            });
        }
    }


    private static Scanner scanner = new Scanner(System.in);

    public void ownershow() {
        // Data is already existing in the OwnerList and HouseList

        // Ask the user to enter their username and password
        logger.info("Enter your username: ");
        String username = scanner.nextLine();

        logger.info("Enter your password: ");
        String password = scanner.nextLine();

        // Check if the user exists in the owners list
      //  Users user = getUserByUsernameAndPassword(username, password);
      //  if (user != null) {
            // Display houses owned by the user
        //    displayHousesOwnedBy(user);
      //  } else {
       ////     logger.info("Invalid username or password. Access denied.");
        }
    //}

    public static Users getUserByUsernameAndPassword(String username, String password) {
        for (Users user : UsersList.getUsersList()) {
            if (user.getUserName().equals(username) && user.getPassWord().equals(password)) {
                return user;
            }
        }
        return null;
    }}


