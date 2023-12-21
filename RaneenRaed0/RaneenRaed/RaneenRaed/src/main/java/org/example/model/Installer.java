package org.example.model;

import org.example.Mnue;
import org.example.lists.InstallerList;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Installer {




        // Instance variables
        private static final Logger logger = Logger.getLogger(Installer.class.getName());
        private Mnue m = new Mnue();

        private String name;
        private String address;
        private String phoneNumber;
        private String userName;
        private String passWord;
        private int houseID;
        String timeTOPay;


        public Installer(String name, String address, String phoneNumber, String userName, String password, int houseID, String timeTOPay) {
            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.userName = userName;
            this.passWord = password;
            this.houseID = houseID;
            this.timeTOPay = timeTOPay;
        }

        public Installer() {
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Installer other = (Installer) obj;
            return userName.equals(other.userName) &&
                    passWord.equals(other.passWord) &&
                    name.equals(other.name) &&
                    houseID == other.houseID;
        }

        public Installer(String johnDoe, String password, String johnDoe1, int i) {//for code smell
        }

        public void checkOwners() {
            Scanner scanner = new Scanner(System.in);
            logger.log(Level.INFO, "Please enter your userName: ");
            String username = scanner.nextLine();
            logger.log(Level.INFO, "Please enter your password: ");
            String password = scanner.nextLine();

            boolean userFound = false;
            for (Installer o : InstallerList.getInstallerList()) {
                if (o.getUserName().equals(username)) {
                    if (o.getPassWord().equals(password)) {
                        logger.log(Level.INFO, "Success! Opening owner page.");
                        userFound = true;
                    } else {
                        logger.log(Level.INFO, "Fail! Incorrect password, please try again.");
                        userFound = true;
                    }
                    break;
                }
            }

            if (!userFound) {
                logger.log(Level.INFO, "User not found, please try again.");
                checkOwners();
            }
        }

        // Getters and setters
        public int getHouseID() {
            return houseID;
        }

        public void setHouseID(int houseID) {
            this.houseID = houseID;
        }

        public String getTimeTOPay() {
            return timeTOPay;
        }

        public void setTimeTOPay(String timeTOPay) {
            this.timeTOPay = timeTOPay;
        }

        public String getName() {
            return name;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassWord() {
            return passWord;
        }

        public void setPassWord(String passWord) {
            this.passWord = passWord;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }


