import java.util.ArrayList;

public class SemesterPlan {
    private ArrayList<Course> courses;
    private int hours;
    
    
    private int calculateHours() {
        int sum = 0;
        for (Course course : courses) {
            sum += course.getHours();
        }
        return sum;
    }


    public SemesterPlan() {
        courses = new ArrayList<>();
        hours = 0;
    }

    
    public SemesterPlan(ArrayList<Course> courses) {
        this.courses = courses;
        hours = calculateHours();
    }


    public SemesterPlan(ArrayList<Course> courses, int hours) {
        this.courses = courses;
        this.hours = hours;
    }

    public boolean addCourse(Course course) {
        if (courses.contains(course) || calculateHours() > 18) return false;
        courses.add(course);
        if (calculateHours() > 18) {
            courses.remove(course);
            return false;
        }
        return true;
    }

    public boolean removeCourse(Course course) {
        return courses.remove(course);
    }

    

    
}
