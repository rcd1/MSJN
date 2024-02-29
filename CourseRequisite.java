public abstract class CourseRequisite implements Requirement {

    protected Course course;
    protected Grade grade;

    
    public CourseRequisite(Course course, Grade grade) {
        this.course = course;
        this.grade = grade;
    }


    public Course getCourse() {
        return course;
    }


    public Grade getGrade() {
        return grade;
    }

    
    public abstract boolean SatisfiesRequirement(Student student);

    public void reloadCourse() {
        course = CourseList.getCourseByUUID(course.getCourseID());
    }
    
}
