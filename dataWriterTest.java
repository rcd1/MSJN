import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class dataWriterTest {
    private Scanner input;
    private MajorList test;
    private CourseList courseList;
    private UserList userList;

    public dataWriterTest() {
        this.input = new Scanner(System.in);
        this.test = MajorList.getInstance();
        this.courseList = CourseList.getInstance();
        this.userList = UserList.getInstance();
    }

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
        System.out.println("Majors Available:");
        for (int i = 1; i < majors.size(); i++) {
            System.out.println(i + ". " + majors.get(i).getMajorName());
        }
        System.out.println("Pick a number for the Major you would like to work on: ");
        int userInt = input.nextInt();
        input.nextLine();
        Major toWorkOn = majors.get(userInt);
        System.out.println("What would you like change in " + toWorkOn.getMajorName() + "?");
        displayMajorRevisionOptions();
        userInt = input.nextInt();
        input.nextLine();

        switch (userInt) {
            case 1:
                workOnSemesterPlans(toWorkOn);
                break;
            case 2:
                workOnMajorRequirements(toWorkOn);
                break;
            default:
                System.exit(0);
        }

        input.close();
        test.logout();
    }

    private void workOnMajorRequirements(Major toWorkOn) {
        ArrayList<MajorRequirement> majorRequirements = toWorkOn.getMajorRequirements();
        boolean keepAdding = true;
        while (keepAdding) {
            System.out.println("Title?: ");
            String title = input.nextLine();
            System.out.println("MinHours?: ");
            int minHours = input.nextInt();
            input.nextLine();
            System.out.println("MaxHours?: ");
            int maxHours = input.nextInt();
            input.nextLine();
            ArrayList<RequirementSet> toAdd = fillRequirementSets();
            majorRequirements.add(new MajorRequirement(title, minHours, maxHours, toAdd));
            System.out.println("Keep Adding? y/n: ");
            String choice = input.nextLine().toLowerCase();
            switch (choice) {
                case "y":
                    continue;
                default:
                    keepAdding = false;
                    break;
            }
        }

    }

    private ArrayList<RequirementSet> fillRequirementSets() {
        boolean keepAdding = true;
        ArrayList<RequirementSet> reqSets = new ArrayList<>();

        while (keepAdding) {
            System.out.println("Minimum Grade?: ");
            String reqGrade = input.nextLine().toUpperCase();
            Grade grade = Grade.valueOf(reqGrade);
            ArrayList<Course> acceptableCourses = fillCourseArray();
            System.out.println("Is this an And or Or RequirementSet? (a/o)?: ");
            String reqType = input.nextLine();
            switch (reqType) {
                case "a":
                    reqSets.add(new AndRequirement(acceptableCourses, grade));
                    break;

                case "o":
                    reqSets.add(new OrRequirement(acceptableCourses, grade));
                    break;
                default:
                    System.out.println("ERROR: BAD CHARACTER, FORSHAME");
                    System.exit(0);
                    break;
            }
            System.out.println("Keep Adding? y/n: ");
            String choice = input.nextLine().toLowerCase();
            switch (choice) {
                case "y":
                    continue;
                default:
                    keepAdding = false;
                    break;
            }
        }
        return reqSets;
    }

    private void workOnSemesterPlans(Major toWorkOn) {
        ArrayList<SemesterPlan> recommendedSemesterPlans = toWorkOn.getRecommendedSemesterPlans();
        while (recommendedSemesterPlans.size() < 8) {
            ArrayList<Course> toAdd = fillCourseArray();
            recommendedSemesterPlans.add(new SemesterPlan(toAdd));
        }

    }

    private ArrayList<Course> fillCourseArray() {
        ArrayList<Course> toAdd = new ArrayList<>();
        boolean keepAdding = true;
        while (keepAdding) {
            System.out.println(
                    "What course would you like to add? (Write the 4 letter code and the full number ex. CSCE 146, CHEM 111L, etc.)");
            String courseString = input.nextLine();
            String[] values = courseString.split(" ");
            toAdd.add(courseList.getCourse(values[0], values[1]));
            System.out.println("Keep Adding? y/n: ");
            String choice = input.nextLine().toLowerCase();
            switch (choice) {
                case "y":
                    continue;
                default:
                    keepAdding = false;
                    break;
            }
        }
        return toAdd;
    }

    private void displayMajorRevisionOptions() {
        System.out.println("1. Semester Plans");
        System.out.println("2. Major Requirements");
    }

    public void usersTest() {
        UserList userList = UserList.getInstance();
        ArrayList<Student> students = userList.getStudents();
        ArrayList<Advisor> advisors = userList.getAdvisors();
        Student student = new Student("Test", "Terry", "email@email.email", "passwordbutcool", UUID.randomUUID());
        students.add(student);
        Advisor advisor = new Advisor("Testing", "Testerson", "The third", "Esquire", UUID.randomUUID());
        advisors.add(advisor);
        userList.logout();

    }

}
