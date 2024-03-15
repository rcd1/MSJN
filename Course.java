import java.util.UUID;
import java.util.ArrayList;
/*
 * The attributes of the course class 
 */
public class Course {
    private UUID courseID;
    private Designator designator;
    private String number;
    private int hours;
    private ArrayList<RequirementSet> prerequisites;
    private ArrayList<RequirementSet> corequisites;
    private ArrayList<Keyword> keywords;
    private ArrayList<SemesterOffered> semestersOffered;
    private int preferredSemester;

    
    /**
     * For DataLoader, I won't be able to fully create requirements the same passthrough I create the courses, so we get a dummy course to fill in
     * @param courseID ID of the course 
     */
    public Course(UUID courseID) {
        this.courseID = courseID;
    }

    /**
     * The setter method for the Course's parameters.
     */
    public Course(UUID courseID, Designator designator, String number, int hours,
            ArrayList<RequirementSet> prerequisites, ArrayList<RequirementSet> corequisites,
            ArrayList<Keyword> keywords, ArrayList<SemesterOffered> semestersOffered, int preferredSemester) {
        this.courseID = courseID;
        this.designator = designator;
        this.number = number;
        this.hours = hours;
        this.prerequisites = prerequisites;
        this.corequisites = corequisites;
        this.keywords = keywords;
        this.semestersOffered = semestersOffered;
        this.preferredSemester = preferredSemester;
    }


    public UUID getCourseID() {
        return courseID;
    }


    public void setCourseID(UUID courseID) {
        this.courseID = courseID;
    }


    public Designator getDesignator() {
        return designator;
    }


    public void setDesignator(Designator designator) {
        this.designator = designator;
    }


    public String getNumber() {
        return number;
    }


    public void setNumber(String number) {
        this.number = number;
    }


    public int getHours() {
        return hours;
    }


    public void setHours(int hours) {
        this.hours = hours;
    }


    


    public ArrayList<Keyword> getKeywords() {
        return keywords;
    }

    /**
     * A mutator method for the user class
     * @param keywords The code of the courses such as the Carolina Cores and Honors Courses
     */
    public void setKeywords(ArrayList<Keyword> keywords) {
        this.keywords = keywords;
    }

    /**
     * An accessor that grabs the preferred semester
     * @return the preferred semester that course should be taken in based on the major maps
     */
    public int getPreferredSemester() {
        return preferredSemester;
    }

    /**
     * A mutator method for the user's preferred semester
     * @param preferredSemester the preferred semester that course should be taken in based on the major maps
     */
    public void setPreferredSemester(int preferredSemester) {
        this.preferredSemester = preferredSemester;
    }
    
    /**
     * Used by CourseList to make sure a course in its list
     * matches the given values
     * @param name the Designator of the Course (ex. CSCE)
     * @param number the number of the course (ex 111L, 350, etc.)
     * @param hours the number of credit hours for this course
     * @return true if this Course has these parameters, false otherwise
     */
    public boolean checkCourse(String name, String number, int hours) {
        return this.designator==Designator.valueOf(name) && this.number.equalsIgnoreCase(number) && this.hours == hours;
    }

    public boolean checkCourse(String name, String number) {
        return this.designator.toString().equalsIgnoreCase(name) && this.number.equalsIgnoreCase(number);
    }
    /**
     * Used by CourseList to add the CourseRequirements after the Courses have been loaded
     */
    public void reloadCourseRequirements() {
        for (RequirementSet requirementSet : prerequisites) {
            ArrayList<Course> temp = new ArrayList<>();
            for (Course course : requirementSet.getRequiredCourses()) {
                temp.add(CourseList.getCourseByUUID(course.getCourseID()));
            }
            requirementSet.requiredCourses = temp;
        }
        for (RequirementSet requirementSet : corequisites) {
            ArrayList<Course> temp = new ArrayList<>();
            for (Course course : requirementSet.getRequiredCourses()) {
                temp.add(CourseList.getCourseByUUID(course.getCourseID()));
            }
            requirementSet.requiredCourses = temp;
        }
    }


    public void addKeyword(Keyword keyword) {
        this.keywords.add(keyword);
    }

    public ArrayList<RequirementSet> getPrerequisites() {
        return prerequisites;
    }




    public ArrayList<RequirementSet> getCorequisites() {
        return corequisites;
    }

    public ArrayList<SemesterOffered> getSemestersOffered() {
        return semestersOffered;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Course) {
            return this.courseID.equals(((Course) o).getCourseID());
        } else {
            return false;
        }
    }
    
}
