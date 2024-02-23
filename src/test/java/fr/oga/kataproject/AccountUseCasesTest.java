package fr.oga.kataproject;

import fr.oga.kataproject.application.ports.AccountPort;
import fr.oga.kataproject.application.dto.AccountDto;
import fr.oga.kataproject.application.useCases.AccountUseCase;
import fr.oga.kataproject.infrastructure.exceptions.BalanceShouldNotBeNegative;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class AccountUseCasesTest {

    private AccountUseCase accountUseCase;
    private AccountPort accountPort;

    @BeforeEach
    void setUp() {
        accountPort = mock(AccountPort.class);
        accountUseCase = new AccountUseCase(accountPort);
    }


    @ParameterizedTest
    @CsvSource({
            "1, -200",
            "1, -50"
    })
    void createAccount_negativeBalance(Long accountId,float initialBalance) {
        // Prepare
        AccountDto accountDto = new AccountDto(accountId, initialBalance); // Negative balance

        // Test & Verify
        BalanceShouldNotBeNegative exception = assertThrows(BalanceShouldNotBeNegative.class, () -> accountUseCase.createAccount(accountDto));
        assertEquals("Balance should not be negative", exception.getMessage());
        verify(accountPort, never()).createAccount(accountDto);
    }
}
