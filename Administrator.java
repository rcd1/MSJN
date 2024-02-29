import java.util.ArrayList;
import java.util.UUID;
public class Administrator extends User{
    private ArrayList<Student> students;
    private ArrayList<Advisor> advisors;
    
    public Administrator (String firstName, String lastName, String email, String password, UUID userID) {
        super(firstName, lastName, email, password, userID);
    }

    public boolean addCourseToStudent(Student student, Course course) {
        return true;
    }

    public boolean removeCourseFromStudent(Student student, Course course) {
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
