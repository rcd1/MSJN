import java.util.ArrayList;
import java.util.HashMap;

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

    

    public Student(String firstName, String lastName, String email, String password, Major major, int year, double gpa,
            ArrayList<SemesterPlan> semesterPlans, ArrayList<LegalGuardian> legalGuardians, Advisor advisor,
            ArrayList<String> notes, boolean isHonors, boolean hasScholarship, HashMap<Course, Grade> studentGrades) {
        super(firstName, lastName, email, password);
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

    public void addCourse(Course course) {

    }

    public void removeCourse(Course course) {

    }

    private void resetPassword(String newPassword) {

    }

    public double calculateGPA() {
        return -1.0;
    }

    public void removeLegalGuardian(LegalGuardian legalGuardian) {

    }

    public void viewNote(Student student, String note) {

    }

    public void notifier() {

    }

    public void whatIf(Major major, ArrayList<Course> courses) {
        
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    protected void viewStudentProfile(Student student) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewStudentProfile'");
    }
    
}
