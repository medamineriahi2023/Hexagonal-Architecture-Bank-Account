package fr.oga.kataproject.application.useCases;

import fr.oga.kataproject.application.ports.AccountPort;
import fr.oga.kataproject.application.ports.TransactionPort;
import fr.oga.kataproject.application.dto.AccountDto;
import fr.oga.kataproject.application.dto.TransactionDto;
import fr.oga.kataproject.domain.Account;
import fr.oga.kataproject.infrastructure.enums.ErrorCodes;
import fr.oga.kataproject.infrastructure.enums.Operation;
import fr.oga.kataproject.infrastructure.exceptions.AccountNotFoundException;
import fr.oga.kataproject.infrastructure.exceptions.InsufficientBalanceAmount;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class TransactionsUseCase {
    private final AccountPort accountPort;
    private final TransactionPort transactionPort;
    public void depositMoney(Long id , float money){
        Account account = accountPort.findAccountById(id).map(accountEntity -> new Account(accountEntity.getId(), accountEntity.getBalance())).
                orElseThrow(()-> new AccountNotFoundException("The account with this Id is not found", ErrorCodes.ACCOUNT_NOT_FOUND, new ArrayList<>()));
        accountPort.createAccount(new AccountDto(id, account.balance() + money));
        TransactionDto transactionDto = new TransactionDto(null, id, Operation.DEPOSIT,account.balance(),money, account.balance() + money);
        transactionPort.saveStatement(transactionDto);
    }

    public void withdrawMoney(Long id , float money){
        Account account = accountPort.findAccountById(id).map(accountEntity -> new Account(accountEntity.getId(), accountEntity.getBalance())).
                orElseThrow(()-> new AccountNotFoundException("The account with this Id is not found",ErrorCodes.ACCOUNT_NOT_FOUND, new ArrayList<>()));
        if (account.balance() < money)
            throw new InsufficientBalanceAmount("Your balance is insufficient", ErrorCodes.INSUFFICIENT_ACCOUNT_BALANCE, new ArrayList<>());

        accountPort.createAccount(new AccountDto(id, account.balance() - money));
        TransactionDto transactionDto = new TransactionDto(null, id, Operation.WITHDRAW,account.balance(),money, account.balance() - money);
        transactionPort.saveStatement(transactionDto);

    }


    public List<TransactionDto> getAllStatements(Long accountId){
        return transactionPort.getAllTransactions(accountId);
    }



}
