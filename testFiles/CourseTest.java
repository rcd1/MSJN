package testFiles;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import msjn.*;

class CourseTest {
    private Course course;
    private ArrayList<RequirementSet> prerequisites = new ArrayList<>();
    private ArrayList<RequirementSet> corequisites = new ArrayList<>();
    private ArrayList<Keyword> keywords = new ArrayList<>();
    private ArrayList<SemesterOffered> semestersOffered = new ArrayList<>();

    @BeforeEach
    void setUp() {
       
        UUID courseID = UUID.randomUUID();
        Designator designator = Designator.CSCE; 
        String number = "101";
        int hours = 3;
        String name = "Introduction to Computer Science";
        int preferredSemester = 1;

        semestersOffered.add(SemesterOffered.FALL); 

        course = new Course(courseID, designator, number, hours, prerequisites, corequisites, keywords, semestersOffered, name, name, preferredSemester);
    }

    @AfterEach
    void tearDown() {
        course = null;
    }

    @Test
    void testCourseCreation() {
        assertNotNull(course, "The course should be created successfully.");
    }

    @Test
    void testGetCourseID() {
        assertNotNull(course.getCourseID(), "The course ID should not be null.");
    }

    @Test
    void testGetDesignator() {
        assertEquals(Designator.CSCE, course.getDesignator(), "The designator should match the one set during course creation.");
    }

    @Test
    void testGetNumber() {
        assertEquals("101", course.getNumber(), "The course number should match the one set during course creation.");
    }

    @Test
    void testGetHours() {
        assertEquals(3, course.getHours(), "The course hours should match the ones set during course creation.");
    }

    @Test
    void testGetName() {
        assertEquals("Introduction to Computer Science", course.getName(), "The course name should match the one set during course creation.");
    }

    @Test
    void testGetDescription() {
        assertEquals("This course introduces the fundamental concepts of computer science.", course.getDescription(), "The course description should match the one set during course creation.");
    }

    @Test
    void testGetPreferredSemester() {
        assertEquals(1, course.getPreferredSemester(), "The preferred semester should match the one set during course creation.");
    }

    @Test
    void testCheckCourseWithCorrectDetails() {
        assertTrue(course.checkCourse("CSCE", "101", 3), "The course should match the provided details.");
    }

    @Test
    void testCheckCourseWithIncorrectDetails() {
        assertFalse(course.checkCourse("MATH", "101", 3), "The course should not match incorrect details.");
    }

}
