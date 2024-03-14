import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Student extends User{
    private Major major;
    private int year;
    private double gpa;
    private ArrayList<SemesterPlan> semesterPlans;
    private ArrayList<LegalGuardian> legalGuardians;
    private Advisor advisor;
    private ArrayList<String> notes;
    private boolean isHonors;
    private boolean hasScholarship;
    private HashMap<Course, Grade> studentGrades;

    public Student(UUID studentID) {
        super(studentID);
        this.semesterPlans = new ArrayList<>();
        this.studentGrades = new HashMap<>();
    }


    public Student(String firstName, String lastName, String email, String password, UUID userID, Major major, int year, double gpa,
            ArrayList<SemesterPlan> semesterPlans, ArrayList<LegalGuardian> legalGuardians, Advisor advisor,
            ArrayList<String> notes, boolean isHonors, boolean hasScholarship, HashMap<Course, Grade> studentGrades) {
        super(firstName, lastName, email, password, userID);
        this.major = major;
        this.year = year;
        this.gpa = gpa;
        this.semesterPlans = semesterPlans;
        this.legalGuardians = legalGuardians;
        this.advisor = advisor;
        this.notes = notes;
        this.isHonors = isHonors;
        this.hasScholarship = hasScholarship;
        this.studentGrades = studentGrades;
    }

    // Doesn't initialize other members. Might need a bunch of setters. This is for when a new account is created
    public Student(String firstName, String lastName, String email, String password, UUID userID) {
        super(firstName, lastName, email, password, userID);
    }

    public Advisor getStudentAdvisor() {
        return advisor;
    }

    public double calculateGPA() {
        return -1.0;
    }

    public double getStudentGPA() {
        return gpa;
    }

    public HashMap<Course, Grade> getStudentGrades() {
        return studentGrades;
    }
    
    public boolean getStudentHasScholarship() {
        return hasScholarship;
    }

    public boolean getStudentIsHonors() {
        return isHonors;
    }

    public ArrayList<LegalGuardian> getStudentLegalGuardian() {
        return legalGuardians;
    }

    public Major getStudentMajor() {
        return major;
    }

    public ArrayList<String> getStudentNotes() {
        return notes;
    }

    public void addCourseToSemsterPlan(Course course) {
        if (!semesterPlans.isEmpty()) {
            SemesterPlan lastSemesterPlan = semesterPlans.get(semesterPlans.size() - 1);
            lastSemesterPlan.addCourse(course);
        } else {
            SemesterPlan semesterPlan = new SemesterPlan();
            semesterPlan.addCourse(course);
            semesterPlans.add(semesterPlan);
        }
    }

    public void removeCourseFromSemesterPlan(Course course) {
        if (!semesterPlans.isEmpty()) {
            SemesterPlan lastSemesterPlan = semesterPlans.get(semesterPlans.size() - 1);
            lastSemesterPlan.removeCourse(course);
        }
    }

    public void displaySemesterPlan() {
        if (!semesterPlans.isEmpty()) {
            SemesterPlan lastSemesterPlan = semesterPlans.get(semesterPlans.size() - 1);
            lastSemesterPlan.displaySemesterPlan();
        } else {
            System.out.println("No semester plans available");
        }
    }

    public void viewNote(Student student, String note) {

    }

    public void notifier() {

    }

    public void whatIf(Major major, ArrayList<Course> courses) {
        
    }

    @Override
    protected void viewStudentProfile(Student student) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewStudentProfile'");
    }

    // This could be renamed to something like "getGrade"
    public Grade satisfiesPrerequisite(Course course) {
        Grade[] returnGrade = new Grade[1];
        returnGrade[1] = null;
        studentGrades.forEach((key, value) -> {
            if(course.getCourseID().equals(key.getCourseID())) {
                returnGrade[1] = value;
                return;
            }
        });
        return returnGrade[1];
    }

    public void generateSemesterPlans() {
        
    }
}
