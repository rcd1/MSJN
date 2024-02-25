import java.util.ArrayList;
/**
 * A Class representing a Degree requirement 
 * where one set of courses out of all the possible courses will satisfy
 * the entire requirement
 */
public class OrRequirement extends RequirementSet {
    /**
     * Create an OrRequirement
     * @param title The name of the OrRequirement
     * @param requirements all of the requirements that will satisfy the OrRequirement
     * @param minHours the minimum credit hours this OrRequirement can be completed in
     * @param maxHours the maximum credit hours this OrRequirement can be completed in
     */
    public OrRequirement(String title, ArrayList<Requirement> requirements, int minHours, int maxHours) {
        super(title, requirements, minHours, maxHours);
        
    }

    @Override
    public boolean SatisfiesRequirement(Student student) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'SatisfiesRequirement'");
    }
    
}
