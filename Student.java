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
    private ApplicationID applicationID;

    //In the event a student does not have an Advisor, there is an "Empty" Advisor with the UUID "5581ca17-2ddf-4f52-a083-899869f4b5c0",
    

    public Student(UUID studentID) {
        super(studentID);
        this.semesterPlans = new ArrayList<>();
        this.studentGrades = new HashMap<>();
    }


    

    public Student(String firstName, String lastName, String email, String password, UUID userID, Major major, int year,
            double gpa, ArrayList<SemesterPlan> semesterPlans, ArrayList<LegalGuardian> legalGuardians, Advisor advisor,
            ArrayList<String> notes, boolean isHonors, boolean hasScholarship, HashMap<Course, Grade> studentGrades,
            ApplicationID applicationID) {
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
        this.applicationID = applicationID;
    }




    // Doesn't initialize other members. Might need a bunch of setters. This is for when a new account is created
    public Student(String firstName, String lastName, String email, String password, UUID userID) {
        super(firstName, lastName, email, password, userID);
    }

    public double calculateGPA() {
        return -1.0;
    }


    public void setStudentAdvisor(Advisor advisor) {
        this.advisor = advisor;
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

    public String toString() {
        return super.toString();

    }


    public void reloadAdvisor() {
        Advisor realOne = UserList.getAdvisorByUUID(advisor.userID);
        this.advisor = realOne;
    }




    public Major getMajor() {
        return major;
    }




    public int getYear() {
        return year;
    }




    public double getGpa() {
        return gpa;
    }




    public ArrayList<SemesterPlan> getSemesterPlans() {
        return semesterPlans;
    }




    public ArrayList<LegalGuardian> getLegalGuardians() {
        return legalGuardians;
    }




    public Advisor getAdvisor() {
        return advisor;
    }




    public ArrayList<String> getNotes() {
        return notes;
    }




    public boolean isHonors() {
        return isHonors;
    }




    public boolean isHasScholarship() {
        return hasScholarship;
    }




    public ApplicationID getApplicationID() {
        return applicationID;
    }
}
