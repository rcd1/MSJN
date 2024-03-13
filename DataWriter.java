import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class DataWriter extends DataConstants{

    //puts user list into JSON files
    public static void saveUsers(){
        UserList users = UserList.getInstance();
        ArrayList<User> userList= users.getUser();

        JSONArray jsonUsers= new JSONArray();

        for(int i=0; i< userList.size();i++){
            jsonUsers.add(getUserJSON(userList.get(i)));

        }
        try (FileWriter File = new FileWriter(USER_FILE_NAME)){
            file.write(jsonUsers.toJSONString());
            file.flush();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

        public static JSONObject getUserJSON(User user){
            JSONObject userDetails = new JSONObject();

            userDetails.put(USER_EMAIL, user.getEmail());
            userDetails.put(USER_FIRST_NAME, user.getFirstName());
            userDetails.put(USER_ID, user.getID().toString());
            userDetails.put(USER_LAST_NAME, user.getLastName());
            userDetails.put(USER_PASSWORD, user.getPassword());

            return userDetails;
        }

        public static void saveAllAdvisors(){
            Advisor advisors = Advisor.getInstance();
            ArrayList<Advisor> Advisor = advisors.getStudentAdvisor();
            JSONArray jsonMajors = new JSONArray();

            for(int i =0; i< Advisor.size(); i++){
                jsonAdvisors.add(getAdvisorJSON(Advisor.get(i)));

            }
            try (FileWriter file = new FileWriter(ADVISORS_FILE_NAME)) { 
                file.write(jsonCourses.toJSONString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public static JSONObject getAdvisorJSON(Advisor advisor){
            JSONObject advisorDetails = newJSONObject();
            advisorDetails.put(ADVISOR_STUDENTS, advisor.getAdvisorStudent());
            advisorDetails.put(ADVISORS_FILE_NAME, advisor.getAdvisorFileName());
            advisorDetails.put(ADVISOR_STUDENT_ID, advisor.getAdvisorFileName());

            JSONArray advisorArray = new JSONArray();

            
        }
        public static void saveAllStudents(){
            Student students =Student.getInstance();
            ArrayList<Student> Student = students.getStudents();
            JSONArray jsonStudents = new JSONArray();

            for(int i=0;i< Student.size();i++){
                jsonStudents.add(getStudentJSON(Student.get(i)));
            }

            try (FileWriter file = new FileWriter(STUDENT_FILE_NAME)) { 
                file.write(jsonCourses.toJSONString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        
        //unfinished
        //Student details/info
        public static JSONObject getStudentJSON(Student student){
            JSONObject studentDetails = new JSONObject();
            studentDetails.put(STUDENT_ADVISOR, student.getStudentAdvisor());
            studentDetails.put(STUDENT_FILE_NAME, student.getStudentFileName());
            studentDetails.put(STUDENT_GPA, student.getStudentGPA());
            studentDetails.put(STUDENT_GRADES,student.getStudentGrades());
            studentDetails.put(STUDENT_HAS_SCHOLARSHIP, student.getStudentHasScholarship());
            studentDetails.put(STUDENT_IS_HONORS, student.getStudentIsHonors());
            studentDetails.put(STUDENT_LEGAL_GUARDIANS,student.getStudentLegalGuardian());
            studentDetails.put(STUDENT_MAJOR,student.getStudentMajor());
            studentDetails.put(STUDENT_NOTES,student.getStudentNotes());

            JSONArray studentArray = new JSONArray();
            for(Student s : sp.getStudent)
                studentDetails.put(STUDENT_ADVISOR, s.getStudentAdvisor());

            

        }
        //Course Details/Info
        public static void saveCourses(){
            CourseList courses = CourseList.getInstance();
            ArrayList<Course> courseList = courses.getCourses();
            JSONArray jsonCourses = new JSONArray();

            for(int i=0; i< courseList.size(); i++){
                jsonCourses.add(getCourseJSON(courseList.get(i)));
            }

            try(FileWriter file = new FileWriter(COURSE_FILE_NAME)){
                file.write(jsonCourses.toJSONString());
                file.flush();
            } catch(IOException e){
                e.printStackTrace();
            }
        }


        /**
     * Creates a JSONObject from the given Course object.
     *
     * @param course the Course object to create the JSONObject from
     * @return the JSONObject created from the Course object
     */
        public static JSONObject getCourseJSON(Course course){
            JSONObject courseDetails = new JSONObject();
            courseDetails.put(COURSE_ID, course.getCourseID().toString());
            courseDetails.put(COURSE_DESIGNATOR, course.getDesignator().toString());
            courseDetails.put(COURSE_NUMBER, course.getNumber());
            courseDetails.put(COURSE_HOURS, course.getHours());
            courseDetails.put(COURSE_PREREQUISITES, buildCourseRequisitesJSON(course.getPrerequisites()));
            courseDetails.put(COURSE_PREREQUISITES, buildCourseRequisitesJSON(course.getCorequisites()));
            courseDetails.put(COURSE_PREFERRED_SEMESTER, course.getPreferredSemester());

        }

        private static JSONArray buildCourseRequisitesJSON(ArrayList<RequirementSet> prerequisites) {
            JSONArray requisiteArray = new JSONArray();
            for (RequirementSet requirementSet : prerequisites) {
                JSONObject objectPrerequisite = new JSONObject();
                objectPrerequisite.put(REQUIREMENT_SET_COURSES, buildCourseSetJSON(requirementSet.getRequiredCourses()));
                objectPrerequisite.put(REQUIREMENT_GRADE, requirementSet.getRequiredGrade());
                if (requirementSet instanceof AndRequirement) {
                    objectPrerequisite.put(REQUIREMENT_MODE, "a");
                } else if (requirementSet instanceof OrRequirement) {
                    objectPrerequisite.put(REQUIREMENT_MODE, "o");
                }
                requisiteArray.add(objectPrerequisite);
            }
            return requisiteArray;
        }
        
        private static JSONArray buildCourseSetJSON(ArrayList<Course> requiredCourses) {
            JSONArray courseArray = new JSONArray();
            for (Course course : requiredCourses) {
                JSONObject objectCourse = new JSONObject();
                objectCourse.put(REQUIREMENT_SET_COURSE_ID, course.getCourseID().toString());
                courseArray.add(objectCourse);    
            }
            return courseArray;

        }

        private static JSONArray buildCourseCorequisitesJSON(ArrayList<RequirementSet> corequisites) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'buildCourseCorequisiteJSON'");
        }

        

        public static void saveMajors(){
            MajorList majorList = MajorList.getInstance();
            ArrayList<Major> majors = majorList.getMajors();
            JSONArray jsonMajors = new JSONArray();

            for(int i=0; i< majorListajorList.size(); i++){
                jsonMajors.add(getMajorJSON(majors.get(i)));
            }

            try (FileWriter file = new FileWriter(MAJOR_FILE_NAME)) {
                file.write(jsonMajors.toJSONString());
                file.flush();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        
        public static JSONObject getMajorJSON(Major major){
            JSONObject majorDetails = new JSONObject();
            majorDetails.put(MAJOR_ID, major.getMajorid().toString());
            majorDetails.put(MAJOR_NAME, major.getMajorName().toString());
            majorDetails.put(MAJOR_REQUIREMENTS,major.getMajorRequirements());
            majorDetails.put(MAJOR_REQUIREMENT_TITLE, major.getMajorRequirements());
            majorDetails.put(MAJOR_REQUIREMENT_MINHOURS, major.getMajorRequirements());
            majorDetails.put(MAJOR_REQUIREMENT_MAXHOURS, major.getMajorRequirements());
            majorDetails.put(MAJOR_REQUIREMENT_ACCEPTABLE_COURSE_SETS, major.getMajorRequirements());
            majorDetails.put(MAJOR_APPLICATION_ID, major.getApplicationID().toString());

            return majorDetails;
        }


<<<<<<< HEAD
=======
    

>>>>>>> ab1b8d689724c8ce2a343a63f7aa3498e9b46d82
