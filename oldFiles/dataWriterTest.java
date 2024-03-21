package oldFiles;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import msjn.*;
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
        // Only uncomment if you're ABSOLUTELY SURE YOU WANT TO SAVE
        test.logout(); 
    }

    private void workOnMajorRequirements(Major toWorkOn) {
        ArrayList<MajorRequirement> majorRequirements = toWorkOn.getMajorRequirements();
        boolean keepAdding = true;
        while (keepAdding) {
            System.out.println(" MajorRequirement Title?: ");
            String title = input.nextLine();
            System.out.println("MinHours?: ");
            int minHours = input.nextInt();
            input.nextLine();
            System.out.println("MaxHours?: ");
            int maxHours = input.nextInt();
            input.nextLine();
            ArrayList<RequirementSet> toAdd = fillRequirementSets();
            majorRequirements.add(new MajorRequirement(title, minHours, maxHours, toAdd));
            System.out.println("Keep Adding MajorRequirements? y/n: ");
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
            System.out.println("RequirementSet Title?: ");
            String title = input.nextLine();
            System.out.println("Minimum Grade?: ");
            String reqGrade = input.nextLine().toUpperCase();
            Grade grade = Grade.valueOf(reqGrade);
            System.out.println("How do you want to add classes?: ");
            int fillCourseType = showCourseFillingOptions();
            ArrayList<Course> acceptableCourses = new ArrayList<>();
            switch (fillCourseType) {
                case 1: 
                acceptableCourses = fillCourseArray1();
                break;
                case 2: 
                acceptableCourses = fillCourseArray2();
                break;
                case 3: 
                acceptableCourses = fillCourseArray3();
                break;

            }
            
            System.out.println("Is this an And or Or RequirementSet? (a/o)?: ");
            String reqType = input.nextLine();
            switch (reqType) {
                case "a":
                    reqSets.add(new AndRequirement(title,acceptableCourses, grade));
                    break;

                case "o":
                    reqSets.add(new OrRequirement(title,acceptableCourses, grade));
                    break;
                default:
                    System.out.println("ERROR: BAD CHARACTER, FORSHAME");
                    System.exit(0);
                    break;
            }
            System.out.println("Keep Adding RequirementSets? y/n: ");
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

    private int showCourseFillingOptions() {
        System.out.println("1. Fill Courses Individually");
        System.out.println("2. Fill By Keyword");
        System.out.println("3. Fill by Subject and Level (Ex. All 500-level CSCE courses)");
        int choice = input.nextInt();
        input.nextLine();
        return choice;
    }

    private ArrayList<Course> fillCourseArray3() {
        System.out.println("What Subject do these courses derive from? (CSCE, MATH, etc.)?: ");
        String subject = input.nextLine();
        System.out.println("What level should the courses be? (1,2,3,4,5,...): ");
        String level = input.nextLine();
        return courseList.getCoursesSameSubjectInSetLevel(subject,level);
    }

    private ArrayList<Course> fillCourseArray2() {
        ArrayList<Course> keywordCourses = new ArrayList<>();
        System.out.println("Which Keyword would you like the courses of?");
        String keywordChoice = input.nextLine();
        keywordCourses = courseList.findCourses(keywordChoice);
        return keywordCourses;
    }

    private void workOnSemesterPlans(Major toWorkOn) {
        ArrayList<SemesterPlan> recommendedSemesterPlans = toWorkOn.getRecommendedSemesterPlans();
        while (recommendedSemesterPlans.size() < 8) {
            ArrayList<Course> toAdd = fillCourseArray1();
            recommendedSemesterPlans.add(new SemesterPlan(toAdd));
        }

    }

    private ArrayList<Course> fillCourseArray1() {
        ArrayList<Course> toAdd = new ArrayList<>();
        boolean keepAdding = true;
        while (keepAdding) {
            System.out.println(
                    "What course would you like to add? (Write the 4 letter code and the full number ex. CSCE 146, CHEM 111L, etc.)");
            String courseString = input.nextLine();
            String[] values = courseString.split(" ");
            toAdd.add(courseList.getCourse(values[0], values[1]));
            System.out.println("Keep Adding Courses? y/n: ");
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
