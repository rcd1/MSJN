import java.util.Scanner;

public class ApplicationUI {
    private Scanner scanner;
    private DegreeFacade application;
    private User user;

    public ApplicationUI() {
        scanner = new Scanner(System.in);
        application = new DegreeFacade();
    }
    
    public void run() {
        boolean running = true;
        while(running) {
            displayMainMenu();
            String option = getUserOption().toLowerCase();
            if ("login".equals(option)) {
                login();
            } else if ("logout".equals(option)) {
                logout();
            } else if ("create account".equals(option)) {
                createAccount();
            } else if ("exit".equals(option)) {
                running = false;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    //Display details
    private void displayMainMenu() {
        System.out.println("Welcome to DegreeWorks");
        System.out.println("Login");
        System.out.println("Create Account");
        System.out.println("Logout");
        System.out.println("Exit");
        System.out.print("Enter your choice: ");
    }

    private String getUserOption() {
        return scanner.nextLine();
    }
    //Login
    private void login() {
        System.out.println("Enter email: ");
        String userName = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        user = application.login(userName, password);
        if (user != null) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed. Please check your username and password.");
        }
    }
    //Signup/CreateAcc
    private void createAccount() {
        System.out.println("Are you a student or advisor?");
        String userOption = scanner.nextLine().toLowerCase();
        if ("student".equals(userOption)) {
            System.out.println("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.println("Enter last name: ");
            String lastName = scanner.nextLine();
            System.out.println("Enter your email: ");
            String email = scanner.nextLine();
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();

            user = application.createStudentAccount(firstName, lastName, email, password);
            if (user != null) {
                System.out.println("Account successfully made.");
            } else {
                System.out.println("Failed to create account. Please check your information again");
            }
        } else if ("advisor".equals(userOption)) {
            System.out.println("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.println("Enter last name: ");
            String lastName = scanner.nextLine();
            System.out.println("Enter your email: ");
            String email = scanner.nextLine();
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();

            user = application.createAdvisorAccount(firstName, lastName, email, password);
            if (user != null) {
                System.out.println("Account successfully made.");
            } else {
                System.out.println("Failed to create account. Please check your information again");
            }
        }

        
    //logout
    private void logout() {
        user = null;
        application.logout();
        System.out.println("Logout successful.");
    }
}
