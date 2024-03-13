import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID; 
public class dataWriterTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CourseList test = CourseList.getInstance();
        System.out.println("We're making a course today: what's the subject?: ");
        UUID id = UUID.randomUUID();
        Designator subject = Designator.valueOf(input.nextLine().toUpperCase());
        System.out.println("The number?: ");
        String number = input.nextLine();
        System.out.println("The hours?: ");
        int hours = input.nextInt();
        ArrayList<RequirementSet> pre = new ArrayList<>();
        ArrayList<RequirementSet> co = new ArrayList<>();
        ArrayList<Keyword> words = new ArrayList<>();
        System.out.println("The preferred semester?: ");
        int preferredSemester = input.nextInt();
        test.AddCourse(new Course(id, subject, number, hours, pre, co, words, preferredSemester));
        test.logout();
    }
}
