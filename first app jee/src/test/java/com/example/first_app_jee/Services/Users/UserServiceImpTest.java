package com.example.first_app_jee.Services.Users;

import com.example.first_app_jee.Entities.Users;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceImpTest {

    private static UserService userService;

    @BeforeAll
    public static void setUp() {
        userService = new UserServiceImp();
    }

    @AfterAll
    public static void tearDown() {
        // You can perform cleanup if needed, e.g., closing resources.
    }

    @Test
    void testAddUser() {
        Users user = new Users();
        user.setEmail("test@example.com");
        user.setPassword("testpassword");

        Users addedUser = userService.addUser(user);
        assertNotNull(addedUser);
        assertEquals("test@example.com", addedUser.getEmail());

    }

    @Test
    void testGetUser() {
        // Assuming you have a test user with known email and password in the database.
        String email = "test@example.com";
        String password = "testpassword";
        boolean userExists = userService.getUser(email, password);
        assertTrue(userExists);
        // You can add more assertions as needed.
    }

    @Test
    void testGetUserById() {
        // Assuming you have a test user with known ID in the database.
        int userId = 1; // Replace with the actual user ID.
        Users user = userService.getUserById(userId);
        assertNotNull(user);
        assertEquals(userId, user.getId());
        // You can add more assertions as needed.
    }

    @Test
    void testGetUserByEmail() {
        // Assuming you have a test user with a known email in the database.
        String email = "test@example.com";
        Users user = userService.getUserByEmail(email);
        assertNotNull(user);
        assertEquals(email, user.getEmail());
        // You can add more assertions as needed.
    }

    @Test
    void testGetAllUsers() {
        List<Users> users = userService.getAllUsers();
        assertNotNull(users);
        assertTrue(users.size() > 0);
        // You can add more assertions as needed.
    }
}
