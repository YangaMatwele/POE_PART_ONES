import org.junit.Test;
import static org.junit.Assert.*;

public class testClass{

    //Registration: userName tests
    @Test
    public void testValidUserName() {
        Registration reg = new Registration();
        assertTrue(reg.checkuserName("abc_")); // too long
    }

    @Test
    public void testInvalidUserNameTooLong() {
        Registration reg = new Registration();
        assertFalse(reg.checkuserName("abcdef_")); // too long
    }
    @Test
    public void testInvalidUserNameNoUnderscore() {
        Registration reg = new Registration();
        assertFalse(reg.checkuserName("abcd"));// missing "_"
    }

    // Registration: Password tests
    @Test
    public void testValidPassword() {
        Registration reg = new Registration();
        assertTrue(reg.checkPassword("Password!")); // has uppercase, digit, special
    }


    @Test
    public void testInvalidPasswordTooShort() {
        Registration reg = new Registration();
        assertFalse(reg.checkPassword("Pw1!")); // too short
    }

    @Test
    public void testInvalidPasswordNoUppercase() {
        Registration reg = new Registration();
        assertFalse(reg.checkPassword("password1!")); // no uppercase
    }

    @Test
    public void testingInvalidPasswordNoDigit() {
        Registration reg = new Registration();
        assertFalse(reg.checkPassword("Password!")); // missing digit
    }
    @Test
    public void testInvalidPasswordNoSpecialChar() {
        Registration reg = new Registration();
        assertFalse(reg.checkPassword("Password1")); // missing special char
    }

    // ✅ Registration: Phone number tests
    @Test
    public void testValidPhoneNumberLocal() {
        Registration reg = new Registration();
        assertTrue(reg.checkphoneNumber("0987654321")); // starts with 0 + 9 digits
    }

    @Test
    public void testValidPhoneNumberInternational() {
        Registration reg = new Registration();
        assertTrue(reg.checkphoneNumber("+27987654321")); // starts with +27 + 9 digits
    }

    @Test
    public void testInvalidPhoneNumberTooShort() {
        Registration reg = new Registration();
        assertFalse(reg.checkphoneNumber("98765")); // too short
    }

    @Test
    public void testInvalidPhoneNumberWrongPrefix() {
        Registration reg = new Registration();
        assertFalse(reg.checkphoneNumber("9987654321")); // wrong prefix
    }

    // ✅ Login: Successful login
    @Test
    public void testSuccessfulLogin() {
        Login login = new Login("user123", "pass123", "Alexer", "Dani");
        String result = login.LoginUser("user123", "pass123");
        assertTrue(result.startsWith("Welcome Alexer Dani"));
    }

    // ✅ Login: Failed login
    @Test
    public void testFailedLogin() {
        Login login = new Login("user123", "pass123", "Alexer", "Dani");
        String result = login.LoginUser("wrongUser", "wrongPass");
        assertEquals("Username or Password incorrect. Please try again.", result);
    }
}

    
