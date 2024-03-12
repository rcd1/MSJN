public class MajorRequirement implements Requirement {
    private Course course;
    private Grade grade;

    
    
    public MajorRequirement(Course course, Grade grade) {
        this.course = course;
        this.grade = grade;
    }

    


    @Override
    public boolean SatisfiesRequirement(Student student) {
        return true;
    }
    
}
