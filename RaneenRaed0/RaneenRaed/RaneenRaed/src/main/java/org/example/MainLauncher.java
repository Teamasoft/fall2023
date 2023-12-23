package org.example;


import org.example.User.UseRegistration;
import org.example.User.UserEdit;
import org.example.User.UserPay;
import org.example.User.UserViewHistory;
import org.example.admainoptions.MangeUsers;
import org.example.admainoptions.ProductManagement;
import org.example.lists.ProudctList;
import org.example.lists.UsersList;
import org.example.model.Proudct;
import org.example.model.Users;

import java.util.Scanner;

public class MainLauncher {


    public void mainLauncher() {

        ProductManagement productManagement = new ProductManagement();//w
        UseRegistration useRegistration = new UseRegistration();
        Users users = new Users();
        UserPay userPay = new UserPay();
        UserViewHistory userViewHistory = new UserViewHistory() ;
        UserEdit userEdit =new UserEdit();
        MangeUsers mangeUsers = new MangeUsers() ;



        ProudctList.addProudct(new Proudct("bedroom",1,false,"1200$","https://www.bedbathandbeyond.com/Home-Garden/Bedroom-Furniture/710/cat.html"));
        ProudctList.addProudct(new Proudct("Kitchen",2,false,"1000$","https://www.bedbathandbeyond.com/Home-Garden/Kitchen-Furniture/1311/cat.html"));
        ProudctList.addProudct(new Proudct("chair",3,true,"100$","https://www.bedbathandbeyond.com/Home-Garden/Living-Room-Furniture/713/cat.html"));

        UsersList.addUser(new Users("Alice Johnson", 28, "Mathematics", "alice.johnson", "alice123"));
        UsersList.addUser(new Users("Bob Williams", 35, "Physics", "bob.williams", "bob456"));
        UsersList.addUser(new Users("Eva Davis", 22, "Chemistry", "eva.davis", "eva789"));
        UsersList.addUser(new Users("Charlie Brown", 31, "Biology", "charlie.brown", "charlie987"));
        UsersList.addUser(new Users("Grace Miller", 26, "Computer Science", "grace.miller", "grace234"));
        UsersList.addUser(new Users("Omar Raddad", 26, "Computer Science", "omarraddad", "123"));

// Add more users as needed



        Scanner scanner = new Scanner(System.in);

        Mnue mnue = new Mnue();
        boolean r = true;

        while (r) {
            mnue.homePage();
            int a = scanner.nextInt();

            if (a == 1) {

                mnue.singinPage();
                a = mnue.scanner();
                scanner.nextLine();

                if (a == 1) {

                    boolean t = true;
                    while (t) {
                        t = true;
                        mnue.adminCheck();
                        mnue.adminPage();//هون بنكو فاتحين الادمن بيج
                        int o = mnue.scanner();
                        if (o == 1) {  //hereهون الخيار الاو ل==
                            productManagement.manageProducts();

                        }
                        if (o == 2) {//هون الخيار التاني

                        }
                        if (o == 3) {
mangeUsers.showAndEditUserData();


                        }
                        if (o == 4) {

                            t = false;
                            r = true;
                        }
                    }
                }
                if (a == 2) {

                    boolean b = true;
                    while (b) {

                        users.checkinguser();
                        mnue.tenantesPage();
                        int o = mnue.scanner();

                        if (o == 1) {

                            //pay
userPay.buyProduct();

                            b = true;
                            r = false;
                        }

                        if (o == 2) {
userViewHistory.showUserPaidProducts();
                            b = true;
                            r = false;
                        }
                        if (o == 3) {

                            userEdit.editUserData();
                            b = true;
                            r = false;
                        }
                        if (o == 5) {

                            b = true;
                            r = false;
                        }
                        if (o == 6) {

                            b = true;
                            r = false;
                        }
                        if (o == 7) {

                            b = true;
                            r = false;
                        }

                        if (o == 8) {

                            b = false;
                            r = true;

                        }
                    }
                }

                else      if (a == 3) {


                    boolean n = true;

                    while (n) {
                        n=true;
                        mnue.ownerPage();
                        int o = mnue.scanner();
                        if (o == 1) {

                            n = true;
                            r = false;
                        }
                        if (o == 2) {

                            n = true;
                            r = false;
                        }
                        else if (o== 3) {
                            r=true;
                            n=false;



                        }
                    }
                }
            }

            else    if (a == 2) {

                useRegistration.signUpUser();

            }
            else {
                System.exit(0);
            }

        }
    }

}