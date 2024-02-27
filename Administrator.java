import java.util.ArrayList;
public class Administrator extends User{
    private ArrayList<Student> students;
    private ArrayList<Advisor> advisors;
    
    public Administrator (String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }

    public boolean addCourseToStudent(Course course) {
        return true;
    }

    public boolean removeCourseFromStudent(Course course) {
        return true;
    }

    public boolean addStudentGrade(Student student, Course course, Grade grade) {
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

    @Override
    public String getUserName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserName'");
    }
}
