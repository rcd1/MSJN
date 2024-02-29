public enum UserType {
    STUDENT("Student"),
    ADVISOR("Advisor");

    private String phrase;

    private UserType(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }
}
