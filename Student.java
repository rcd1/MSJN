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

    public Student(String firstName, String lastName, String email, String password, Major major, int year) {

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

    public void viewNote(Student student, string note) {

    }

    public void notifier() {

    }

    public void whatIf(Major major, ArrayList<Course> courses) {
        
    }
    
}