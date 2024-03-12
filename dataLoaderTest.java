import java.util.ArrayList;

public class dataLoaderTest {
    public static void main(String[] args) {
        ArrayList<Major> test = DataLoader.getMajors();
        for (Major major : test) {
            System.out.println(major.getMajorName() + "\n" 
            + major.getMajorid() + "\n" 
            + major.getApplicationID());
            for (MajorRequirement requirement : major.getMajorRequirements()) {
                System.out.println(requirement.getTitle() + "\n"
                + requirement.getMinHours());
                for (RequirementSet req : requirement.getAcceptableCourseSets()) {
                    System.out.println(req.getTitle() + "\n"
                    + req.getRequiredGrade());
                }
            }
        }
        
    }
}
