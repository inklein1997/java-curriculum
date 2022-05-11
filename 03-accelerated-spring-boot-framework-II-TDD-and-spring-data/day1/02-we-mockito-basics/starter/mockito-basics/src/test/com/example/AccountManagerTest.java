package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class AccountManagerTest {

    private FormatChecker formatChecker;
    private AccountRepository accountRepository;
    private AccountManager accountManager;

    private static final String goodUsername1 = "username";
    private static final String getGoodUsername2 = "eightCharacterUsername";
    private static final String goodPassword1 = "passw0rd";
    private static final String goodPassword2 = "afjkdlasfiow3";

    private static final String badUsername = "bad";
    private static final String badPassword = "abcde";

    @Before
    public void setUp() {
        formatChecker = mock(FormatChecker.class);
        doReturn(true).when(formatChecker).ValidateUsername(goodUsername1);
        doReturn(true).when(formatChecker).ValidatePassword(goodPassword1);
        doReturn(false).when(formatChecker).ValidateUsername(badUsername);
        doReturn(false).when(formatChecker).ValidatePassword(badPassword);
        accountRepository = mock(AccountRepository.class);
        doReturn(true).when(accountRepository).CreateAccount(anyString(), anyString());

        accountManager = new AccountManager(formatChecker, accountRepository);

    }

    @Test
    public void shouldCreateANewAccountWithoutMockObjects() {
        SimpleFormatChecker simpleFormatChecker = new SimpleFormatChecker();
        SimpleAccountRepository simpleAccountRepository = new SimpleAccountRepository();

        AccountManager accountManager = new AccountManager(simpleFormatChecker, simpleAccountRepository);

        assert(accountManager.CreateNew(goodUsername1,goodPassword1));
    }

    @Test
    public void shouldCreateNewAccount() {
        assert(accountManager.CreateNew(goodUsername1, goodPassword1));
    }

    @Test
    public void shouldFailToCreateAccountWithInvalidUsername() {
        assertFalse(accountManager.CreateNew(badUsername,goodPassword2));
    }

    @Test
    public void shouldFailToCreateAccountWithInvalidPassword() {
        assertFalse(accountManager.CreateNew(getGoodUsername2, badPassword));
    }

    @Test
    public void shouldCallValidateAndCreateNewVerifiedWithSpies() {
        FormatChecker spyFormatChecker = spy(SimpleFormatChecker.class);
        AccountRepository spyAccountRepository = spy(SimpleAccountRepository.class);

        AccountManager spiedUponAccountManager = new AccountManager(spyFormatChecker, spyAccountRepository);

        spiedUponAccountManager.CreateNew("username", "passw0rd");
        spiedUponAccountManager.CreateNew("username2","passw0rd2");

        verify(spyFormatChecker).ValidateUsername("username");
        verify(spyFormatChecker).ValidatePassword("passw0rd2");

        verify(spyFormatChecker, times(2)).ValidateUsername(anyString());

    }
}