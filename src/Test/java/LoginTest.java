import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    // ── assertEquals tests ──────────────────────────────────────────────────

    @Test
    public void testUsernameCorrectlyFormattedReturnsWelcome() {
        Login login = new Login("Kyle", "Ryan", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Welcome Kyle, Ryan it is great to see you again.",
                     login.returnLoginStatus("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testUsernameIncorrectlyFormattedReturnsError() {
        Login login = new Login("Kyle", "Ryan", "kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Username is not correctly formatted; please ensure that your username "
                   + "contains an underscore and is no more than five characters in length.",
                     login.registerUser());
    }

    @Test
    public void testPasswordMeetsComplexityReturnsSuccess() {
        Login login = new Login("Kyle", "Ryan", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Password successfully captured.", login.registerUser());
    }

    @Test
    public void testPasswordDoesNotMeetComplexityReturnsError() {
        Login login = new Login("Kyle", "Ryan", "kyl_1", "password", "+27838968976");
        assertEquals("Password is not correctly formatted; please ensure that the password "
                   + "contains at least eight characters, a capital letter, a number, and a special character.",
                     login.registerUser());
    }

    @Test
    public void testCellPhoneCorrectlyFormattedReturnsSuccess() {
        Login login = new Login("Kyle", "Ryan", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Cell number successfully captured.", login.checkCellPhoneNumberStatus());
    }

    @Test
    public void testCellPhoneIncorrectlyFormattedReturnsError() {
        Login login = new Login("Kyle", "Ryan", "kyl_1", "Ch&&sec@ke99!", "08966553");
        assertEquals("Cell number is incorrectly formatted or does not contain an international code; "
                   + "please correct the number and try again.",
                     login.checkCellPhoneNumberStatus());
    }

    // ── assertTrue / assertFalse tests ─────────────────────────────────────

    @Test
    public void testLoginSuccessful() {
        Login login = new Login("Kyle", "Ryan", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        Login login = new Login("Kyle", "Ryan", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.loginUser("wronguser", "wrongpassword"));
    }

    @Test
    public void testCheckUserNameValid() {
        Login login = new Login("Kyle", "Ryan", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.checkUserName());
    }

    @Test
    public void testCheckUserNameInvalid() {
        Login login = new Login("Kyle", "Ryan", "kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexityValid() {
        Login login = new Login("Kyle", "Ryan", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testCheckPasswordComplexityInvalid() {
        Login login = new Login("Kyle", "Ryan", "kyl_1", "password", "+27838968976");
        assertFalse(login.checkPasswordComplexity());
    }

    @Test
    public void testCheckCellPhoneNumberValid() {
        Login login = new Login("Kyle", "Ryan", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    public void testCheckCellPhoneNumberInvalid() {
        Login login = new Login("Kyle", "Ryan", "kyl_1", "Ch&&sec@ke99!", "08966553");
        assertFalse(login.checkCellPhoneNumber());
    }
}
