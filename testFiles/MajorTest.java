package testFiles;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import msjn.*;

class MajorTest{
    private Major major;
    private UUID majorId;
    private String majorName;
    private ArrayList<MajorRequirement> majorRequirements = new ArrayList<>();
    private ArrayList<SemesterPlan> recommendedSemesterPlans = new ArrayList<>();

    @BeforeEach
    void setUp() {
        String majorName = null;
        majorRequirements = new ArrayList<>();
        recommendedSemesterPlans = new ArrayList<>();
        major = new Major(majorId, majorName, majorRequirements, recommendedSemesterPlans);
    }

    @AfterEach
    public void tearDown(){

    }

    @Test //successful. Needed to turn MajorName String to null
    public void testConstruction() {
        assertEquals(majorId, major.getMajorid());
        assertEquals(majorName, major.getMajorName());
        assertEquals(majorRequirements, major.getMajorRequirements());
        assertEquals(recommendedSemesterPlans, major.getRecommendedSemesterPlans());
    }

    @Test //Succesfull, returned CIS as false though. 
    public void testCheckMajors() {
        assertTrue(major.checkMajor("Computer Science"));
        assertFalse(major.checkMajor("Blah"));
    }
    
    @Test //Successfull
    public void testAddMajorRequirement() {
        MajorRequirement test = new MajorRequirement(majorName, 0, 0, null);
        major.addMajorRequirement(test);
        assertTrue(major.getMajorRequirements().contains(test));
    }
}