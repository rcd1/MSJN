package testFiles;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import msjn.*;

public class SemesterPlanTest {
    private SemesterPlan semesterPlan;
	
	@BeforeEach
	public void setup() {
		semesterPlan = new SemesterPlan();
	}
	
	@AfterEach
	public void tearDown() {
		semesterPlan = null;
	}

	@Test
	public void testAddCourse() {
		Course course = new Course(UUID.randomUUID(), Designator.ACCT, "ACCT222", 3, 
			new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), "Survey of Accounting", "Survey of accounting topics related to business decisions including financial reporting, managerial accounting, and other special topics.", 5);
		assertTrue(semesterPlan.addCourse(course));
		assertEquals(1,semesterPlan.getCourses().size());
		assertEquals(5,semesterPlan.getHours());
	}	

	@Test
	public void testAddCourseExceedingHours() {
		Course course = new Course(UUID.randomUUID(), Designator.ACCT, "ACCT222", 3, 
			new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), "Survey of Accounting", "Survey of accounting topics related to business decisions including financial reporting, managerial accounting, and other special topics.", 5);
		assertFalse(semesterPlan.addCourse(course));
		assertEquals(0, semesterPlan.getCourses().size());
		assertEquals(0, semesterPlan.getHours());
	}

	@Test
	public void testRemoveCourse() {
		Course course = new Course(UUID.randomUUID(), Designator.ACCT, "ACCT222", 3, 
			new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), "Survey of Accounting", "Survey of accounting topics related to business decisions including financial reporting, managerial accounting, and other special topics.", 5);
		semesterPlan.addCourse(course);
		assertTrue(semesterPlan.removeCourse(course));
		assertEquals(0, semesterPlan.getCourses().size());
		assertEquals(0, semesterPlan.getHours());
	}

	@Test
	public void testDisplaySemesterPlanEmpty() {
		String expectedOutput = "Semester Plan is empty. \nTotal hours: 0\n";
		assertEquals(expectedOutput, getSemesterPlanDisplay());
	}

	@Test
	public void testDisplaySemesterPlanNotEmpty() {
		Course course1 = new Course(UUID.randomUUID(), Designator.ACCT, "ACCT222", 3,
			new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), "Survey of Accounting", "Survey of accounting topics related to business decisions including financial reporting, managerial accounting, and other special topics.", 5);
		Course course2 = new Course(UUID.randomUUID(), Designator.MATH, "MATH174", 3, 
			new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), "Discrete Mathematics for Computer Science", "Logic, number theory, sequences, series, recursion, mathematical induction, set theory, enumeration, functions, relations, graphs and trees. Connections to computers and to programming are emphasized when possible.", 5);
		semesterPlan.addCourse(course1);
		semesterPlan.addCourse(course2);

		String expectedOutput = "";
		assertEquals(expectedOutput, getSemesterPlanDisplay());
	}

	private String getSemesterPlanDisplay() {
        StringBuilder outputBuilder = new StringBuilder();
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                outputBuilder.append((char) b);
            }
        }));
        semesterPlan.displaySemesterPlan();
        return outputBuilder.toString();
    }
}
