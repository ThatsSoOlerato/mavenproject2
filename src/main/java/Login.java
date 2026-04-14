import java.util.regex.Pattern;

/**
 * Login class for the QuickChat application.
 * Handles user registration and authentication.
 *
 * Cell phone regex reference:
 * O'Reilly, J. (2012). Regular Expressions Cookbook (2nd ed.). O'Reilly Media.
 * Available at: https://www.oreilly.com/library/view/regular-expressions-cookbook/9781449327453/ch04s03.html
 * Pattern follows ITU-T E.164 international numbering format.
 */
public class Login {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellPhoneNumber;

    public Login(String firstName, String lastName, String username,
                 String password, String cellPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getFirstName()  { return firstName; }
    public String getLastName()   { return lastName; }
    public String getUsername()   { return username; }

    /** Checks username contains '_' and is no more than 5 characters long. */
    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    /** Checks password: min 8 chars, 1 uppercase, 1 digit, 1 special character. */
    public boolean checkPasswordComplexity() {
        if (password.length() < 8) return false;
        boolean hasUpper = false, hasDigit = false, hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c))       hasUpper = true;
            else if (Character.isDigit(c))      hasDigit = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        return hasUpper && hasDigit && hasSpecial;
    }

    /**
     * Validates cell phone number using regex.
     * Must start with +27 (SA international code) followed by 9 digits.
     * Regex: ^\+27[0-9]{9}$
     */
    public boolean checkCellPhoneNumber() {
        return Pattern.matches("^\\+27[0-9]{9}$", cellPhoneNumber);
    }

    /** Returns a status message for the cell phone number validation. */
    public String checkCellPhoneNumberStatus() {
        if (checkCellPhoneNumber()) {
            return "Cell number successfully captured.";
        }
        return "Cell number is incorrectly formatted or does not contain an international code; "
             + "please correct the number and try again.";
    }

    /** Validates username and password and returns the appropriate registration message. */
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username "
                 + "contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password "
                 + "contains at least eight characters, a capital letter, a number, and a special character.";
        }
        return "Password successfully captured.";
    }

    /** Returns true if the entered credentials match the stored credentials. */
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    /** Returns a welcome message on successful login, or an error message on failure. */
    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
}
