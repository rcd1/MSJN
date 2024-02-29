import java.util.ArrayList;
import java.util.UUID;
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
        return user = userList.getUser(email, password);
    }

    /**
     * The user will become null once they log out of the system
     */
    public void logout() {
        user = null;
    }

    public void addCourseToStudent(Administrator administrator, Course course) {
        administrator.addCourseToStudent(administrator, course);
    }

    public void removeCourseFromStudent(Administrator administrator, Course course) {
        administrator.removeCourseFromStudent(administrator, course);
    }
    
    public void addCourse(Student student, Course course) {
        student.addCourse(course);
    }

    public void removeCourse(Student student, Course course) {
        student.removeCourse(course);
    }

    public User createAccount(String firstName, String lastName, String email, String password, UserType type) {
        return user = userList.addUser(firstName, lastName, email, password, type);
    }

    public ArrayList<Course> getAllCourses() {
        return courseList.getAllCourses();
    }

    public ArrayList<Course> findCourses(String keyword) {
        return courseList.findCourses(keyword);
    }

    public ArrayList<Course> getCourseByUUID(UUID courseID) {
        return getCourseByUUID(courseID);
    }

    public ArrayList<Major> getMajor(String majorName) {
        return majorList.getMajor();
    }
}

