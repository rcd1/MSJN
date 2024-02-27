import java.util.ArrayList;
import java.util.UUID;

public class CourseList {
    private static CourseList courseList;
    private static ArrayList<Course> courses;

    public CourseList() {
        courseList = this;
        courses = DataLoader.getCourses();
    }

    public static CourseList getInstance() {
        if (courseList == null) courseList = new CourseList();
        return courseList;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public Course getCourse(String name, String number, int hours) {
        for (Course course : courses) {
            if (course.checkCourse(name, number, hours))
            return course;
        }
        return null;
    }

    public ArrayList<Course> findCourses(String keyword) {
        ArrayList<Course> foundCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getKeywords().contains(keyword)) {
                foundCourses.add(course);
            }
        }
        return foundCourses;
    }

    /**
     * Find a course with a specific UUID
     * @param courseID the UUID of the course
     * @return the course if found, null otherwise
     */
    public static Course getCourseByUUID(UUID courseID) {
        for (Course i : courses) {
            if (courseID.equals(i.getCourseID())) return i;
        }
        System.out.println("CourseList.java could not find course with UUID " + courseID);
        return null;
    }
}
