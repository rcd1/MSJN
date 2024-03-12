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
                Major major = rebuildMajor((JSONObject)studentJSONObject.get(STUDENT_MAJOR));
                int year = ((Long)studentJSONObject.get(STUDENT_YEAR)).intValue();
                double gpa = ((double)studentJSONObject.get(STUDENT_GPA));
                ArrayList<SemesterPlan> semesterPlans = rebuildSemesterPlans((JSONArray)studentJSONObject.get(STUDENT_SEMESTER_PLANS));
                ArrayList<LegalGuardian> legalGuardians = rebuildLegalGuardians((JSONArray)studentJSONObject.get(STUDENT_LEGAL_GUARDIANS));
                Advisor advisor = rebuildAdvisor((JSONObject)studentJSONObject.get(STUDENT_ADVISOR));
                ArrayList<String> notes = rebuildNotes((JSONArray)studentJSONObject.get(STUDENT_NOTES));
                boolean isHonors = ((boolean)studentJSONObject.get(STUDENT_IS_HONORS));
                boolean hasScholarship = ((boolean)studentJSONObject.get(STUDENT_HAS_SCHOLARSHIP));
                HashMap<Course,Grade> studentGrades = rebuildStudentGrades((JSONArray)studentJSONObject.get(STUDENT_GRADES));
                students.add(new Student(firstName, lastName, email, password, userID, major, year, gpa, semesterPlans, legalGuardians, advisor, notes, isHonors, hasScholarship, studentGrades));
            }
            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static ArrayList<SemesterPlan> rebuildSemesterPlans(JSONArray jsonArray) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rebuildSemesterPlans'");
    }


    private static Major rebuildMajor(JSONObject jsonObject) {
        MajorList majorList = MajorList.getInstance();
        UUID majorID = UUID.fromString((String)jsonObject.get(STUDENT_MAJOR));
        return majorList.getMajorByUUID(majorID);
    }

/*----------------------------------------------------------------------------*/


