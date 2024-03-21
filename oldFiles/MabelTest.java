package oldFiles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import msjn.*;
public class MabelTest {
    public static void main(String[] args) {
        CourseList courseList = CourseList.getInstance();
        UserList userList = UserList.getInstance();
        MajorList majorList = MajorList.getInstance();

        // Student student = userList.getStudentByUUID(UUID.fromString("0b186e4d-9891-4f52-be8a-413c850786ab"));
        // Course course = courseList.getCourseByUUID(UUID.fromString("a2ce92f5-ce38-4724-b453-0f434cd0460b"));
        // System.out.println(course.SatisfiesRequirement(student));





        Student student = userList.getStudentByUUID(UUID.fromString("0b186e4d-9891-4f52-be8a-413c850786ab"));
        student.setApplicationID(ApplicationID.DIGITALDESIGN);
        student.fillCourse(courseList.getCourseByUUID(UUID.fromString("444eb709-c8c3-43d8-ad00-1bcb581f807d")));
        ArrayList<SemesterPlan> semesterPlans = student.generateEightSemesterPlan();
        //semesterPlans = majorList.getMajorByUUID(UUID.fromString("5ded2f1a-0d27-4b1e-8d70-cb779bc16bde")).getRecommendedSemesterPlans();
        for(SemesterPlan semesterPlan : semesterPlans) {
            for(Course course : semesterPlan.getCourses()) {
                System.out.print(course.getDesignator());
                System.out.print(course.getNumber());
                for(Keyword keyword : course.getKeywords()) {
                    System.out.print(" ");
                    System.out.print(keyword);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    
}
