package org.example.admainoptions;

import org.example.lists.ProudctList;
import org.example.model.Proudct;

import java.util.List;
import java.util.Scanner;
import java.util.logging.*;

public class ProductManagement {

    public ProductManagement() {}

    private static final Logger logger = Logger.getLogger(ProductManagement.class.getName());
//w
    static {
        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        for (Handler handler : handlers) {
            handler.setFormatter(new SimpleFormatter() {
                @Override
                public String format(LogRecord logRecord) {
                    return logRecord.getMessage() + "\n";
                }
            });
        }
    }

    public static void manageProducts() {


        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            logger.info("Choose an option:");
            logger.info("1. Add a product");
            logger.info("2. Modify a product");
            logger.info("3. Delete a product");
            logger.info("4. Show product table");
            logger.info("0. Exit");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    modifyProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    showProductTable(ProudctList.getProudctList());
                    break;
                case 0:
                    logger.info("Exiting product management.");
                    break;
                default:
                    logger.info("Invalid option. Please choose a valid option.");
                    break;
            }

        } while (choice != 0);
    }

    public static void addProduct() {
        Scanner scanner = new Scanner(System.in);

showProductTable(ProudctList.getProudctList());

        logger.info("Enter the product details:");

        logger.info("Name: ");
        String name = scanner.nextLine();

        logger.info("ID: ");
        int id = scanner.nextInt();

        logger.info("Reserve Status (true/false): ");
        boolean reserve = scanner.nextBoolean();

        logger.info("Price: ");
        String price = scanner.next();

        logger.info("Photo: ");
        String photo = scanner.next();

        Proudct newProduct = new Proudct(name, id, reserve, price, photo);
        ProudctList.getProudctList().add(newProduct);

        logger.info("Product added successfully!");
    }

    public static void modifyProduct() {



        logger.info("Enter the product ID to modify:");
        Scanner scanner = new Scanner(System.in);
        int productId = scanner.nextInt();

        List<Proudct> productList = ProudctList.getProudctList();
        Proudct productToModify = null;

        for (Proudct product : productList) {
            if (product.getProudctId() == productId) {
                productToModify = product;
                break;
            }
        }

        if (productToModify != null) {
            logger.info("Choose what to modify:");
            logger.info("1. Name");
            logger.info("2. Reserve Status");
            logger.info("3. Price");
            logger.info("4. Photo");
            logger.info("0. Cancel");

            int modificationChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (modificationChoice) {
                case 1:
                    logger.info("Enter the new name:");
                    String newName = scanner.nextLine();
                    productToModify.setName(newName);
                    logger.info("Name updated successfully!");
                    break;
                case 2:
                    logger.info("Enter the new reserve status (true/false):");
                    boolean newReserve = scanner.nextBoolean();
                    productToModify.setReserve(newReserve);
                    logger.info("Reserve status updated successfully!");
                    break;
                case 3:
                    logger.info("Enter the new price:");
                    String newPrice = scanner.next();
                    productToModify.setPrice(newPrice);
                    logger.info("Price updated successfully!");
                    break;
                case 4:
                    logger.info("Enter the new photo:");
                    String newPhoto = scanner.next();
                    productToModify.setPhoto(newPhoto);
                    logger.info("Photo updated successfully!");
                    break;
                case 0:
                    logger.info("Modification canceled.");
                    break;
                default:
                    logger.info("Invalid option. Modification canceled.");
                    break;
            }
        } else {
            logger.info("Product not found with the given ID.");
        }
    }

    public static void deleteProduct() {
        List<Proudct> productList = ProudctList.getProudctList();
        showProductTable(productList);

        logger.info("Enter the product ID to delete:");
        Scanner scanner = new Scanner(System.in);
        int productId = scanner.nextInt();

        Proudct productToDelete = null;

        for (Proudct product : productList) {
            if (product.getProudctId() == productId) {
                productToDelete = product;
                break;
            }
        }

        if (productToDelete != null) {
            productList.remove(productToDelete);
            logger.info("Product deleted successfully!");
        } else {
            logger.info("Product not found with the given ID.");
        }
    }

    public static void showProductTable(List<Proudct> productList) {
        logger.info("Product ID\tName\t\tID\t\tReserve\t\tPrice\t\tPhoto");
        for (Proudct product : productList) {
            logger.info(product.getProudctId() + "\t\t" +
                    product.getName() + "\t\t" +
                    product.getProudctId() + "\t\t" +
                    product.isReserve() + "\t\t" +
                    product.getPrice() + "\t\t" +
                    product.getPhoto()
            );
        }
        logger.info("");
    }
}