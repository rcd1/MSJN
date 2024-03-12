import java.util.ArrayList;
/**
 * An abstract class representing 
 * a container for multiple similar requirements of a college degree
 * 
 */
public abstract class RequirementSet implements Requirement {

    protected String title;
    protected ArrayList<Course> requiredCourses;
    protected Grade requiredGrade;
    
    

    public RequirementSet(String title, ArrayList<Course> requiredCourses, Grade requiredGrade) {
        this.title = title;
        this.requiredCourses = requiredCourses;
        this.requiredGrade = requiredGrade;
    }

    @Override
    public abstract boolean SatisfiesRequirement(Student student);
    /**
     * Get the Title of the RequirementSet
     * @return a String for the Title
     */
    public String getTitle() {
        return title;
    }
    /**
     * Set the Title for the RequirementSet
     * @param title a String representing the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Course> getRequiredCourses() {
        return requiredCourses;
    }

    public Grade getRequiredGrade() {
        return requiredGrade;
    }

    
    
    
    
}
