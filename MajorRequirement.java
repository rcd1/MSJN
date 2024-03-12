import java.util.ArrayList;

public class MajorRequirement implements Requirement {
    private String title;
    private int minHours;
    private int maxHours;
    private ArrayList<RequirementSet> acceptableCourseSets; 

    public MajorRequirement(String title, int minHours, int maxHours, ArrayList<RequirementSet> acceptableCourseSets) {
        this.title = title;
        this.minHours = minHours;
        this.maxHours = maxHours;
        this.acceptableCourseSets = acceptableCourseSets;
    }

    

    @Override
    public boolean SatisfiesRequirement(Student student) {
        return true;
    }



    public String getTitle() {
        return title;
    }



    public int getMinHours() {
        return minHours;
    }



    public int getMaxHours() {
        return maxHours;
    }



    public ArrayList<RequirementSet> getAcceptableCourseSets() {
        return acceptableCourseSets;
    }
    
}
