import java.util.UUID;
/**
 * The class that the UserList will go to find the student and advisor loginning
 * Also the clas the student and advisor will be inheriting
 */
public abstract class User {
    protected String firstName, lastName, email, password;
    protected UUID userID;

    public User(UUID userID) {
        this.userID = userID;
    }

    /**
     * The mutator (setter) method for the User class
     * @param firstName User's first name 
     * @param lastName User's last name
     * @param email User's email
     * @param password User's password
     * @param userID User's userID
     */
    public User(String firstName, String lastName, String email, String password, UUID userID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userID = userID;
    }

    /**
     * An accessor (getter) class for the User's first name
     * @return User's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * An accessor (getter) class for the User's last name
     * @return User's last name
     */
    public String getLastName() {
        return lastName;
    }

     /**
     * An accessor (getter) class for the User's last name
     * @return User's UserID
     */
    public UUID getUserID() {
        return userID;
    }

     /**
     * An accessor (getter) class for the User's email
     * @return User's email
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

    private void resetPassword(String newPassword) {
        
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
