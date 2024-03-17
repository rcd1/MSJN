import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationUI {
    private Scanner scanner;
    private DegreeFacade application;
    private User user;

    public static void main(String[] args) {
        ApplicationUI test = new ApplicationUI();
        test.run();
    }

    public ApplicationUI() {
        scanner = new Scanner(System.in);
        application = new DegreeFacade();
    }

    public void run() {
        boolean running = true;
        while (running) {
            if (user == null) {
                displayMainMenu();
                String option = getUserOption().toLowerCase();
                switch (option) {
                    case "login":
                        login();
                        break;
                    case "create account":
                        createAccount();
                        break;
                    case "exit":
                        running = false;
                        application.exit();
                        break;
                    case "Scenarios":
                        displayScenarios();
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            } else {
                displayLoggedInMenu();
                String option = getUserOption().toLowerCase();
                switch (option) {
                    case "view semester plan":
                        displaySemesterPlan(user);
                        break;
                    case "logout":
                        saveUserData();
                        logout();
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            }
        }
        scanner.close();
    }

    // Display details
    private void displayMainMenu() {
        System.out.println("Welcome to DegreeWorks");
        System.out.println("Login");
        System.out.println("Create Account");
        System.out.println("Exit");
        System.out.print("Enter your choice: ");
    }

    private void displayLoggedInMenu() {
        System.out.println("Logged in as " + user.getFirstName() + " " + user.getLastName());
        System.out.println("View Semester Plan");
        System.out.println("Logout");
        System.out.print("Enter your choice: ");
    }

    private String getUserOption() {
        return scanner.nextLine();
    }

    // Login
    private void login() {
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        user = application.login(email, password);
        if (user != null) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed. Please check your username and password.");
        }
    }

    // Signup/CreateAcc
    private void createAccount() {
        System.out.println("Are you a student or advisor?");
        boolean isValid = false;
        UserType type = null;
        do {
            String typeInput = scanner.nextLine();
            if (typeInput.equalsIgnoreCase(UserType.STUDENT.getPhrase())) {
                type = UserType.STUDENT;
                isValid = true;
            } else if (typeInput.equalsIgnoreCase(UserType.ADVISOR.getPhrase())) {
                type = UserType.ADVISOR;
                isValid = true;
            }
        } while (!isValid);
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        user = application.createAccount(firstName, lastName, email, password, type);
        if (user != null) {
            System.out.println("Account successfully made.");
        } else {
            System.out.println("Failed to create account. Please check your information again");
        }
    }

    // logout
    private void logout() {
        user = null;
        application.logout();
        System.out.println("Logout successful.");
    }

    private void displaySemesterPlan(User user) {
        if (user instanceof Student) {
            ((Student) user).displaySemesterPlan();
            // edit semsterplan code
        } else if (user instanceof Advisor) {
            Advisor advisor = (Advisor) user;
            ArrayList<Student> advisedStudents = advisor.getStudents();
            System.out.println("Select a student to view their semester plan: ");
            for (int i = 0; i < advisedStudents.size(); i++) {
                Student student = advisedStudents.get(i);
                String fullName = student.getFirstName() + " " + student.getLastName();
                System.out.println((i + 1) + ". " + fullName);
            }
            String option = getUserOption();
            int choice = Integer.parseInt(option);
            if (choice >= 1 && choice <= advisedStudents.size()) {
                Student selectedStudent = advisedStudents.get(choice - 1);
                selectedStudent.displaySemesterPlan();
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private void saveUserData() {
        application.saveUserData(user);
    }
}
