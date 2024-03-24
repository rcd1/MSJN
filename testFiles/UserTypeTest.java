package testFiles;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import msjn.*;

public class UserTypeTest {
    private UserType userType;
   
    @BeforeEach
    public void setup() {
        userType = null;
    }

    @AfterEach
    public void tearDown() {
        userType = null;
    }

    @Test
    public void testGetPhraseStudent() {
        userType = UserType.STUDENT;
        assertEquals("Student", userType.getPhrase());
    }

    @Test
    public void testGetPhraseAdvisor() {
        userType = UserType.ADVISOR;
        assertEquals("Advisor", userType.getPhrase());
    }
}