/*----------------------------------------------------------------------------*/

    public static ArrayList<Advisor> getAdvisors(){
        ArrayList<Advisor> advisors = new ArrayList<>();
        try {
            FileReader reader = new FileReader(ADVISORS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray advisorsJSON = (JSONArray)parser.parse(reader);
            for (Object i : advisorsJSON) {
                JSONObject advisorJsonObject = (JSONObject)i;
                UUID advisorID = UUID.fromString((String)advisorJsonObject.get(USER_ID));
                String firstName = (String)advisorJsonObject.get(USER_FIRST_NAME);
                String lastName = (String)advisorJsonObject.get(USER_LAST_NAME);
                String email = (String)advisorJsonObject.get(USER_EMAIL);
                String password = (String)advisorJsonObject.get(USER_PASSWORD);
                ArrayList<Student> students = rebuildStudents((JSONArray)advisorJsonObject.get(ADVISOR_STUDENTS));
                advisors.add(new Advisor(firstName, lastName, email, password, advisorID, students));
            }
            return advisors;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static ArrayList<Student> rebuildStudents(JSONArray jsonArray) {
        ArrayList<Student> students = new ArrayList<>();
        for (Object i : jsonArray) {
            JSONObject studentJSON = (JSONObject)i;
            UUID studentID = UUID.fromString((String)studentJSON.get(ADVISOR_STUDENT_ID));
            students.add(new Student(studentID));
        }
        return students;
    }



/*----------------------------------------------------------------------------*/

  


public static ArrayList<Course> getCourses(){
    ArrayList<Course> courses = new ArrayList<>();

    try {
        FileReader reader = new FileReader(COURSE_FILE_NAME);
        JSONParser parser = new JSONParser();
        JSONArray coursesJSON = (JSONArray)parser.parse(reader);
        for (Object i : coursesJSON) {
            JSONObject courseJSONObject = (JSONObject)i;
            UUID courseId = UUID.fromString((String)courseJSONObject.get(COURSE_ID));
            Designator designator = Designator.valueOf((String)courseJSONObject.get(COURSE_DESIGNATOR));
            String number = (String)courseJSONObject.get(COURSE_NUMBER);
            Long hoursTemp = ((Long)courseJSONObject.get(COURSE_HOURS));
            int hours = hoursTemp.intValue();
            ArrayList<CourseRequisite> requirements = rebuildCourseRequirements((JSONArray)courseJSONObject.get(COURSE_REQUIREMENTS));
            ArrayList<Keyword> keywords = rebuildKeywords((JSONArray)courseJSONObject.get(COURSE_KEYWORDS));
            Long preferredSemesterTemp = ((Long)courseJSONObject.get(COURSE_PREFERRED_SEMESTER));
            int preferredSemester = preferredSemesterTemp.intValue();

            courses.add(new Course(courseId, designator, number, hours, requirements, keywords, preferredSemester));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return courses;
}


private static ArrayList<CourseRequisite> rebuildCourseRequirements(JSONArray jsonArray) {
    ArrayList<CourseRequisite> requirements = new ArrayList<>();
    for (Object i : jsonArray) {
        JSONObject requirementJsonObject = (JSONObject)i;
        CourseType mode = CourseType.valueOf((String)requirementJsonObject.get(REQUIREMENT_MODE));
        Course course = new Course(UUID.fromString((String)requirementJsonObject.get(REQUIREMENT_COURSE_ID)));
        Grade grade = Grade.valueOf((String)requirementJsonObject.get(REQUIREMENT_GRADE));
        switch (mode) {
            case c:
            requirements.add(new Corequisite(course, grade));
            break;
            case p:
            requirements.add(new Prerequisite(course, grade));
            break;
            case pc:
            requirements.add(new Prerequisite(course, grade));
            requirements.add(new Corequisite(course, grade));
            break;
        }
    }
    return requirements;
}


private static Keyword rebuildKeyword(JSONObject keywordJSONObject) {
    return Keyword.valueOf((String)keywordJSONObject.get(KEYWORD_NAME));
}



private static ArrayList<Keyword> rebuildKeywords(JSONArray jsonArray) {
    ArrayList<Keyword> keywords = new ArrayList<>();
    for (Object object : jsonArray) {
        JSONObject keywordJSONObject = (JSONObject)object;
        keywords.add(rebuildKeyword(keywordJSONObject));
    }
     return keywords;
}




/*----------------------------------------------------------------------------*/

    /**
     * Imagine the Requirements like a Book. Books are broken into three objects: Book, 
     * Chapter, and Page. Rather than a Book being an ArrayList<Page> we make the Book 
     * an ArrayList<Chapter> and Chapter an ArrayList<Page>, otherwise there would 
     * be no easy way to differentiate between Books and Chapters, we'd be lost in recursion.
     * 📕
     * @return nothing good I'm sure
     */
    public static ArrayList<Major> getMajors() {
        ArrayList<Major> majors = new ArrayList<>();
        try {
            FileReader reader = new FileReader(MAJOR_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray majorsJSON = (JSONArray)parser.parse(reader);
            for (Object i : majorsJSON) {
                JSONObject majorObject = (JSONObject)i;
                UUID majorid = UUID.fromString((String)majorObject.get(MAJOR_ID));
                String majorName = (String)majorObject.get(MAJOR_NAME);
                ArrayList<MajorRequirement> majorRequirements = rebuildMajorRequirements((JSONArray)majorObject.get(MAJOR_REQUIREMENTS));
                Long ApplicationIDNumber = ((Long)majorObject.get(MAJOR_APPLICATION_ID));
                ApplicationID applicationID = ApplicationID.getApplicationIDByNumber(ApplicationIDNumber.intValue());
                majors.add(new Major(majorid, majorName, majorRequirements, applicationID));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return majors;
    }


    private static ArrayList<MajorRequirement> rebuildMajorRequirements(JSONArray jsonArray) {
        ArrayList<MajorRequirement> majorRequirements = new ArrayList<>();
        for (Object i : jsonArray) {
            if (i != null) {
            JSONObject requirementJSON = (JSONObject)i;
            String title = (String)requirementJSON.get(MAJOR_REQUIREMENT_TITLE);
            Long minTemp = ((Long)requirementJSON.get(MAJOR_REQUIREMENT_MINHOURS));
            int minHours = minTemp.intValue();
            Long maxTemp = ((Long)requirementJSON.get(MAJOR_REQUIREMENT_MAXHOURS));
            int maxHours = maxTemp.intValue();
            ArrayList<RequirementSet> acceptableCourseSets = rebuildRequirementSets((JSONArray)requirementJSON.get(MAJOR_REQUIREMENT_ACCEPTABLE_COURSE_SETS));
            majorRequirements.add(new MajorRequirement(title, minHours, maxHours, acceptableCourseSets));
            }
        }
        return majorRequirements;
    }


    private static ArrayList<RequirementSet> rebuildRequirementSets(JSONArray jsonArray) {
        ArrayList<RequirementSet> acceptableCourseSets = new ArrayList<>();
        for (Object i : jsonArray) {
            JSONObject setJSON = (JSONObject)i;
            String title = (String) setJSON.get(REQUIREMENT_SET_TITLE);
            ArrayList<Course> requiredCourses = rebuildCoursesByUUIDs((JSONArray)setJSON.get(REQUIREMENT_SET_COURSES));
            Grade requiredGrade = Grade.valueOf((String)setJSON.get(REQUIREMENT_SET_GRADE));
            String mode = (String)setJSON.get(REQUIREMENT_SET_MODE);
            switch(mode) {
                case "a":
                acceptableCourseSets.add(new AndRequirement(title, requiredCourses, requiredGrade));
                break;
                case "o":
                acceptableCourseSets.add(new OrRequirement(title, requiredCourses, requiredGrade));
                break;
            }             
        }
        return acceptableCourseSets;
    }


    private static ArrayList<Course> rebuildCoursesByUUIDs(JSONArray jsonArray) {
        ArrayList<Course> requiredCourses = new ArrayList<>();
        CourseList courseList = CourseList.getInstance();
        for (Object i : jsonArray) {
            JSONObject courseJSON = (JSONObject)i;
            UUID courseID = UUID.fromString((String)courseJSON.get(REQUIREMENT_SET_COURSE_ID));
            requiredCourses.add(courseList.getCourseByUUID(courseID));
        }
        return requiredCourses;
    }
}
