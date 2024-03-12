import java.util.ArrayList;

public class dataLoaderTest {
    public static void main(String[] args) {
        ArrayList<Major> test = DataLoader.getMajors();
        for (Major major : test) {
            System.out.println(major.getMajorName() + "\n" 
            + major.getMajorid() + "\n" 
            + major.getRequiredCourses());
        }
        
    }
}
