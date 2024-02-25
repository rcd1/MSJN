import java.util.UUID;
import java.util.ArrayList;
public class Course {
    private UUID courseID;
    private Designator designator;
    private String number;
    private int hours;
    private ArrayList<Requirement> requirements;
    private ArrayList<Keyword> keywords;
    private int preferredSemester;

    
    public Course(UUID courseID, Designator designator, String number, int hours, ArrayList<Requirement> requirements,
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


    public ArrayList<Requirement> getRequirements() {
        return requirements;
    }


    public void setRequirements(ArrayList<Requirement> requirements) {
        this.requirements = requirements;
    }


    public ArrayList<Keyword> getKeywords() {
        return keywords;
    }


    public void setKeywords(ArrayList<Keyword> keywords) {
        this.keywords = keywords;
    }


    public int getPreferredSemester() {
        return preferredSemester;
    }


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
    
    
}
