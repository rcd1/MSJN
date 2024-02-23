import java.util.ArrayList;
/**
 * A class representing a degree requirement where all
 * courses in the list of courses must be completed to satisfiy the requirement
 */
public class AndRequirement extends RequirementSet{
    /**
     * Create an AndRequirement
     @param title The name of the AndRequirement
     * @param requirements all of the requirements that will satisfy the AndRequirement
     * @param minHours the minimum credit hours this AndRequirement can be completed in
     * @param maxHours the maximum credit hours this AndRequirement can be completed in
     */
    public AndRequirement(String title, ArrayList<Requirement> requirements, int minHours, int maxHours) {
        super(title, requirements, minHours, maxHours);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean SatisfiesRequirement(Student student) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'SatisfiesRequirement'");
    }
    
}
