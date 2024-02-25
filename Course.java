import java.util.UUID;
import java.util.ArrayList;
public class Course {
    private UUID courseID;
    private Designator designator;
    private int number;
    private String hours;
    private ArrayList<Requirement> requirements;
    private ArrayList<Keyword> keywords;
    private int preferredSemester;
    
    public Course(UUID courseID, Designator designator, int number, String hours, ArrayList<Requirement> requirements,
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
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

    
}
