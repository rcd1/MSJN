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

    private void login() {
        System.out.println("Enter username: ");
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

    private void createAccount() {
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        user = application.createAccount(firstName, lastName, email, password);
        if (user != null) {
            System.out.println("Account successfully made.");
        } else {
            System.out.println("Failed to create account. Please check your information again");
        }
    }

    private void logout() {
        user = null;
        application.logout();
        System.out.println("Logout successful.");
    }
}
