package classtest;

import org.example.User.UserManager;
import org.example.model.Users;

import org.example.lists.UsersList;
import org.example.model.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UserManagerTest {

    private final UserManager userManager = new UserManager();
    private final Users testUser = new Users("Test User", 25, "Computer Science", "testUser", "testPassword");

    @BeforeEach
    void setUp() {
        UsersList.setUsersList(Collections.singletonList(testUser));
    }

    @Test
    void testOwnerShow_SuccessfulAuthentication() {
      //  String input = "testUser\ntestPassword\n";
      //  provideInput(input);

//        userManager.ownershow();

        // Add assertions based on the expected behavior after successful authentication
        // For example, check if specific messages are logged or if certain methods are called
    }

    @Test
    void testOwnerShow_FailedAuthentication() {
      //  String input = "invalidUser\ninvalidPassword\n";
      //  provideInput(input);

//        userManager.ownershow();

        // Add assertions based on the expected behavior after failed authentication
        // For example, check if specific error messages are logged or if certain methods are not called
    }

    // Helper method to provide input for testing
    private void provideInput(String data) {
        InputStream inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
    }
}
