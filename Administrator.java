import java.util.ArrayList;
public class Administrator extends User{
    private ArrayList<Student> students;
    private ArrayList<Advisor> advisors;
    
    public Administrator (String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }

    private boolean addCourse(Course course) {
        return true;
    }

    private boolean removeCourse(Course course) {
        return true;
    }

    private boolean addStudentCourse(Student student, Course course) {
        return true;
    }

    private boolean addStudentGrade(Student student, Course course, Grade grade) {
        return true;

    }

    private boolean updateStudentGrade(Student student, Course course, Grade grade) {
        return true;
    }

    @Override
    protected void viewStudentProfile(Student student) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewStudentProfile'");
    }
}
