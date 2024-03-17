import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Student extends User {
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
    private ArrayList<SemesterPlan> eightSemesterPlan; // Follows a pseudo singleton design pattern

    /*
     * In the User.java, there are 2 final String representing the UUIDs of a blank
     * Advisor and Major (since they cannot be null). When the student is selecting
     * their Major and the Advisor is selecting their students, check for these IDs
     * and replace
     */

    public Student(UUID studentID) {
        super(studentID);
        this.major = new Major(UUID.fromString(BLANK_MAJOR_ID));
        this.year = 2020;
        this.gpa = 3.2;
        this.advisor = new Advisor(UUID.fromString(BLANK_ADVISOR_ID));
        this.semesterPlans = new ArrayList<>();
        this.legalGuardians = new ArrayList<>();
        this.notes = new ArrayList<>();
        this.studentGrades = new HashMap<>();
        this.applicationID = ApplicationID.UNDECLARED;
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

    // Doesn't initialize other members. Might need a bunch of setters. This is for
    // when a new account is created
    public Student(String firstName, String lastName, String email, String password, UUID userID) {
        super(firstName, lastName, email, password, userID);
        this.major = new Major(UUID.fromString(BLANK_MAJOR_ID));
        this.year = 2020;
        this.gpa = 3.2;
        this.advisor = new Advisor(UUID.fromString(BLANK_ADVISOR_ID));
        this.semesterPlans = new ArrayList<>();
        this.legalGuardians = new ArrayList<>();
        this.notes = new ArrayList<>();
        this.studentGrades = new HashMap<>();
        this.applicationID = ApplicationID.UNDECLARED;
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
            if (course.getCourseID().equals(key.getCourseID())) {
                returnGrade[1] = value;
                return;
            }
        });
        return returnGrade[1];
    }

    public ArrayList<SemesterPlan> generateEightSemesterPlan() {
        ArrayList<SemesterPlan> eightSemesterPlan = new ArrayList<SemesterPlan>(8);
        int offset = semesterPlans.size();
        int planIndex = offset;
        
        // Copy already completed classes into new eight semester plan
        for(int i = 0; i < semesterPlans.size(); i++) {
            eightSemesterPlan.add(new SemesterPlan());
            SemesterPlan semesterPlan = eightSemesterPlan.get(i);
            for(Course course : semesterPlans.get(i).getCourses()) {
                semesterPlan.primitiveAddCourse(course);
            }
        }

        eightSemesterPlan.add(new SemesterPlan());

        ArrayList<SemesterPlan> majorMapSkeleton = major.getRecommendedSemesterPlans();

        HashMap<Course, Grade> availableFillerCourses = (HashMap<Course, Grade>)studentGrades.clone();
        
        int semesterHours = 0;

        // Loop through the arrayList of semesters
        for(int i = 0; i < majorMapSkeleton.size(); i++) {
            ArrayList<Course> skeletonSemesterCourses = majorMapSkeleton.get(i).getCourses();
            
            // Loop through the arrayList of courses in the semester
            for(int j = 0; j < skeletonSemesterCourses.size(); j++) {
                // Determine what course to add, if any
                Course tempCourse = skeletonSemesterCourses.get(j);
                Course courseToAdd = tempCourse;
                int semesterHoursToAdd = courseToAdd.getHours();
                boolean addCourse = true;
                
                // Find course that might need to be added
                // First, handle filler courses
                if(tempCourse.getDesignator() == Designator.FILL) {
                    semesterHoursToAdd = 3;
                    // Get courses that could fill this
                    Keyword searchKeyword = tempCourse.getKeywords().get(0);
                    if(searchKeyword == Keyword.AP0 && applicationID != ApplicationID.UNDECLARED) {
                        searchKeyword = Keyword.valueOf(applicationID.getKeyword());
                    }

                    ArrayList<Course> potentialCourses = CourseList.getInstance().findCourses(searchKeyword.toString());
                    
                    // Check if one of the potential courses has been taken, and if it has, then add that course. Otherwise, add the filler
                    outerLoop: 
                    for(Course potentialCourse : potentialCourses) {
                        for(Course studentCourse : availableFillerCourses.keySet()) {
                            Grade studentGrade = availableFillerCourses.get(studentCourse);
                            if(studentGrade != null && (potentialCourse.equals(studentCourse) &&
                            (studentGrade.getPointValue() >= Grade.C.getPointValue()))) {
                                courseToAdd = studentCourse;
                                semesterHoursToAdd = courseToAdd.getHours();
                                availableFillerCourses.remove(studentCourse);
                                addCourse = studentGrade == Grade.R; // If the course hasn't been completed, but has been determined, add it.
                                break outerLoop;
                            }
                        }
                    }                    
                } else { // Handle non-filler courses
                    semesterHoursToAdd = courseToAdd.getHours();
                    Grade grade = studentGrades.get(tempCourse);
                    if(grade != null && grade.getPointValue() >= Grade.C.getPointValue()) {
                        addCourse = false;
                        availableFillerCourses.remove(courseToAdd);
                    }
                }

                
                if(addCourse) {
                    eightSemesterPlan.get(planIndex).primitiveAddCourse(courseToAdd);
                    semesterHours += semesterHoursToAdd;
                }


                if(semesterHours >= 15 && eightSemesterPlan.size() < 8) {
                    eightSemesterPlan.add(new SemesterPlan());
                    semesterHours = 0;
                    planIndex++;
                }
            }
        }
        return eightSemesterPlan;
    }

    public boolean fillCourse(Course fillerCourse) {
        ArrayList<SemesterPlan> eightSemesterPlan = this.generateEightSemesterPlan();

        loop:
        for(SemesterPlan semesterPlan : eightSemesterPlan) {
            for(Course loopCourse : semesterPlan.getCourses()) {
                if(loopCourse.getDesignator() == Designator.FILL &&
                fillerCourse.getKeywords().contains(loopCourse.getKeywords().get(0)) &&
                this.studentGrades.get(fillerCourse) == null) {
                    this.studentGrades.put(fillerCourse, Grade.R);
                    break loop;
                }
            }
        }
        return false;
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

    public boolean getHonors() {
        return isHonors;
    }

    public boolean getHasScholarship() {
        return hasScholarship;
    }

    public ApplicationID getApplicationID() {
        return applicationID;
    }

    public HashMap<Course, Grade> getStudentGrades() {
        return studentGrades;
    }
}
