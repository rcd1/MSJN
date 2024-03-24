package testFiles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import msjn.*;

public class UserTest {
    private Student student;
    
    @BeforeClass
	public void oneTimeSetup() {
		CourseList courseList = CourseList.getInstance();
        UserList userList = UserList.getInstance();
        student = userList.getStudentByUUID(UUID.fromString("5581ca17-2ddf-4f52-a083-899869f4b5c0"));
	}

    @Test
    public void testCheckCredentials() {
        
    }
}
