package classtest;

import org.example.User.UserEdit;
import org.example.model.Users;

import org.example.lists.UsersList;
import org.example.model.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserEditTest {

    private final UserEdit userEdit = new UserEdit();
    private final List<Users> usersList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        UsersList.setUsersList(usersList);
    }

    @Test
    void testEditUserData_UserFound() {
        Users user = new Users("John Doe", 30, "History", "johnDoe", "password123");
        usersList.add(user);

        String input = "johnDoe\nNew Name\n40\nNew Majors\nNew Password\n";
        provideInput(input);

        userEdit.editUserData();

        assertEquals("New Name", user.getName());
        assertEquals(40, user.getAge());
        assertEquals("New Majors", user.getMajors());
        assertEquals("New Password", user.getPassWord());
    }

    @Test
    void testEditUserData_UserNotFound() {
        String input = "nonexistentUser\n";
        provideInput(input);

        userEdit.editUserData();

        // Check if any changes occurred (should not)
        assertEquals(0, usersList.size());
    }

    // Helper method to provide input for testing
    private void provideInput(String data) {
        InputStream inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
    }
}
