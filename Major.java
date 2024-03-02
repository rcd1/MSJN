import java.util.UUID;

public class Major {
 private UUID majorid;
 private String majorName;
 private RequirementSet requiredCourses;
 private ApplicationID applicationID;



public Major(UUID majorid, String majorName, RequirementSet requiredCourses, ApplicationID applicationID) {
    this.majorid = majorid;
    this.majorName = majorName;
    this.requiredCourses = requiredCourses;
    this.applicationID = applicationID;
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

public UUID getMajorid() {
    return majorid;
}

public String getMajorName() {
    return majorName;
}

public RequirementSet getRequiredCourses() {
    return requiredCourses;
}

public ApplicationID getApplicationID() {
    return applicationID;
}

}


