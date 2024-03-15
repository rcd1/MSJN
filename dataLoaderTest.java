import java.util.ArrayList;

public class dataLoaderTest {
    public static void main(String[] args) {
        dataLoaderTest goober = new dataLoaderTest();
        // goober.courseTest();
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
            for (SemesterOffered test : course.getSemestersOffered()) {
                System.out.println(test);
            }
            for (RequirementSet reqSet : course.getPrerequisites()) {
                System.out.println(reqSet.getRequiredGrade());
                for (Course course2 : reqSet.getRequiredCourses()) {
                    System.out.println(course2.getDesignator() + " " +
                    course2.getNumber());
                }
            }
            for (RequirementSet reqSet : course.getCorequisites()) {
                System.out.println(reqSet.getRequiredGrade());
                for (Course course2 : reqSet.getRequiredCourses()) {
                    System.out.println(course2.getDesignator() + " " +
                    course2.getNumber());
                    for (Keyword keyword : course2.getKeywords()) {
                        System.out.println(keyword);
                    }
                }
            }
            for (Keyword key : course.getKeywords()) {
                System.out.println(key);
            }

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
}

