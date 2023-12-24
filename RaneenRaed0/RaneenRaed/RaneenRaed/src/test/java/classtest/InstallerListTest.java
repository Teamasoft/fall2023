package classtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.lists.InstallerList;
import org.example.model.Installer;

import java.util.ArrayList;
import java.util.List;

class InstallerListTest {

    private List<Installer> originalInstallerList;

    @BeforeEach
    void setUp() {
        // Save the original InstallerList before each test
        originalInstallerList = new ArrayList<>(InstallerList.getInstallerList());
    }

    @Test
    void testGetInstallerList() {
        List<Installer> installerList = InstallerList.getInstallerList();
        assertNotNull(installerList);
        assertEquals(originalInstallerList, installerList);
    }

    @Test
    void testSetInstallerList() {
        List<Installer> newInstallerList = new ArrayList<>();
        newInstallerList.add(new Installer("John Doe", "123 Main St", "555-1234", "john_doe", "password", 1, "2023-12-31"));

        InstallerList.setInstallerList(newInstallerList);

        List<Installer> updatedInstallerList = InstallerList.getInstallerList();
        assertNotNull(updatedInstallerList);
        assertEquals(newInstallerList, updatedInstallerList);
    }

    @Test
    void testAddInstaller() {
        Installer newInstaller = new Installer("Alice Smith", "456 Oak St", "555-5678", "alice_smith", "pass123", 2, "2023-12-31");
        InstallerList.addInstaller(newInstaller);

        List<Installer> updatedInstallerList = InstallerList.getInstallerList();
        assertNotNull(updatedInstallerList);
        assertTrue(updatedInstallerList.contains(newInstaller));
    }

    @Test
    void testConstructor() {
        // This is just a constructor with a code smell comment, testing not needed
        // For testing purposes, you might want to consider other constructors or methods
        assertNotNull(new InstallerList());
    }

    // Add more tests as needed based on your requirements

    // ...
}
