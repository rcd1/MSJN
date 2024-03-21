package msjn;
/**
 * Courses meant to be taken alongside another course
 * It extends the CourseRequisite Class
 */
public class Corequisite extends CourseRequisite {
    /**
     * The parameters the Corequisite Class is inheriting from the CourseRequisite Class
     * @param course The designator and number of the course
     * @param grade The letter grade that the student currently have in the course
     */
    public Corequisite(Course course, Grade grade) {
        super(course, grade);
    }

    /**
     * If the student fulfill the criteria of the corequisite, 
     * the system will return true
     */
    @Override
    public boolean SatisfiesRequirement(Student student) {
        return true;
    }
    
}
