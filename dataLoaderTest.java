import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class dataLoaderTest {
    public static void main(String[] args) {
        dataLoaderTest goober = new dataLoaderTest(); //goober nice :) 
        // goober.courseTest();
        // goober.userTest();
        // goober.majorTest();
        // goober.addNameAndDesc();
    }

    public void majorTest() {
        MajorList majorList = MajorList.getInstance();
        ArrayList<Major> test = majorList.getMajors();
        for (Major major : test) {
            System.out.println(major.getMajorName() + "\n" 
            + major.getMajorid() + "\n");
            for (SemesterPlan semesterPlan : major.getRecommendedSemesterPlans()) {
                semesterPlan.displaySemesterPlan();
            }
            for (MajorRequirement reqs: major.getMajorRequirements()) {
                System.out.println(reqs.getTitle());
            }
            
        }
    }
    
    public void courseTest() {
        CourseList courseList = CourseList.getInstance();
        ArrayList<Course> courses = courseList.getCourses();
        for (Course course : courses) {
            System.out.println(course.getDesignator() + " " +
            course.getNumber() + ":");
            System.out.println(course.getName() + "\n" + course.getDescription());
            // for (SemesterOffered test : course.getSemestersOffered()) {
            //     System.out.println(test);
            // }
            // for (RequirementSet reqSet : course.getPrerequisites()) {
            //     System.out.println(reqSet.getRequiredGrade());
            //     for (Course course2 : reqSet.getRequiredCourses()) {
            //         System.out.println(course2.getDesignator() + " " +
            //         course2.getNumber());
            //     }
            // }
            // for (RequirementSet reqSet : course.getCorequisites()) {
            //     System.out.println(reqSet.getRequiredGrade());
            //     for (Course course2 : reqSet.getRequiredCourses()) {
            //         System.out.println(course2.getDesignator() + " " +
            //         course2.getNumber());
            //         for (Keyword keyword : course2.getKeywords()) {
            //             System.out.println(keyword);
            //         }
            //     }
            // }
            // for (Keyword key : course.getKeywords()) {
            //     System.out.println(key);
            // }

        }
        // CourseList.logout();
    }

    public void userTest() {
        UserList userList = UserList.getInstance();
        ArrayList<Student> students = userList.getStudents();
        ArrayList<Advisor> advisors = userList.getAdvisors();

        for (Advisor advisor : advisors) {
            System.out.println(advisor.toString());
        }

        for (Student student : students) {
            System.out.println(student.toString() + "\n" + student.getApplicationID());
        }
    }

    // public void addNameAndDesc() {
    //     CourseList courseList = CourseList.getInstance();
    //     ArrayList<String[]> thingies = DataLoader2.getNameAndDescriptions();
    //     ArrayList<Course> courses = courseList.getCourses();
    //     System.out.println(thingies.size() + " " + courses.size());
    //     for (int i = 0; i < 4845; i++) {
    //         courses.get(i).setName(thingies.get(i)[0]);
    //         courses.get(i).setDescription(thingies.get(i)[1]);
    //     }
    //     courseList.logout();
    // }
}

