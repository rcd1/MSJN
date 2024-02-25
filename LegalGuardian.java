import java.util.ArrayList;

public class LegalGuardian extends User{
    
    private ArrayList<Student> students;

    public LegalGuardian(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }
    
    public void removeStudent(Student student) {

    }

    @Override
    protected void viewStudentProfile(Student student) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewStudentProfile'");
    }
}
