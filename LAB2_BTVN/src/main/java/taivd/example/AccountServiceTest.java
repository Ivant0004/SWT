package taivd.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        accountService = new AccountService();
    }

    @Test
    @DisplayName("Test email hợp lệ")
    void testValidEmails() {
        assertTrue(accountService.isValidEmail("test@example.com"));
        assertFalse(accountService.isValidEmail("invalid-email"));
    }

    @ParameterizedTest(name = "{index} => username={0}, password={1}, email={2}, expected={3}")
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testRegisterAccount(String username, String password, String email, boolean expected) {
        assertEquals(expected, accountService.registerAccount(username, password, email));
    }
}
