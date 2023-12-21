package org.example.model;

import org.example.lists.UsersList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Users {

    private static final Logger logger = Logger.getLogger(Users.class.getName());

    private String name;
    private int age;
    private String majors;
    private String userName;
    private String password;
    private List<Integer> personalList; // List to store purchased product IDs
    private String opinion; // User's opinion on the service

    public Users(String name, int age, String majors, String username, String passWord) {
        this.name = name;
        this.age = age;
        this.majors = majors;
        this.userName = username;
        this.password = passWord;
        this.personalList = new ArrayList<>();
        this.opinion = "";
    }

    public Users() {}

    public void checking() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Please enter your userName:");
        String username = scanner.nextLine();
        logger.info("Please enter your Password:");
        String password = scanner.nextLine();

        boolean userFound = false;
        for (Users t : UsersList.getUsersList()) {
            if (t.getUserName().equals(username) && t.getPassWord().equals(password)) {
                logger.info("Success! Opening user page.");
                userFound = true;
                break;
            } else if (t.getUserName().equals(username)) {
                logger.info("Fail! Incorrect password, please try again.");
                userFound = true;
                checking();
                break;
            }
        }

        if (!userFound) {
            logger.info("User not found, please try again.");
            checking();
        }
    }

    public void showTable() {
        logger.info("name\t\tmajor\t\tusername\t\tpassword\t\thouseid");
        for (Users t : UsersList.getUsersList()) {
            logger.info(
                    t.getName() + "\t \t" +
                            t.getMajors() + "\t\t " +
                            t.getUserName() + " \t\t" +
                            t.getPassWord() + " \t\t"

            );
        }
    }

    public void checkinguser() {
        Scanner scanner = new Scanner(System.in);
        boolean userFound = false;

        do {
            logger.info("Please enter your username:");
            String username = scanner.nextLine();

            logger.info("Please enter your password:");
            String password = scanner.nextLine();

            for (Users user : UsersList.getUsersList()) {
                if (user.getUserName().equals(username) && user.getPassWord().equals(password)) {
                    logger.info("Success! Opening user page.");
                    userFound = true;
                    break;
                } else if (user.getUserName().equals(username)) {
                    logger.info("Fail! Incorrect password, please try again.");
                    break;
                }
            }

            if (!userFound) {
                logger.info("User not found or incorrect credentials, please try again.");
            }
        } while (!userFound);
    }

    public String getPassWord() {
        return password;
    }

    public void setPassWord(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getPassWord(String PassWord) {
        return PassWord;
    }


    public void addToPersonalList(int productId) {
        personalList.add(productId);
    }

    public List<Integer> getPersonalList() {
        return personalList;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getOpinion() {
        return opinion;
    }
}
