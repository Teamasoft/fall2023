package org.example.lists;

import org.example.model.Users;

import java.util.ArrayList;
import java.util.List;

public class UsersList {

    private static List<Users> usersList = new ArrayList<>();

    public static List<Users> getUsersList() {
        return usersList;
    }

    public static void setUsersList(List<Users> usersList) {
        UsersList.usersList = usersList;
    }

    public  static  void addUser(Users user){
        usersList.add(user);

    }
    private UsersList(){
        //for code smell
    }
}







