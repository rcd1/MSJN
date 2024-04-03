
package testFiles;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import msjn.*;

class CourseListTest {
    private CourseList courseList;
    private ArrayList<Course> testCourses;

    @BeforeEach
    void setUp() {
        courseList = CourseList.getInstance();
        testCourses = new ArrayList<>();

        Course course1 = new Course(UUID.randomUUID(), Designator.CSCE, "101", 3, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), "Intro to Computing", "Basic computing concepts", 1);
        Course course2 = new Course(UUID.randomUUID(), Designator.MATH, "201", 3, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), "English Literature", "Study of English literature", 1);
        
        testCourses.add(course1);
        testCourses.add(course2);
        courseList.getCourses().clear();
        courseList.getCourses().addAll(testCourses);
    }

    @AfterEach
    void tearDown() {
        courseList.getCourses().clear();
    }

    @Test
    void testGetCoursesNotEmpty() {
        assertFalse(courseList.getCourses().isEmpty(), "The course list should not be empty.");
    }

    @Test
    void testGetCourseByValidDetails() {
        Course foundCourse = courseList.getCourse("CSCE", "101", 3);
        assertNotNull(foundCourse, "A course with the given details should be found.");
    }

    @Test
    void testGetCourseByInvalidDetails() {
        Course foundCourse = courseList.getCourse("MATH", "101", 3);
        assertNull(foundCourse, "No course should be found.");
    }


    @Test
    void testFindCoursesWithKeyword() {
        Course course = testCourses.get(0); 

        ArrayList<Course> foundCourses = courseList.findCourses("Computing");
        assertFalse(foundCourses.isEmpty(), "Courses with the specified keyword should be found.");
    }

    @Test
    void testGetCourseByUUID() {
        Course expectedCourse = testCourses.get(0); 
        UUID courseID = expectedCourse.getCourseID();
        Course foundCourse = CourseList.getCourseByUUID(courseID);
        assertEquals(expectedCourse, foundCourse, "The course found by UUID should match the expected course.");
    }

}
