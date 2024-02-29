public abstract class DataConstants {
    /*---------------------------User--------------------------*/
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";
    protected static final String USER_EMAIL = "email";
    protected static final String USER_PASSWORD = "password";
    protected static final String USER_ID = "userId";
    protected static final String USER_USER_NAME = "userName";
    /*-------------------------Student-------------------------*/
    protected static final String STUDENT_FILE_NAME = "jsonFiles/students.json";
    protected static final String STUDENT_MAJOR = "major";
    protected static final String STUDENT_YEAR = "year";
    protected static final String STUDENT_GPA = "gpa";
    protected static final String STUDENT_SEMESTER_PLANS = "semesterPlans";
    protected static final String STUDENT_LEGAL_GUARDIANS = "legalGuardians";
    protected static final String STUDENT_ADVISOR = "advisor";
    protected static final String STUDENT_NOTES = "notes";
    protected static final String STUDENT_IS_HONORS = "isHonors";
    protected static final String STUDENT_HAS_SCHOLARSHIP = "hasScholarship";
    protected static final String STUDENT_GRADES = "studentGrades";
    /*-------------------------Advisor-------------------------*/
    protected static final String ADVISORS_FILE_NAME = "jsonFiles/advisors.json";
    protected static final String ADVISOR_STUDENTS = "students";
    protected static final String ADVISOR_STUDENT_ID = "studentId";

    /*--------------------------Major--------------------------*/
    protected static final String MAJOR_FILE_NAME = "jsonFiles/majors.json";
    protected static final String Major_ID = "majorId";
    protected static final String MAJOR_Name = "majorName";
    protected static final String MAJOR_REQUIRED_COURSES = "requiredCourses";
    protected static final String MAJOR_APPLICATION_ID = "applicationID";

    /*--------------------------RequirementSet--------------------------*/
    protected static final String REQUIREMENT_SET_TITLE = "title";
    protected static final String REQUIREMENT_SET_REQUIREMENTS = "requirements";
    protected static final String REQUIREMENT_SET_MINHOURS = "minHours";
    protected static final String REQUIREMENT_SET_MAXHOURS = "maxHours";    

    /*--------------------------Requirements--------------------------*/
    protected static final String REQUIREMENT_COURSE_ID = "courseId";
    protected static final String REQUIREMENT_GRADE = "grade";
    protected static final String REQUIREMENT_MODE = "mode";

    /*-----------------------------Course-----------------------------*/
    protected static final String COURSE_FILE_NAME = "jsonFiles/courses.json";
    protected static final String COURSE_ID = "id";
    protected static final String COURSE_DESIGNATOR = "designator";
    protected static final String COURSE_NUMBER = "number";
    protected static final String COURSE_HOURS = "hours";
    protected static final String COURSE_REQUIREMENTS = "requirements";
    protected static final String COURSE_KEYWORDS = "keywords";
    protected static final String COURSE_PREFERRED_SEMESTER = "preferredSemester";
    /*-----------------------------Keywords-----------------------------*/
    protected static final String KEYWORD_NAME = "keyword";


}