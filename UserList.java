import java.util.ArrayList;

public class UserList {
    private static UserList userList;
    private ArrayList<Student> students;
    private ArrayList<Advisor> advisors;

    private UserList() {
        userList = this;
        students = DataLoader.getStudents();
        advisors = DataLoader.getAdvisors();
    }

    public static UserList getInstance() {
        if (userList == null) userList = new UserList();
        return userList;
    } 

    public User getUser(String firstName, String lastName, String email) {
        
        for (Student student : students) {
            if (student.checkCredentials(firstName, lastName, email)) {
                return student;
            }
        }
        for (Advisor advisor : advisors) {
            if (advisor.checkCredentials(firstName, lastName, email)) {
                return advisor;
            }
        }
        return null;

    }
}
