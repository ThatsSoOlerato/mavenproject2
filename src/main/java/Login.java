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
}
