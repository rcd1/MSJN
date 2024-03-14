import java.util.ArrayList;

public class dataLoaderTest {
    public static void main(String[] args) {
        MajorList majorList = MajorList.getInstance();
        ArrayList<Major> test = majorList.getMajors();
        for (Major major : test) {
            System.out.println(major.getMajorName() + "\n" 
            + major.getMajorid() + "\n" 
            + major.getApplicationID());
            for (SemesterPlan semesterPlan : major.getRecommendedSemesterPlans()) {
                semesterPlan.displaySemesterPlan();
            }
        }

        // CourseList courseList = CourseList.getInstance();
        // ArrayList<Course> courses = courseList.getCourses();
        // for (Course course : courses) {
        //     System.out.println(course.getDesignator() + " " +
        //     course.getNumber() + ":");
        //     for (SemesterOffered test : course.getSemestersOffered()) {
        //         System.out.println(test);
        //     }
        //     for (RequirementSet reqSet : course.getPrerequisites()) {
        //         System.out.println(reqSet.getRequiredGrade());
        //         for (Course course2 : reqSet.getRequiredCourses()) {
        //             System.out.println(course2.getDesignator() + " " +
        //             course2.getNumber());
        //         }
        //     }
        //     for (RequirementSet reqSet : course.getCorequisites()) {
        //         System.out.println(reqSet.getRequiredGrade());
        //         for (Course course2 : reqSet.getRequiredCourses()) {
        //             System.out.println(course2.getDesignator() + " " +
        //             course2.getNumber());
        //             for (Keyword keyword : course2.getKeywords()) {
        //                 System.out.println(keyword);
        //             }
        //         }
        //     }
        // }
        // CourseList.logout();
    }
}