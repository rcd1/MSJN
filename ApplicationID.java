public enum ApplicationID{
    Cybersecurity(1), 
    Linguistics(2), 
    ArtifiicalIntelligence(3);

    private int number;

    ApplicationID(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static ApplicationID getApplicationIDByNumber(int number) {
        switch (number) {
            case 1:
            return Cybersecurity;
            case 2:
            return Linguistics;
            case 3:
            return ArtifiicalIntelligence;
            default:
            return Cybersecurity;
        }
    }
}
