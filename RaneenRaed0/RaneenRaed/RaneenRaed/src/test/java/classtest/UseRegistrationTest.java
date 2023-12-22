package classtest;

import org.example.User.UseRegistration;
import org.example.model.Users;

import org.example.lists.UsersList;
import org.example.model.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UseRegistrationTest {

    private final UseRegistration useRegistration = new UseRegistration();
    private final List<Users> usersList = UsersList.getUsersList();

    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        // Manually clear the user list
        usersList.clear();
        // Suppress logger output during testing
        Logger.getLogger("").setLevel(Level.OFF);
    }

    @Test
    void testSignUpUser_SuccessfulRegistration() {
        String input = "John Doe\n30\nComputer Science\njohnDoe\npassword123\n1\n";
        provideInput(input);

        useRegistration.signUpUser();

        assertEquals(1, usersList.size());
        Users user = usersList.get(0);
        assertEquals("John Doe", user.getName());
        assertEquals(30, user.getAge());
        assertEquals("Computer Science", user.getMajors());
        assertEquals("johnDoe", user.getUserName());
        assertEquals("password123", user.getPassWord());
        assertNotEquals(1, user.getPersonalList().size());
    }

    @Test
    void testSignUpUser_InvalidInput() {
        // Simulate providing a non-numeric age
       // String input = "Jane Doe\ninvalidAge\nMath\njaneDoe\npassword456\n2\n";
      //  provideInput(input);

       // useRegistration.signUpUser();

        // No user should be added due to invalid input
    //    assertEquals(0, usersList.size());
    }

    // Helper method to provide input for testing
    private void provideInput(String data) {
        InputStream inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
    }
}
