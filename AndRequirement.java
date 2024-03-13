import java.util.ArrayList;
/**
 * A class representing a degree requirement where all
 * courses in the list of courses must be completed to satisfiy the requirement
 */
public class AndRequirement extends RequirementSet{
    
    public AndRequirement(ArrayList<Course> courses, Grade requiredGrade) {
        super(courses, requiredGrade);
        //TODO Auto-generated constructor stub
    }

    public AndRequirement(String title, ArrayList<Course> courses, Grade requiredGrade) {
        super(title, courses, requiredGrade);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean SatisfiesRequirement(Student student) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'SatisfiesRequirement'");
    }
    
}
