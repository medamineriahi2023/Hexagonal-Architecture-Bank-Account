package fr.oga.kataproject;

import fr.oga.kataproject.adapters.out.persistance.entities.AccountEntity;
import fr.oga.kataproject.application.ports.AccountPort;
import fr.oga.kataproject.application.ports.TransactionPort;
import fr.oga.kataproject.application.useCases.TransactionsUseCase;
import fr.oga.kataproject.infrastructure.exceptions.InsufficientBalanceAmount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class TransactionsUseCaseTest {

    private TransactionsUseCase transactionsUseCase;
    private AccountPort accountPort;
    private TransactionPort transactionPort;

    @BeforeEach
    void setUp() {
        accountPort = mock(AccountPort.class);
        transactionPort = mock(TransactionPort.class);
        transactionsUseCase = new TransactionsUseCase(accountPort, transactionPort);
    }

    @ParameterizedTest
    @CsvSource({
            "100, 50, 150",
            "250, 50, 300"
    })
    void depositMoney(float initialBalance, float depositAmount, float expectedBalance) {
        // Arrange
        Long accountId = 1L;
        AccountEntity account = new AccountEntity(accountId, initialBalance);
        when(accountPort.findAccountById(accountId)).thenReturn(java.util.Optional.of(account));

        // Act
        transactionsUseCase.depositMoney(accountId, depositAmount);

        // Assert
        verify(accountPort, times(1)).findAccountById(accountId);
        verify(accountPort, times(1)).createAccount(any());
        verify(transactionPort, times(1)).saveStatement(any());
    }

    @ParameterizedTest
    @CsvSource({
            "300, 50, 250",
            "250, 100, 150"
    })
    void withdrawMoney(float initialBalance, float withdrawalAmount, float expectedBalance) {
        // Arrange
        Long accountId = 1L;
        AccountEntity account = new AccountEntity(accountId, initialBalance);
        when(accountPort.findAccountById(accountId)).thenReturn(java.util.Optional.of(account));

        // Act
        transactionsUseCase.withdrawMoney(accountId, withdrawalAmount);

        // Assert
        verify(accountPort, times(1)).findAccountById(accountId);
        verify(accountPort, times(1)).createAccount(any());
        verify(transactionPort, times(1)).saveStatement(any());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 200, 300",
            "1, 50, 51"
    })
    void withdrawMoney_insufficientBalance(Long accountId, float initialBalance, float withdrawalAmount) {
        // Arrange
        AccountEntity account = new AccountEntity(accountId, initialBalance);
        when(accountPort.findAccountById(accountId)).thenReturn(java.util.Optional.of(account));

        // Act & Assert
        InsufficientBalanceAmount exception = assertThrows(InsufficientBalanceAmount.class,
                () -> transactionsUseCase.withdrawMoney(accountId, withdrawalAmount));

        // Assert
        assertEquals("Your balance is insufficient", exception.getMessage());
        verify(accountPort, times(1)).findAccountById(accountId);
        verify(accountPort, never()).createAccount(any());
        verify(transactionPort, never()).saveStatement(any());
    }
}
