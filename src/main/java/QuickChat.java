import java.util.Scanner;

public class QuickChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//fancy formatting for appeal
        System.out.println("==============================");
        System.out.println("   Welcome to QuickChat!      ");
        System.out.println("==============================");
        System.out.println("\n--- Registration ---");

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter a username (must contain '_' and be 5 chars or less): ");
        String username = scanner.nextLine();

        System.out.print("Enter a password (min 8 chars, 1 capital, 1 number, 1 special): ");
        String password = scanner.nextLine();

        System.out.print("Enter your cell phone number (e.g. +27838968976): ");
        String cellPhone = scanner.nextLine();

        Login user = new Login(firstName, lastName, username, password, cellPhone);

        System.out.println("\n--- Registration Status ---");
        System.out.println(user.registerUser());
        System.out.println(user.checkCellPhoneNumberStatus());

        if (user.checkUserName() && user.checkPasswordComplexity() && user.checkCellPhoneNumber()) {
            System.out.println("User registered successfully!");
            System.out.println("\n--- Login ---");

            System.out.print("Enter your username: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Enter your password: ");
            String loginPassword = scanner.nextLine();

            System.out.println("\n--- Login Status ---");
            System.out.println(user.returnLoginStatus(loginUsername, loginPassword));
        } else {
            System.out.println("\nRegistration failed. Please restart and try again.");
        }

        scanner.close();
    }
    //quickchat complete
}
