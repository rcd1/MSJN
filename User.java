import java.util.UUID;

public abstract class User {
    protected String firstName, lastName, email, password;
    protected String userName;
    protected UUID userID;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    // What is this method even for? It seems like UserList already handles logins for us
    public boolean login(String email, String password) {
        return false;
    }

    protected boolean checkPassword(String userInput) {
        return userInput.equals(password);
    }

    protected abstract void viewStudentProfile(Student student);

    /**
     * Used by UserList in order to check for username
     */
    public abstract String getUserName();

    /**
     * Used by UserList, checks if any user has these parameters
     * @param firstName User's first name
     * @param lastName User's last name
     * @param email User's email
     * @return true if this User contains these values, false otherwise
     */
    protected boolean checkCredentials(String firstName, String lastName, String email) {
        return this.firstName.equalsIgnoreCase(firstName) && this.lastName.equalsIgnoreCase(lastName) && this.email.equalsIgnoreCase(email);
    }
}