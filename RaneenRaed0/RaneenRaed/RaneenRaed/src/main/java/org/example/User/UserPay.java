package org.example.User;

import org.example.lists.ProudctList;
import org.example.lists.UsersList;
import org.example.model.Proudct;
import org.example.model.Users;

import java.util.List;
import java.util.Scanner;

public class UserPay {

    public void buyProduct() {
        displayAvailableProducts();

        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter product ID
        System.out.print("Enter the ID of the product you want to buy: ");
        int productId = scanner.nextInt();

        // Ask the user to enter username
        System.out.print("Enter your username: ");
        String username = scanner.next();

        // Perform the buy operation based on the entered product ID and username
        performBuy(productId, username);
    }

    private void displayAvailableProducts() {
        List<Proudct> proudctList = ProudctList.getProudctList();

        System.out.println("--------------------------------------------------------------------");
        System.out.printf("| %-4s | %-20s | %-10s | %-7s |%n", "ID", "Name", "Price", "Photo");
        System.out.println("--------------------------------------------------------------------");

        for (Proudct product : proudctList) {
            if (product.isReserve()) {
                System.out.printf("| %-4d | %-20s | %-10s | %-7s |%n",
                        product.getProudctId(), product.getName(), product.getPrice(), product.getPhoto());
            }
        }

        System.out.println("--------------------------------------------------------------------");
    }

    private void performBuy(int productId, String username) {
        List<Proudct> proudctList = ProudctList.getProudctList();
        List<Users> usersList = UsersList.getUsersList();

        for (Proudct product : proudctList) {
            if (product.getProudctId() == productId && product.isReserve()) {
                // Product is available and not reserved, perform buy operation
                product.setReserve(false);

                // Add the product ID to the user's personal list
                for (Users user : usersList) {
                    if (user.getUserName().equals(username)) {
                        user.addToPersonalList(productId);
                        break;
                    }
                }

                // Ask for the user's opinion on the service
                askForOpinion(username);

                System.out.println("Congratulations, " + username + "! You have successfully bought " + product.getName());
                return;
            }
        }

        System.out.println("Invalid product ID or the product is already reserved. Please try again.");
    }

    private void askForOpinion(String username) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Thank you for using our service, " + username + "! Please share your opinion (optional): ");
        String opinion = scanner.nextLine();

        // Update the user's personal list with their opinion
        List<Users> usersList = UsersList.getUsersList();
        for (Users user : usersList) {
            if (user.getUserName().equals(username)) {
                user.setOpinion(opinion);
                break;
            }
        }
    }
}
