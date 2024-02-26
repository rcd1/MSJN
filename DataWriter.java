public class DataWriter {
    //Do you mean saveAdvisors
    //was save user but i changed it let me know if this is wrong
    public static void saveUsers(){
    }
    
    public static void saveAdvisors(Advisor advisor){

    }
    
    public static void saveStudents(Student student){

    }
    public static void saveAllStudents(List<Student> student){
        if (students == null || students.isEmpty()) {
            return; // No students to save
        }

        for (Student student : students) {
            saveStudent(student);
        }
    }
    public static void saveAllAdvisor(List<Advisor> advisor) {
        if (advisor == null || advisors.isEmpty()) {
            return; 
        }

        for (Advisor advisor : advisor) {
            saveAdvisors(this.saveAdvisors(advisor)); 
        }
    }
    public static void saveCourses(){

    }
    public static void saveMajors() {

    }
}
