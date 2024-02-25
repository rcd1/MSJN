public class Prerequisite extends CourseRequisite {

    public Prerequisite(Course course, Grade grade) {
        super(course, grade);
    }

    public boolean SatisfiesRequirement(Student student) {
        return true;
    }
    
}
