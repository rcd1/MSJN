import java.util.UUID;
import java.util.ArrayList;
/*
 * The attributes of the course class 
 */
public class Course {
    private UUID courseID;
    private Designator designator;
    private String number;
    private int hours;
    private ArrayList<CourseRequisite> requirements;
    private ArrayList<Keyword> keywords;
    private int preferredSemester;

    
    /**
     * For DataLoader, I won't be able to fully create requirements the same passthrough I create the courses, so we get a dummy course to fill in
     * @param courseID
     */
    public Course(UUID courseID) {
        this.courseID = courseID;
    }


    /**
     * A Mutator method for the parameters setted up in the Course class 
     * @param courseID 
     * @param designator The type of course the student will be taking (e.g. CHEM, CSCE, MATH, etc)
     * @param number digits meant tp imply the level of the course 
     * @param hours The number of hours the student will be taking
     * @param requirements the requistes that needs to be completed before or during taking the course
     * @param keywords The Carolina Core and Honors
     * @param preferredSemester The semester that course is recommended by the major map
     */
    public Course(UUID courseID, Designator designator, String number, int hours, ArrayList<CourseRequisite> requirements,
            ArrayList<Keyword> keywords, int preferredSemester) {
        this.courseID = courseID;
        this.designator = designator;
        this.number = number;
        this.hours = hours;
        this.requirements = requirements;
        this.keywords = keywords;
        this.preferredSemester = preferredSemester;
    }


    public UUID getCourseID() {
        return courseID;
    }


    public void setCourseID(UUID courseID) {
        this.courseID = courseID;
    }


    public Designator getDesignator() {
        return designator;
    }


    public void setDesignator(Designator designator) {
        this.designator = designator;
    }


    public String getNumber() {
        return number;
    }


    public void setNumber(String number) {
        this.number = number;
    }


    public int getHours() {
        return hours;
    }


    public void setHours(int hours) {
        this.hours = hours;
    }


    public ArrayList<CourseRequisite> getRequirements() {
        return requirements;
    }


    public void setRequirements(ArrayList<CourseRequisite> requirements) {
        this.requirements = requirements;
    }


    public ArrayList<Keyword> getKeywords() {
        return keywords;
    }

    /**
     * A mutator method for the user class
     * @param keywords The code of the courses such as the Carolina Cores and Honors Courses
     */
    public void setKeywords(ArrayList<Keyword> keywords) {
        this.keywords = keywords;
    }

    /**
     * An accessor that grabs the preferred semester
     * @return the preferred semester that course should be taken in based on the major maps
     */
    public int getPreferredSemester() {
        return preferredSemester;
    }

    /**
     * A mutator method for the user's preferred semester
     * @param preferredSemester the preferred semester that course should be taken in based on the major maps
     */
    public void setPreferredSemester(int preferredSemester) {
        this.preferredSemester = preferredSemester;
    }
    
    /**
     * Used by CourseList to make sure a course in its list
     * matches the given values
     * @param name the Designator of the Course (ex. CSCE)
     * @param number the number of the course (ex 111L, 350, etc.)
     * @param hours the number of credit hours for this course
     * @return true if this Course has these parameters, false otherwise
     */
    public boolean checkCourse(String name, String number, int hours) {
        return this.designator.toString().equalsIgnoreCase(name) && this.number.equalsIgnoreCase(number) && this.hours == hours;
    }
    /**
     * Used by CourseList to add the CourseRequirements after the Courses have been loaded
     */
    public void reloadCourseRequirements() {
        for (CourseRequisite requirement : requirements) {
            requirement.course = CourseList.getCourseByUUID(requirement.course.courseID);
        }
    }
    
}
