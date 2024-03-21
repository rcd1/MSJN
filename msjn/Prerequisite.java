package msjn;
/**
 * The Prerequisite class is used for students 
 */
public class Prerequisite extends CourseRequisite {

    /**
     * The attributes that are inherited fron the Course Requisite 
     * @param course
     * @param grade 
     */
    public Prerequisite(Course course, Grade grade) {
        super(course, grade);
    }

    /**
     * A boolean statement used to check to see if the student satisfies requirements
     */
    public boolean SatisfiesRequirement(Student student) {
        return true;
    }
    
}
