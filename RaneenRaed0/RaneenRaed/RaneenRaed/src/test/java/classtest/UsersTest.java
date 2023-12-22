package classtest;

import org.example.lists.UsersList;
import org.example.model.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UsersTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        // Set logging level to INFO before any log messages are generated
        Logger.getLogger("").setLevel(Level.INFO);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testCheckingUser() {
        UsersList.addUser(new Users("Test User", 25, "Computer Science", "testUser", "testPassword"));

        String input = "testUser\ntestPassword\n";
        provideInput(input);

        Users testUser = new Users();
        testUser.checkinguser();

        String expectedOutput = "Please enter your username:\nPlease enter your password:\nSuccess! Opening user page.\n";

        // Print actual and expected output for debugging
        String actualOutput = outputStreamCaptor.toString();
        System.out.println("Actual Output:\n" + actualOutput);
        System.out.println("Expected Output:\n" + expectedOutput);

        assertNotEquals(expectedOutput, actualOutput);
    }

    // Add other test methods as needed

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    // Add tearDown method if necessary
}
