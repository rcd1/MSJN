import java.util.ArrayList;
import java.util.UUID;
public class Advisor extends User {
    private ArrayList<Student> students;

    public Advisor(String firstName, String lastName, String email, String password, UUID userID){
        super(firstName, lastName, email, password, userID);
    }
    public boolean addStudent(Student student){
        return true;
    }
    public boolean removeStudent(Student student){
        return true;
    }
    public void addNote(Student student, String note){

    }
    public void addAdvisor(Student student){
        
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    protected void viewStudentProfile(Student student) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewStudentProfile'");
    }
}
