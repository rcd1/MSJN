/**
 * An enumeration class for the Application Area
 */
public enum ApplicationID{
    /**
     * assigning a number to each application area 
     */
    UNDECLARED(0),
    SCIENCE(1), 
    MATH(2), 
    DIGITALDESIGN(3),
    ROBOTICS(4),
    SPEECH(5);

    private int number;

    //An mutator (setter) method for the number values.
    ApplicationID(int number) {
        this.number = number;
    }

    /*
     * An accessor (getter) method for the number values.
     */
    public int getNumber() {
        return number;
    }

    /**
     * A method that grabs the application id based on the number that correlates to it.
     * @param number represents the differemt cases for the application areas
     * @return Undeclared, Cybersecurity, Linguistics, or Artificial Intelligence. 
     * Otherwise the set default will be Undeclared.
     */
    public static ApplicationID getApplicationIDByNumber(int number) {
        for(ApplicationID appid : ApplicationID.values()) {
            if(appid.getNumber() == number) {
                return appid;
            }
        }
        return UNDECLARED;
    }
}
