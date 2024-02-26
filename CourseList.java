import java.util.ArrayList;

public class CourseList {
    private static CourseList courseList;
    private ArrayList<Course> courses;

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
}
