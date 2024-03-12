import java.util.ArrayList;
/**
 * A Class representing a Degree requirement 
 * where one set of courses out of all the possible courses will satisfy
 * the entire requirement
 */
public class OrRequirement extends RequirementSet {
    

    
    
    public OrRequirement(String title, ArrayList<Course> courses, Grade requiredGrade) {
        super(title, courses, requiredGrade);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean SatisfiesRequirement(Student student) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'SatisfiesRequirement'");
    }
    
}
