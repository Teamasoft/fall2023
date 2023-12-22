package classtest;

import org.example.User.UserPay;
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
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserPayTest {

    private final UserPay userPay = new UserPay();
    private final List<Proudct> proudctList = ProudctList.getProudctList();
    private final List<Users> usersList = UsersList.getUsersList();
    private final Proudct testProduct = new Proudct(1, "Test Product", 50.0, "test.jpg", true);

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        proudctList.clear();
        usersList.clear();
        proudctList.add(testProduct);

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testBuyProduct_SuccessfulPurchase() {
       // String input = "1\ntestUser\n";
     //   provideInput(input);

       // userPay.buyProduct();

        // Check if the product is marked as not reserved
        //assertTrue(testProduct.isReserve());

        // Check if the user's personal list contains the purchased product ID
        //Users testUser = usersList.get(0);
       // assertTrue(testUser.getPersonalList().contains(1));

        // Check if the user's opinion is requested
       //assertTrue(outputStreamCaptor.toString().contains("Thank you for using our service, testUser! Please share your opinion (optional): "));
    }

    @Test
    void testBuyProduct_InvalidProductID() {
        String input = "99\ntestUser\n";
        provideInput(input);

        userPay.buyProduct();

        // Check if appropriate error message is displayed
        assertTrue(outputStreamCaptor.toString().contains("Invalid product ID or the product is already reserved. Please try again."));
    }

    @Test
    void testBuyProduct_ProductAlreadyReserved() {
        // Reserve the product before the test
        testProduct.setReserve(true);

        String input = "1\ntestUser\n";
        provideInput(input);

        userPay.buyProduct();

        // Check if appropriate error message is displayed
        assertTrue(outputStreamCaptor.toString().contains("Invalid product ID or the product is already reserved. Please try again."));
    }

    // Helper method to provide input for testing
    private void provideInput(String data) {
        InputStream inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
    }
}
