import java.util.UUID;
import java.util.ArrayList;

public class Major {
 private UUID majorid;
 private String majorName;
 private RequirementSet requiredCourses;
 private ApplicationID applicationID;


public Major(){

}

protected void addCourse(Course course){

}

protected void removeCourse(Course course){


}
protected boolean changeApplicationID(int choice){
    return true;    
}

/**
 * Used by MajorList, checks if there is a Major that matches the parameters
 * @param majorName the name of the Major
 * @return true if the Major contains the specified name, false otherwise
 */
public boolean checkMajor(String majorName) {
    return this.majorName.equalsIgnoreCase(majorName);
}

}


