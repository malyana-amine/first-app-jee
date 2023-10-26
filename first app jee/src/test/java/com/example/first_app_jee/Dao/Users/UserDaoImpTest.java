package com.example.first_app_jee.Dao.Users;

import com.example.first_app_jee.Entities.Users;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoImpTest {

    private static UserDao userDao;

    @BeforeAll
    public static void setUp() {
        userDao = new UserDaoImp();
    }

    @AfterAll
    public static void tearDown() {
    }

    @Test
    void testAddUser() {
        Users user = new Users();
        user.setEmail("test@example.com");
        user.setPassword("testpassword");

        Users addedUser = userDao.add(user);
        assertNotNull(addedUser);
        assertEquals("test@example.com", addedUser.getEmail());


    }

    @Test
    void testGetUserByEmail() {
        // Assuming you have a test user with known email in the database.
        String email = "xagojyhica@mailinator.com";
        Users user = userDao.getUserByEmail(email);
        assertNotNull(user);
        assertEquals(email, user.getEmail());
        // You can add more assertions as needed.
    }

    @Test
    void testGetUserById() {
        // Assuming you have a test user with known ID in the database.
        int userId = 4; // Replace with the actual user ID.
        Users user = userDao.getUserById(userId);
        assertNotNull(user);
        assertEquals(userId, user.getId());
        // You can add more assertions as needed.
    }

    @Test
    void testGetAllUsers() {
        List<Users> users = userDao.getAllUsers();
        assertNotNull(users);
        assertTrue(users.size() > 0);
        // You can add more assertions as needed.
    }
}
