package classtest;
//all
import org.example.lists.InstallerList;
import org.example.model.Installer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InstallerTest {

    private Installer testInstaller;

    // Used to capture console output
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        // Initialize a test installer before each test
        testInstaller = new Installer("John Doe", "123 Main St", "555-1234", "john.doe", "password123", 1, "monthly");
        InstallerList.getInstallerList().clear(); // Clear the installer list before each test
        InstallerList.getInstallerList().add(testInstaller); // Add the test installer to the list
    }

    @Test
    void testConstructor() {
        assertEquals("John Doe", testInstaller.getName());
        assertEquals("123 Main St", testInstaller.getAddress());
        assertEquals("555-1234", testInstaller.getPhoneNumber());
        assertEquals("john.doe", testInstaller.getUserName());
        assertEquals("password123", testInstaller.getPassWord());
        assertEquals(1, testInstaller.getHouseID());
        assertEquals("monthly", testInstaller.getTimeTOPay());
    }

    @Test
    void testEquals() {
        Installer sameInstaller = new Installer("John Doe", "123 Main St", "555-1234", "john.doe", "password123", 1, "monthly");
        assertTrue(testInstaller.equals(sameInstaller));
    }

    @Test
    void testCheckOwners() {
        // Redirect System.in to provide simulated user input
        ByteArrayInputStream in = new ByteArrayInputStream("john.doe\npassword123\n".getBytes());
        System.setIn(in);

        // Redirect System.out to capture console output
        System.setOut(new PrintStream(outContent));
        testInstaller.checkOwners();
        String consoleOutput = outContent.toString().trim();

        // Add assertions for the expected output based on your implementation
        assertFalse(consoleOutput.contains("Please enter your userName:"));
        assertFalse(consoleOutput.contains("Please enter your password:"));
        assertFalse(consoleOutput.contains("Success! Opening owner page."));

        // Reset System.in and System.out
        System.setIn(System.in);
        System.setOut(originalOut);
    }

    @Test
    void testGettersAndSetters() {
        // Test getters and setters
        testInstaller.setHouseID(2);
        assertEquals(2, testInstaller.getHouseID());

        testInstaller.setTimeTOPay("yearly");
        assertEquals("yearly", testInstaller.getTimeTOPay());

        testInstaller.setName("Jane Doe");
        assertEquals("Jane Doe", testInstaller.getName());

        testInstaller.setAddress("456 Oak St");
        assertEquals("456 Oak St", testInstaller.getAddress());

        testInstaller.setPhoneNumber("555-5678");
        assertEquals("555-5678", testInstaller.getPhoneNumber());

        testInstaller.setUserName("jane.doe");
        assertEquals("jane.doe", testInstaller.getUserName());

        testInstaller.setPassWord("newPassword");
        assertEquals("newPassword", testInstaller.getPassWord());
    }
}
