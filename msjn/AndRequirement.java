package msjn;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * A class representing a degree requirement where all
 * courses in the list of courses must be completed to satisfiy the requirement
 */
public class AndRequirement extends RequirementSet{
    
    public AndRequirement(ArrayList<Course> courses, Grade requiredGrade) {
        super(courses, requiredGrade);
        //TODO Auto-generated constructor stub
    }

    public AndRequirement(String title, ArrayList<Course> courses, Grade requiredGrade) {
        super(title, courses, requiredGrade);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean SatisfiesRequirement(Student student) {
        if(requiredCourses.size() == 0) {
            return true;
        }
        HashMap<Course, Grade> grades = student.getStudentGrades();
        for(Course course : requiredCourses) {
            Grade grade = grades.get(course);
            if(grade == null || grade.getPointValue() < requiredGrade.getPointValue()) {
                return false;
            }
        }
        return true;
    }
    
}
