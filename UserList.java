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

    // When is this version of getUser ever called?
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

    // Should we make a method for "checkUsername" or something along those lines?
    public User getUser(String userName, String password) {
        for (Student student : students) {
            if (student.getUserName().equals(userName) && student.checkPassword(password)) {
                return student;
            }
        }
        for (Advisor advisor : advisors) {
            if (advisor.getUserName().equals(userName) && advisor.checkPassword(password)) {
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
}
