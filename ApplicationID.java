/**
 * An enumeration class for the Application Area
 */
public enum ApplicationID{
    /**
     * assigning a number to each application area 
     */
    Undeclared(0),
    Cybersecurity(1), 
    Linguistics(2), 
    ArtifiicalIntelligence(3);

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
     * Otherwise, the set default will be Undeclared.
     */
    public static ApplicationID getApplicationIDByNumber(int number) {
        switch (number) {
            case 0:
            return Undeclared;
            case 1:
            return Cybersecurity;
            case 2:
            return Linguistics;
            case 3:
            return ArtifiicalIntelligence;
            default:
            return Undeclared;
        }
    }
}
