import java.util.UUID;
/**
 * The class that the UserList will go to find the student and advisor loginning
 * Also the clas the student and advisor will be inheriting
 */
public abstract class User {
    protected String firstName, lastName, email, password;
    protected UUID userID;

    /**
     * 
     * @param firstName The first name of user 
     * @param lastName The last name of user
     * @param email The email of user 
     * @param password The password of user
     * @param userID The ID for the user 
     */
    public User(String firstName, String lastName, String email, String password, UUID userID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userID = userID;
    }

    /**
     * An accessor method for the user's email
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * An accessor method of the user's password 
     * @return the password of the user
     */
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