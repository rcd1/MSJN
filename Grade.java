/**
 * An Enum representing the 
 */
public enum Grade {
    A("A",4.0),
    B_Plus("B+",3.5),
    B("B",3.0),
    C_Plus("C+", 2.5),
    C("C",2.0),
    D_Plus("D+",1.5),
    D("D",1.0),
    F("F",0.0),
    W("W", 0.0),
    WF("WF", 0.0);

    private final String letter;
    private final double pointValue;
    /**
     * Create a Grade Enum
     * @param letter the String representing the Grade
     * @param pointValue the number of points the Grade is worth
     */
    Grade(String letter, double pointValue) {
        this.letter = letter;
        this.pointValue = pointValue;
    }
    /**
     * Get the Grade in String format
     * @return the String representing the Grade
     */
    public String getLetter() {
        return letter;
    }
    /**
     * Return the Grade Point Value of the Grade
     * @return a double representing the number of points
     */
    public double getPointValue() {
        return pointValue;
    }
}