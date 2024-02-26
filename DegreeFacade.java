import java.util.ArrayList;

public class DegreeFacade {
    private UserList userList;
    private User user;
    private CourseList courseList;
    private MajorList majorList;

    public DegreeFacade() {
        userList = UserList.getInstance();
        courseList = CourseList.getInstance();
        majorList = new MajorList();
    }

    public User login(String userName, String password) {
        user = userList.getUser(userName, password);
        return user;
    }

    public void logout() {
        user = null;
    }

    public void addCourse(Course course) {

    }

    public void removeCourse() {

    }

    public User createAccount(String firstName, String lastName, String email, String password) {
        User newUser = new User(firstName, lastName, email, password); //need to find a way to create new user, cant use abstract User class
        userList.addUser(newUser);
        return newUser;
    }

    public ArrayList<Course> getCourses() {

    }

    public ArrayList<Course> findCourses() {

    }

    public ArrayList<Course> findCourses(String keyword) {
        
    }
}

