/**
 * An enumeration class for the Application Area
 */
public enum ApplicationID{
    /**
     * assigning a number to each application area 
     */
    UNDECLARED("Undeclared",0),
    SCIENCE("Science",1), 
    MATH("Math",2), 
    DIGITALDESIGN("Digital Design", 3),
    ROBOTICS("Robotics", 4),
    SPEECH("Speech", 5);

    private int number;
    private String name;

    //An mutator (setter) method for the number values.
    ApplicationID(String name, int number) {
        this.name = name;
        this.number = number;
    }

    /*
     * An accessor (getter) method for the number values.
     */
    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    /**
     * A method that grabs the application id based on the number that correlates to it.
     * @param number represents the differemt cases for the application areas
     * @return An enum value from ApplicationID if the number is valid 
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
