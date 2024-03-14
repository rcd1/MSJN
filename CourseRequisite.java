public abstract class CourseRequisite implements Requirement {
    /**
     * The attributes of the Course Requisite Class
     */
    protected Course course;
    protected Grade grade;

    /**
     * The mutator (setter) method for the Course Requisite 
     * @param course The grade of the Course Requisite 
     * @param grade the grade of the Course Requisite 
     */
    public CourseRequisite(Course course, Grade grade) {
        this.course = course;
        this.grade = grade;
    }

    /**
     * An accessor (getter) method for course
     * @return courses
     */
    public Course getCourse() {
        return course;
    }

    /**
    * An accessor (setter) method for grade
    * @return grade 
    */
    public Grade getGrade() {
        return grade;
    }

    /**
     * A boolean method that checks to see if the student has
     * satisfied the requirements of the course 
     */
    public abstract boolean SatisfiesRequirement(Student student);

    /**
     * This method loads the course by having the UUID access the courseID from the json file
     */
    public void reloadCourse() {
        course = CourseList.getCourseByUUID(course.getCourseID());
    }
    
}
