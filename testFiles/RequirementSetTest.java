package testFiles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import msjn.*;

public class RequirementSetTest {
    Student student;
    Course noPrereqCourse;
    Course satisfiedPrereqCourse;
    Course unsatisfiedPrereqCourse;

    @BeforeClass
	public void oneTimeSetup() {
        CourseList courseList = CourseList.getInstance();
        UserList userList = UserList.getInstance();
        student = userList.getStudentByUUID(UUID.fromString("0b186e4d-9891-4f52-be8a-413c850786ab"));
        noPrereqCourse = courseList.getCourseByUUID(UUID.fromString("1cbec240-4022-42fa-8102-01beb9b8ab57"));
        satisfiedPrereqCourse = courseList.getCourseByUUID(UUID.fromString("928eb174-dea9-4b98-80b1-ac594c4360f8"));
        unsatisfiedPrereqCourse = courseList.getCourseByUUID(UUID.fromString("5ec1b729-0227-4f20-9ad0-f3944d86a0b1"));
	}

    @Test
    public void testNoPrereqCourse() {
        oneTimeSetup();
        assertTrue(noPrereqCourse.SatisfiesRequirement(student));
    }

    @Test
    public void testSatisfiedPrereqCourse() {
        oneTimeSetup();
        assertTrue(satisfiedPrereqCourse.SatisfiesRequirement(student));
    }

    @Test
    public void testUnsatisfiedPrereqCourse() {
        oneTimeSetup();
        assertFalse(unsatisfiedPrereqCourse.SatisfiesRequirement(student));
    }
    
}
