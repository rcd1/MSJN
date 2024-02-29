import java.util.UUID;

public abstract class User {
    protected String firstName, lastName, email, password;
    protected UUID userID;

    public User(UUID userID) {
        this.userID = userID;
    }

    public User(String firstName, String lastName, String email, String password, UUID userID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    protected abstract void viewStudentProfile(Student student);

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