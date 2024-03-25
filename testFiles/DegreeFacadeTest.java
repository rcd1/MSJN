package testFiles;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import msjn.*;

public class DegreeFacadeTest {
    private DegreeFacade degreeFacade;
    private UserList userList;
    private CourseList courseList;
    private MajorList majorList;
    private User user;


    @BeforeEach
    public void setup() {
        degreeFacade = new DegreeFacade();
        userList = UserList.getInstance();
        courseList = courseList.getInstance();
        majorList = MajorList.getInstance();
    }

    @AfterEach
    public void tearDown() {
        degreeFacade = null;
    }

    @Test
    public void testLogin() {
        user = degreeFacade.login("bwest@email.sc.edu", "mma3w&zh3r3");
        assertNotNull(user);
    }

    @Test
    public void testLogout() {
        degreeFacade.logout();
        assertNull(user);
    }

    @Test
    public void testCreateAccount() {
        User user = degreeFacade.createAccount("Brax", "West", "bwest@email.sc.edu", "mma3w&zh3r3", UserType.STUDENT);
        assertNotNull(user);
        assertEquals("Brax", user.getFirstName());
        assertEquals("West", user.getLastName());
    }

    @Test
    void testAddCourseToSemesterPlan() {
        Student student = new Student("Brax", "West", "bwest@email.sc.edu", "mma3w&zh3r3", UUID.randomUUID());
        Course course = new Course(UUID.randomUUID(), Designator.MATH, "174", 3, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), "Discrete Mathematics for Computer Science ", "Logic, number theory, sequences, series, recursion, mathematical induction, set theory, enumeration, functions, relations, graphs and trees. Connections to computers and to programming are emphasized when possible.", 5);
        degreeFacade.addCourseToSemsterPlan(student, course);
        assertEquals(1, student.getSemesterPlans().size());
    }

    @Test
    void testRemoveCourseFromSemesterPlan() {
        Student student = new Student("Brax", "West", "bwest@email.sc.edu", "mma3w&zh3r3", UUID.randomUUID());
        Course course = new Course(UUID.randomUUID(), Designator.MATH, "174", 3, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), "Discrete Mathematics for Computer Science", "Logic, number theory, sequences, series, recursion, mathematical induction, set theory, enumeration, functions, relations, graphs and trees. Connections to computers and to programming are emphasized when possible.", 5);
        student.addCourseToSemsterPlan(course);
        degreeFacade.removeCourseFromSemesterPlan(student, course);
        assertEquals(0, student.getSemesterPlans().size());
    }

    @Test
    public void testFindCourses() {
        ArrayList<Course> courses = degreeFacade.findCourses("Accounting");
        assertFalse(courses.isEmpty());
    }

    @Test
    public void testDisplaySemesterPlan() {
        Student student = new Student("Brax", "West", "bwest@email.sc.edu", "mma3w&zh3r3", UUID.randomUUID());
        degreeFacade.displaySemesterPlan(student);
    }

    @Test
    public void testDisplayAdvisorStudentsList() {
        Advisor advisor = new Advisor("Jane", "Dawson", "jdawson@email.sc.edu", "pL123", UUID.randomUUID());
        advisor.addStudent(new Student("Brax", "West", "bwest@email.sc.edu", "mma3w&zh3r3", UUID.randomUUID()));
        degreeFacade.displayAdvisorStudentsList(advisor);
    }

    @Test
    public void testAddStudentToAdvisorList() {
        Advisor advisor = new Advisor("Jane", "Dawson", "jdawson@email.sc.edu", "pL123", UUID.randomUUID());
        degreeFacade.addStudentToAdvisorList(advisor, "Brax", "West");
        assertEquals(1, advisor.getStudents().size());
    }

    @Test
    public void testViewStudentProgress() {
        Student student = new Student("Brax", "West", "bwest@email.sc.edu", "mma3w&zh3r3", UUID.randomUUID());
        student.addCourseToSemsterPlan(new Course(UUID.randomUUID(), Designator.MATH, "174", 3, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), "Discrete Mathematics for Computer Science", "Logic, number theory, sequences, series, recursion, mathematical induction, set theory, enumeration, functions, relations, graphs and trees. Connections to computers and to programming are emphasized when possible.", 5));
        degreeFacade.viewStudentProgress(student);
    }

    @Test
    public void testAddNote() {
        Student student = new Student("Brax", "West", "bwest@email.sc.edu", "mma3w&zh3r3", UUID.randomUUID());
        degreeFacade.addNote(student, "New Note");
        assertEquals("New Note", student.getNotes().get(0));
    }
}
