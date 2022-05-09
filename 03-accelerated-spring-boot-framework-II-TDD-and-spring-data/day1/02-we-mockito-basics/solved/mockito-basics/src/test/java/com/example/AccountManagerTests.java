package com.example;

import org.junit.Test;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class AccountManagerTests {

    @Test
    public void withoutMocks() {

        SimpleFormatChecker simpleFormatChecker = new SimpleFormatChecker();
        SimpleAccountRepository simpleAccountRepository = new SimpleAccountRepository();

        AccountManager accountManager = new AccountManager(simpleFormatChecker, simpleAccountRepository);

        assert(accountManager.CreateNew("username", "passw0rd"));
    }

    @Test
    public void withMockedObjects() {

        FormatChecker formatChecker = mock(FormatChecker.class);
        doReturn(true).when(formatChecker).ValidateUsername("username");
        doReturn(true).when(formatChecker).ValidateUsername("username2");
        doReturn(true).when(formatChecker).ValidatePassword(anyString());

        AccountRepository accountRepository = mock(AccountRepository.class);
        doReturn(true).when(accountRepository).CreateAccount(anyString(), anyString());

        AccountManager accountManager = new AccountManager(formatChecker, accountRepository);
        assert(accountManager.CreateNew("username", "passw0rd"));
        assert(accountManager.CreateNew("username2", "passw0rd2"));
    }

    @Test
    public void withSpies() {

        FormatChecker spyFormatChecker = spy(SimpleFormatChecker.class);
        AccountRepository spyAccountRepository = spy(SimpleAccountRepository.class);

        AccountManager accountManager = new AccountManager(spyFormatChecker, spyAccountRepository);
        accountManager.CreateNew("username", "passw0rd");
        accountManager.CreateNew("username2", "passw0rd2");

        verify(spyFormatChecker).ValidateUsername("username");
        verify(spyFormatChecker).ValidatePassword("passw0rd2");

        verify(spyFormatChecker, times(2)).ValidateUsername(anyString());
    }
}
