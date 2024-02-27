import java.util.ArrayList;
/**
 * This class saves the user's data
 */
public class DataWriter extends DataConstants{
    //Do you mean saveAdvisors
    //was save user but i changed it let me know if this is wrong
    public static void saveUsers(){
    }
    
    public static void saveAdvisor(Advisor advisor){

    }
    
    public static void saveStudent(Student student){

    }
    
    public static void saveAllStudents(ArrayList<Student> students){
        if (students == null || students.isEmpty()) {
            return; // No students to save
        }

        for (Student student : students) {
            saveStudent(student);
        }
    }
    public static void saveAllAdvisor(ArrayList<Advisor> advisors) {
        if (advisors == null || advisors.isEmpty()) {
            return; 
        }

        for (Advisor advisor : advisors) {
            saveAdvisors(this.saveAdvisors(advisor)); 
        }
    }

    public static void saveCourses(){

    }
    public static void saveMajors() {

    }
}
