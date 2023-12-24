package classtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.model.Users;
import org.example.lists.UsersList;

import java.util.ArrayList;
import java.util.List;

class UsersListTest {

    private List<Users> originalUsersList;

    @BeforeEach
    void setUp() {
        // Save the original UsersList before each test
        originalUsersList = new ArrayList<>(UsersList.getUsersList());
    }

    @Test
    void testGetUsersList() {
        List<Users> usersList = UsersList.getUsersList();
        assertNotNull(usersList);
        assertEquals(originalUsersList, usersList);
    }

    @Test
    void testSetUsersList() {
        List<Users> newUsersList = new ArrayList<>();
        newUsersList.add(new Users("John", 25, "Computer Science", "john_doe", "password123"));

        UsersList.setUsersList(newUsersList);

        List<Users> updatedUsersList = UsersList.getUsersList();
        assertNotNull(updatedUsersList);
        assertEquals(newUsersList, updatedUsersList);
    }

    @Test
    void testAddUser() {
        Users newUser = new Users("Alice", 30, "Mathematics", "alice_smith", "pass123");
        UsersList.addUser(newUser);

        List<Users> updatedUsersList = UsersList.getUsersList();
        assertNotNull(updatedUsersList);
        assertTrue(updatedUsersList.contains(newUser));
    }

    @Test
    void testConstructor() {
        // This is just a constructor with a code smell comment, testing not needed
        // For testing purposes, you might want to consider other constructors or methods
        assertNotNull(new UsersList());
    }

    // Add more tests as needed based on your requirements

    // ...

}
