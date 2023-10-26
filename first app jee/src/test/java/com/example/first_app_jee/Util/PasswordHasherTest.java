package com.example.first_app_jee.Util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordHasherTest {


    @Test
    public void test_hash_password_successfully() {
        String password = "password123";
        String hashedPassword = PasswordHasher.hash(password);
        assertNotNull(hashedPassword);
    }

    @Test
    public void test_verify_correct_password_successfully() {
        String password = "password123";
        String hashedPassword = PasswordHasher.hash(password);
        assertTrue(PasswordHasher.verify(hashedPassword, password));
    }


    @Test
    public void test_return_false_for_incorrect_password() {
        String password = "password123";
        String incorrectPassword = "password456";
        String hashedPassword = PasswordHasher.hash(password);

        assertFalse(PasswordHasher.verify(hashedPassword, incorrectPassword));
    }

    @Test
    public void test_throw_exception_for_null_password() {
        assertThrows(NullPointerException.class, () -> {
            PasswordHasher.hash(null);
        });
    }
}