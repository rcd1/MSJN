import java.util.ArrayList;
/**
 * An abstract class representing 
 * a container for multiple similar requirements of a college degree
 * 
 */
public abstract class RequirementSet implements Requirement {

    protected String title;
    protected ArrayList<Requirement> requirements;
    protected int minHours;
    protected int maxHours;
    
    /**
     * Create a RequirementSet
     * @param title The name of the RequirementSet
     * @param requirements all of the requirements that will satisfy the RequirementSet
     * @param minHours the minimum credit hours this RequirementSet can be completed in
     * @param maxHours the maximum credit hours this RequirementSet can be completed in
     */
    public RequirementSet(String title, ArrayList<Requirement> requirements, int minHours, int maxHours) {
        this.title = title;
        this.requirements = requirements;
        this.minHours = minHours;
        this.maxHours = maxHours;
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
    /**
     * Get all the Requirements in this RequirementSet
     * @return an ArrayList of all the Requirements for this RequirementSet
     */
    public ArrayList<Requirement> getRequirements() {
        return requirements;
    }
    /**
     * Set the requirements for this RequirementSet
     * @param requirements an ArrayList<Requirement> to be added to this RequirementSet
     */
    public void setRequirements(ArrayList<Requirement> requirements) {
        this.requirements = requirements;
    }
    /**
     * Get the minimum hours required to complete this RequirementSet
     * @return an int representing the minumum credit hours
     */
    public int getMinHours() {
        return minHours;
    }
    /**
     * Set the minimum hours to complete this RequirementSet
     * @param minHours the minimum amount of hours to complete the RequirementSet
     */
    public void setMinHours(int minHours) {
        this.minHours = minHours;
    }
    /**
     * Get the maximum amount of hours that can complete this RequirementSet
     * @return an int representing the maximum credit hours accepted
     */
    public int getMaxHours() {
        return maxHours;
    }
    /**
     * Set the maximum hours for this RequirementSet
     * @param maxHours
     */
    public void setMaxHours(int maxHours) {
        this.maxHours = maxHours;
    }
    
}
