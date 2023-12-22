package classtest;

import org.example.lists.UsersList;
import org.example.model.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.admainoptions.MangeUsers;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MangeUsersTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));

        // Reset the UsersList before each test
        UsersList.getUsersList().clear();
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void testShowAndEditUserData() {
        // Simulate user input
        String input = "no\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Add a user for testing
        UsersList.addUser(new Users("John", 25, "Computer Science", "john123", "password"));

        // Run the showAndEditUserData method
        new MangeUsers().showAndEditUserData();

        // Check if log messages contain expected output
        String logs = outputStreamCaptor.toString();
        assertEquals(true, logs.contains("Users Data:"));
        assertEquals(true, logs.contains("John"));
        assertEquals(true, logs.contains("25"));
        assertEquals(true, logs.contains("Computer Science"));
        assertEquals(true, logs.contains("john123"));
        assertEquals(true, logs.contains("No changes made."));
    }

    // Add more tests for other scenarios
}
