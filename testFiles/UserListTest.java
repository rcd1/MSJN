package testFiles;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import msjn.*;

public class UserListTest {
	private UserList userList;

	@BeforeEach
	public void setup() {
		userList = UserList.getInstance();
	}
	
	@AfterEach
	public void tearDown() {
		userList = null;
	}

	@Test
	public void testAddUser() {
		UUID userID = UUID.randomUUID();
		User user = new Student("Jane", "Dawson", "jdawson@email.sc.edu", "pL320", userID);
		userList.addUser(user);

		ArrayList<Student> students = UserList.getStudents();
		boolean found = false;
		for (Student student : students) {
			if (student.getEmail().equalsIgnoreCase("jdawson@email.sc.edu")) {
				found = true;
				break;
			}
		}
		assertTrue(found);
	}

	@Test 
	public void testFindStudentByName() {
		Student student = userList.findStudentByName("Jane", "Dawson");
		assertNotNull(student);
		assertEquals("Jane", student.getFirstName());
		assertEquals("Dawson", student.getLastName());
	}

}
