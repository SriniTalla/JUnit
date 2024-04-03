package org.example;

import static org.junit.Assert.assertTrue;
import org.junit.Assume;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Login {

    @Test
    public void test_a_loginWithValidCredentials() {
        System.out.println("Successfully Logged in!!!");
        assertTrue( true );
    }

    @Ignore
    @Test
    public void test_b_loginWithInValidCredentials() {
        System.out.println("Error: Invalid Credentials!!!");
        assertTrue( true );
    }

    @Test
    public void test_c_loginWithValidUsernameAndInvalidPassword() {
        System.out.println("Error: Invalid Password!!!");
        assertTrue( true );
    }

    @Test
    public void test_d_loginWithInValidUsernameAndValidPassword() {
        System.out.println("Error: Invalid Username!!!");
        assertTrue( true );
    }

}
