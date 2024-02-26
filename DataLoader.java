import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {
/*--------------------------------For Students--------------------------------*/
    /**
     * Convert students.json into an ArrayList<Students>
     * @return the list of all saved students
     */
    public static ArrayList<Student> getStudents(){
        ArrayList<Student> students = new ArrayList<>();

        try {
            FileReader reader = new FileReader(STUDENT_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray studentsJSON = (JSONArray)parser.parse(reader);

            for (Object i : studentsJSON) {   
                JSONObject studentJSONObject = (JSONObject)i;
                UUID userID = UUID.fromString((String)studentJSONObject.get(USER_ID));
                String firstName = (String)studentJSONObject.get(USER_FIRST_NAME);
                String lastName = (String)studentJSONObject.get(USER_LAST_NAME);
                String email = (String)studentJSONObject.get(USER_EMAIL);
                String password = (String)studentJSONObject.get(USER_PASSWORD);
                Major major = rebuildMajor((JSONObject)studentJSONObject.get("majorId"));
                int year = ((Long)studentJSONObject.get(STUDENT_YEAR)).intValue();
                double gpa = ((double)studentJSONObject.get(STUDENT_GPA));
                ArrayList<SemesterPlan> semesterPlans = rebuildSemesterPlans((JSONArray)studentJSONObject.get(STUDENT_SEMESTER_PLANS));
                ArrayList<LegalGuardian> legalGuardians = rebuildLegalGuardians((JSONArray)studentJSONObject.get(STUDENT_LEGAL_GUARDIANS));
                Advisor advisor = rebuildAdvisor((JSONObject)studentJSONObject.get(STUDENT_ADVISOR));
                ArrayList<String> notes = rebuildNotes((JSONArray)studentJSONObject.get(STUDENT_NOTES));
                boolean isHonors = ((boolean)studentJSONObject.get(STUDENT_IS_HONORS));
                boolean hasScholarship = ((boolean)studentJSONObject.get(STUDENT_HAS_SCHOLARSHIP));
                HashMap<Course,Grade> studentGrades = rebuildStudentGrades((JSONArray)studentJSONObject.get(STUDENT_GRADES));
                students.add(new Student(firstName, lastName, email, password, major, year, gpa, semesterPlans, legalGuardians, advisor, notes, isHonors, hasScholarship, studentGrades));
            }
            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
