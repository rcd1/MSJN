import java.util.ArrayList;
/**
 * This facade class can be considered the central hub of the program
 * 
 */


public class DegreeFacade {
    private UserList userList;
    private User user;
    private CourseList courseList;
    private MajorList majorList;

    public DegreeFacade() {
        userList = UserList.getInstance();
        courseList = CourseList.getInstance();
        majorList = MajorList.getInstance();
    }

    public User login(String email, String password) {
        return userList.getUser(email, password);
    }

    /**
     * The user will become null once they log out of the system
     */
    public void logout() {
        user = null;
    }

    public void addCourseToStudent(Administrator administrator, Course course) {
        administrator.addCourseToStudent(course);
    }

    public void removeCourseFromStudent(Administrator administrator, Course course) {
        administrator.removeCourseFromStudent(course);
    }
    
    public void addCourse(Student student, Course course) {
        student.addCourse(course);
    }

    public void removeCourse(Student student, Course course) {
        student.removeCourse(course);
    }

    public User createAccount(String firstName, String lastName, String email, String password) {
        User newUser = new User(firstName, lastName, email, password); //need to find a way to create new user, cant use abstract User class
        userList.addUser(newUser);
        return newUser;
    }

    public ArrayList<Course> getCourses() {
        return courseList.getCourses();
    }

    public ArrayList<Course> findCourses(String keyword) {
        return courseList.findCourses(keyword);
    }

    public ArrayList<Major> getMajor(String majorName) {
        return majorList.getMajor();
    }
}

