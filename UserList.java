import java.util.ArrayList;
import java.util.UUID;

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

    public User getUser(String email, String password) {
        for (Student student : students) {
            if (student.getEmail().equals(email) && student.getPassword().equals(password)) {
                return student;
            }
        }
        for (Advisor advisor : advisors) {
            if (advisor.getEmail().equals(email) && advisor.getPassword().equals(password)) {
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

    //Could be improved by using methods inside the enum like in state design pattern
    //Need to add new overloaded constructor for the following two classes
    public User addUser(String firstName, String lastName, String email, String password, UserType type) {
        User user = null;
        UUID uuid = UUID.randomUUID();
        if(type == UserType.STUDENT) {
            user = new Student(firstName, lastName, email, password, uuid);
        } else if(type == UserType.ADVISOR) {
            user = new Advisor(firstName, lastName, email, password, uuid);
        }
        return user;
    }
}
