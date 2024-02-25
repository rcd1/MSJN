import java.util.ArrayList;
public class Advisor extends User {
    private ArrayList<Student> students;

    public Advisor(String firstName, String lastName, String email, String password){
        super(firstName, lastName, email, password);
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
    protected void viewStudentProfile(Student student) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewStudentProfile'");
    }
}
