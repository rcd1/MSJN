import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class DataLoader2 extends DataConstants2{
    public static ArrayList<Course> getCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        try {
        FileReader reader = new FileReader("jsonFiles\\course.json");
        JSONParser parser = new JSONParser();
        JSONArray coursesJSON = (JSONArray)parser.parse(reader);
        for (Object i : coursesJSON) {
            JSONObject courseJSONObject = (JSONObject)i;
            UUID courseId = UUID.fromString((String)courseJSONObject.get(COURSE_UUID));
            Designator designator = Designator.valueOf((String)courseJSONObject.get(COURSE_SUBJECT));
            String number = (String)courseJSONObject.get(COURSE_NUMBER);
            String hoursTemp = ((String)courseJSONObject.get(COURSE_CREDIT_HOURS));
            String hoursTempTemp = "" + hoursTemp.charAt(0);
            int hours = Integer.valueOf(hoursTempTemp).intValue();
            ArrayList<RequirementSet> prerequisites = rebuildCoursePreRequirements((JSONArray)courseJSONObject.get(COURSE_PREREQUISITES));
            ArrayList<RequirementSet> corequisites = rebuildCourseCoRequirements((JSONArray)courseJSONObject.get(COURSE_COREQUISITES));
            ArrayList<Keyword> keywords = new ArrayList<>();
            // Long preferredSemesterTemp = ((Long)courseJSONObject.get(COURSE_PREFERRED_SEMESTER));
            ArrayList<SemesterOffered> semestersOffered = rebuildSemestersOffered((JSONArray)courseJSONObject.get(COURSE_SEMESTERS_OFFERED));
            Random rand = new Random();
            int preferredSemester = rand.nextInt(8)+1;

            courses.add(new Course(courseId, designator, number, hours, prerequisites, corequisites, keywords, semestersOffered, preferredSemester));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return courses;
    }

    public static ArrayList<String[]> getNameAndDescriptions() {
        ArrayList<String[]> nameAndDesc = new ArrayList<>();
        try {
        FileReader reader = new FileReader("jsonFiles\\course.json");
        JSONParser parser = new JSONParser();
        JSONArray coursesJSON = (JSONArray)parser.parse(reader);
        for (Object i : coursesJSON) {
            JSONObject courseJSONObject = (JSONObject)i;
            String name = (String)courseJSONObject.get(COURSE_NAME);
            String desc = (String)courseJSONObject.get(COURSE_DESCRIPTION);
            nameAndDesc.add(new String[]{name, desc});
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return nameAndDesc;
    }

    private static ArrayList<SemesterOffered> rebuildSemestersOffered(JSONArray jsonArray) {
        ArrayList<SemesterOffered> semestersOffered = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            semestersOffered.add(SemesterOffered.valueOf((String)jsonArray.get(i)));
        }
        return semestersOffered;
    }
    

    private static ArrayList<RequirementSet> rebuildCourseCoRequirements(JSONArray jsonArray) {
        ArrayList<RequirementSet> requirements = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            ArrayList<Course> courses = fillWithBlankCourses(jsonArray);
            Grade minGrade = Grade.C;
            requirements.add(new AndRequirement(courses, minGrade));
        }
        return requirements;
    }

    private static ArrayList<RequirementSet> rebuildCoursePreRequirements(JSONArray jsonArray) {
        ArrayList<RequirementSet> requirements = new ArrayList<>();
        for (Object i : jsonArray) {
            JSONObject requirementJsonObject = (JSONObject)i;
            ArrayList<Course> requiredCourses = fillWithBlankCourses((JSONArray)requirementJsonObject.get(COURSE_REQUIREMENT_COURSE_OPTIONS));
            String gradeS = (String)requirementJsonObject.get(COURSE_REQUIREMENT_MIN_GRADE);
            Grade grade = Grade.valueOf(gradeS);
            requirements.add(new AndRequirement(requiredCourses, grade));      
        }
        return requirements;
    }
    
    
    private static ArrayList<Course> fillWithBlankCourses(JSONArray jsonArray) {
        ArrayList<Course> courses = new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                UUID courseID = UUID.fromString((String)jsonArray.get(i));
                courses.add(new Course(courseID));
            }
            return courses;
    }
}
    
