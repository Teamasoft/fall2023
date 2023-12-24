package org.example.User;

import org.example.lists.ProudctList;
import org.example.lists.UsersList;
import org.example.model.Proudct;
import org.example.model.Users;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserViewHistory {
    private static final Logger logger = Logger.getLogger(UserViewHistory.class.getName());
    private static final String KHALAF = "--------------------------------------------------------------------";

    public void showUserPaidProducts() {
        Scanner scanner = new Scanner(System.in);

        logger.info("Enter your username: ");
        String username = scanner.nextLine();

        List<Users> usersList = UsersList.getUsersList();
        List<Proudct> proudctList = ProudctList.getProudctList();

        for (Users user : usersList) {
            if (user.getUserName().equals(username)) {
                List<Integer> personalList = user.getPersonalList();

                if (personalList.isEmpty()) {
                    logger.info("You haven't purchased any products yet.");
                } else {
                    logger.info("Products you have purchased:");
                    logger.info(KHALAF);
                    logger.info(String.format("| %-4s | %-20s | %-10s | %-7s |%n", "ID", "Name", "Price", "Photo"));
                    logger.info(KHALAF);

                    for (Integer productId : personalList) {
                        for (Proudct product : proudctList) {
                            if (product.getProudctId() == productId) {
                                logger.info(String.format("| %-4d | %-20s | %-10s | %-7s |%n",
                                        product.getProudctId(), product.getName(), product.getPrice(), product.getPhoto()));
                                break;
                            }
                        }
                    }

                    logger.info(KHALAF);
                }

                return;
            }
        }

        logger.warning("User not found. Please check your username.");
    }
}
