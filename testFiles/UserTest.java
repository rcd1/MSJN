package testFiles;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import msjn.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import msjn.*;

public class UserTest {
    private User user;

    @BeforeEach
    public void setup() {
        UUID userID = UUID.randomUUID();
        user = new UserMock("Brax","West","bwest@email.sc.edu","ma3w&zh3r3",userID);
    }

    @AfterEach
    public void tearDown() {
        user = null;
    }

    @Test
    public void testCheckCredentialsIsValid() {
        assertTrue(user.checkCredentials("Brax","West","bwest@email.sc.edu"));
    }

    @Test
    public void testCheckCredentialsIsInvalid() {
        assertFalse(user.checkCredentials("Braz","West","bwest@email.sc.edu"));
    }

    @Test
    public void testToString() {
        String expected = "First Name: Brax\n" + "Last Name: West\n" + "Email: bwest@email.sc.edu\n" + "Password: ma3w&zh3r3";
        assertEquals(expected, user.toString());
    }

    // For testing abstract method
    private class UserMock extends User {
        public UserMock(String firstName, String lastName, String email, String password, UUID userID) {
            super(firstName, lastName, email, password, userID);
        }

        @Override
        protected void viewStudentProfile(Student student) {

        }
    }
}
