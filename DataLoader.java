import java.util.ArrayList;
import java.util.UUID;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {
    
    public DataLoader() {

    }

    public static ArrayList<Student> getStudents(){
        return new ArrayList<>();
    }
    public static ArrayList<Advisor> getAdvisors(){
        return new ArrayList<>();
    }
    public static ArrayList<Course> getCourses(){
        return new ArrayList<>();
    }

    public static ArrayList<Major> getMajors() {
        return new ArrayList<>();
    }
}
