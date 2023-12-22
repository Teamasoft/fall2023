package classtest;

import org.example.User.UserViewHistory;
import org.example.model.Users;

import org.example.lists.ProudctList;
import org.example.lists.UsersList;
import org.example.model.Proudct;
import org.example.model.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UserViewHistoryTest {

    private final UserViewHistory userViewHistory = new UserViewHistory();
    private final List<Proudct> proudctList = ProudctList.getProudctList();
    private final List<Users> usersList = UsersList.getUsersList();

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        proudctList.clear();
        usersList.clear();

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testShowUserPaidProducts_UserWithPurchasedProducts() {
        Users testUser = new Users("Test User", 25, "Computer Science", "testUser", "testPassword");
        List<Integer> personalList = new ArrayList<>();
        personalList.add(1);
        personalList.add(2);
        testUser.setPersonalList(personalList);

        proudctList.add(new Proudct(1, "Product1", 30.0, "product1.jpg", true));
        proudctList.add(new Proudct(2, "Product2", 40.0, "product2.jpg", true));

        usersList.add(testUser);

        String input = "testUser\n";
        provideInput(input);

        userViewHistory.showUserPaidProducts();

        String expectedOutput = "Products you have purchased:\n" +
                "--------------------------------------------------------------------\n" +
                "| ID   | Name                | Price      | Photo   |\n" +
                "--------------------------------------------------------------------\n" +
                "| 1    | Product1            | 30.0       | product1.jpg |\n" +
                "| 2    | Product2            | 40.0       | product2.jpg |\n" +
                "--------------------------------------------------------------------\n";

        assertNotEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    void testShowUserPaidProducts_UserWithoutPurchasedProducts() {
        Users testUser = new Users("Test User", 25, "Computer Science", "testUser", "testPassword");
        usersList.add(testUser);

        String input = "testUser\n";
        provideInput(input);

        userViewHistory.showUserPaidProducts();

        String expectedOutput = "You haven't purchased any products yet.\n";

        assertNotEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    void testShowUserPaidProducts_UserNotFound() {
        String input = "nonexistentUser\n";
        provideInput(input);

        userViewHistory.showUserPaidProducts();

        String expectedOutput = "User not found. Please check your username.\n";

        assertNotEquals(expectedOutput, outputStreamCaptor.toString());
    }

    // Helper method to provide input for testing
    private void provideInput(String data) {
        InputStream inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
    }
}
