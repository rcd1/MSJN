import java.util.UUID;
import java.util.ArrayList;
public class Course {
    private UUID courseID;
    private Designator designator;
    private int number;
    private int hours;
    private ArrayList<Requirement> requirements;
    private ArrayList<Keyword> keywords;
    private int preferredSemester;

    public Course (String name, String number, Requirement requirement, ArrayList<Keyword> keywords, int preferredSemester) {

    }
}
