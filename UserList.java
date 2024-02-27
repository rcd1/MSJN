import java.util.ArrayList;

public class UserList {
    private static UserList userList;
    private static ArrayList<Student> students;
    private static ArrayList<Advisor> advisors;

    public UserList() {
        userList = this;
        students = DataLoader.getStudents();
        advisors = DataLoader.getAdvisors();
    }

    public static UserList getInstance() {
        if (userList == null) userList = new UserList();
        return userList;
    } 

    // When is this version of getUser ever called? Might need to be removed
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

    public User getUser(String userName, String password) {
        for (Student student : students) {
            if (student.getUserName().equals(userName) && student.getPassword().equals(password)) {
                return student;
            }
        }
        for (Advisor advisor : advisors) {
            if (advisor.getUserName().equals(userName) && advisor.getPassword().equals(password)) {
                return advisor;
            }
        }
        return null;
    }

    public void addUser(User newUser) {
        if (newUser instanceof Student) {
            students.add((Student) newUser);
        } else if (newUser instanceof Advisor) {
            advisors.add((Advisor) newUser);
        } else {
            throw new IllegalArgumentException("Unsupported user type: " + newUser.getClass().getName());
        }
    }

    public User addUser(String user)
}
