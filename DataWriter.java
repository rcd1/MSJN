import java.util.ArrayList;
/**
 * This class saves the user's data
 */
public class DataWriter extends DataConstants{
    //Do you mean saveAdvisors
    //was save user but i changed it let me know if this is wrong
    public static void saveUsers(){
    }
    
    public static void saveAdvisors(Advisor advisor){

    }
    
    public static void saveStudents(Student student){

    }
    
    public static void saveAllStudents(ArrayList<Student> students){
        if (students == null || students.isEmpty()) {
            return; // No students to save
        }

        for (Student student : students) {
            saveStudents(student);
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
