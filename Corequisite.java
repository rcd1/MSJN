public class Corequisite extends CourseRequisite {

    public Corequisite(Course course, Grade grade) {
        super(course, grade);
    }

    @Override
    public boolean SatisfiesRequirement(Student student) {
        return true;
    }
    
}
