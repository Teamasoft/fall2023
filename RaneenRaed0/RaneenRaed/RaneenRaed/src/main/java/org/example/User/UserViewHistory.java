package org.example.User;

import org.example.lists.ProudctList;
import org.example.lists.UsersList;
import org.example.model.Proudct;
import org.example.model.Users;

import java.util.List;
import java.util.Scanner;

public class UserViewHistory {

    public void showUserPaidProducts() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        List<Users> usersList = UsersList.getUsersList();
        List<Proudct> proudctList = ProudctList.getProudctList();

        for (Users user : usersList) {
            if (user.getUserName().equals(username)) {
                List<Integer> personalList = user.getPersonalList();

                if (personalList.isEmpty()) {
                    System.out.println("You haven't purchased any products yet.");
                } else {
                    System.out.println("Products you have purchased:");
                    System.out.println("--------------------------------------------------------------------");
                    System.out.printf("| %-4s | %-20s | %-10s | %-7s |%n", "ID", "Name", "Price", "Photo");
                    System.out.println("--------------------------------------------------------------------");

                    for (Integer productId : personalList) {
                        for (Proudct product : proudctList) {
                            if (product.getProudctId() == productId) {
                                System.out.printf("| %-4d | %-20s | %-10s | %-7s |%n",
                                        product.getProudctId(), product.getName(), product.getPrice(), product.getPhoto());
                                break;
                            }
                        }
                    }

                    System.out.println("--------------------------------------------------------------------");
                }

                return;
            }
        }

        System.out.println("User not found. Please check your username.");
    }
}
