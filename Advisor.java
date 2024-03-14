import java.util.ArrayList;
import java.util.UUID;
/**
 * The advisor class has an arrayList of students
 */
public class Advisor extends User {
    private ArrayList<Student> students;
    
    /**
     * The Advisor class is inheriting from parameters from the user.
     * @param firstName The first name of the advisor.
     * @param lastName The last name of the advisor.
     * @param email The email name of the advisor. 
     * @param password The password of the advisor.
     * @param userID The userID of the advisor.
     */
    public Advisor(String firstName, String lastName, String email, String password, UUID userID) {
        super(firstName, lastName, email, password, userID);
    }

    public Advisor(String firstName, String lastName, String email, String password, UUID userID, ArrayList<Student> students){
        super(firstName, lastName, email, password, userID);
        this.students = students;
    }

    /**
     * gets the students the advisor is advising from an arraylist of class Student.
     * @return the students the advisor is advising.
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * a boolean method that adds the student to the array list.
     * @param student the advisee
     * @return true
     */
    public boolean addStudent(Student student){
        return true;
    }

    /**
     * a boolean method that removes the student to the array list.
     * @param student the advisee
     * @return true 
     */
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
