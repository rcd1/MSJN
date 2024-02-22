import java.util.UUID;

public abstract class User {
    protected String firstName, lastName, email, password;
    protected UUID userID;

    public User(String firstName, String lastName, String email, String password) {

    }

    public boolean login(String email, String password) {
        return false;
    }

    protected boolean checkPassword(String userInput) {
        return false;
    }

    protected abstract void viewStudentProfile(Student student);
}