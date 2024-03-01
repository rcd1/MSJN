import java.util.ArrayList;

public class dataLoaderTest {
    public static void main(String[] args) {
        ArrayList<Advisor> test = DataLoader.getAdvisors();
        for (Advisor advisor : test) {
            System.out.println(advisor.getEmail() + advisor.getFirstName() + advisor.getLastName());
            for (Student student : advisor.getStudents()) {
                System.out.println(student.getUserID());
                
            }
        }
    }
}
