import java.util.ArrayList;
import java.util.Scanner;

public class dataWriterTest {
    public static void main(String[] args) {
       dataWriterTest hi = new dataWriterTest();
       hi.majorTest();
    }

    public void majorTest() {
        Scanner input = new Scanner(System.in);
        MajorList test = MajorList.getInstance();
        CourseList courseList = CourseList.getInstance();
        ArrayList<Course> courses = courseList.getCourses();
        ArrayList<Major> majors = test.getMajors();
        for (Major major : majors) {
            System.out.println("Title?: ");
            String title = input.nextLine();
            System.out.println("MinHours?: ");
            int minHours = input.nextInt();
            System.out.println("MaxHours?: ");
            int maxHours = input.nextInt();
            input.nextLine();
            System.out.println("RequirementSet Title?: ");
            String reqTitle = input.nextLine();
            System.out.println("Minimum Grade?: ");
            String reqGrade = input.nextLine().toUpperCase();
            Grade grade = Grade.valueOf(reqGrade);
            ArrayList<Course> acceptableCourses = new ArrayList<>();
            acceptableCourses.add(courseList.getCourse("MATH", "142"));
            acceptableCourses.add(courseList.getCourse("CSCE", "330"));
            ArrayList<RequirementSet> reqSets = new ArrayList<>();
            reqSets.add(new AndRequirement(reqTitle, acceptableCourses, grade));
            major.addMajorRequirement(new MajorRequirement(reqTitle, minHours, maxHours, reqSets));
        }
        System.out.println("Done");
        input.close();
        test.logout();
    }
}
