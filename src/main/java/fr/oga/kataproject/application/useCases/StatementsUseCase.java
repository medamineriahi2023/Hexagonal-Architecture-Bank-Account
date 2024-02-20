package fr.oga.kataproject.application.useCases;

import fr.oga.kataproject.application.dao.AccountDAO;
import fr.oga.kataproject.application.dao.StatementDao;
import fr.oga.kataproject.application.dto.AccountDto;
import fr.oga.kataproject.application.dto.StatementDto;
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
public class StatementsUseCase {
    private final AccountDAO accountDAO;
    private final StatementDao statementDao;
    public void depositMoney(Long id , float money){
        Account account = accountDAO.findAccountById(id).map(accountEntity -> new Account(accountEntity.getId(), accountEntity.getBalance())).
                orElseThrow(()-> new AccountNotFoundException("The account with this Id is not found", ErrorCodes.ACCOUNT_NOT_FOUND, new ArrayList<>()));
        accountDAO.createAccount(new AccountDto(id, account.balance() + money));
        StatementDto statementDto = new StatementDto(null, id, Operation.DEPOSIT,account.balance(),money, account.balance() + money);
        statementDao.saveStatement(statementDto);
    }

    public void withdrawMoney(Long id , float money){
        Account account = accountDAO.findAccountById(id).map(accountEntity -> new Account(accountEntity.getId(), accountEntity.getBalance())).
                orElseThrow(()-> new AccountNotFoundException("The account with this Id is not found",ErrorCodes.ACCOUNT_NOT_FOUND, new ArrayList<>()));
        if (account.balance() < money)
            throw new InsufficientBalanceAmount("Your balance is insufficient", ErrorCodes.INSUFFICIENT_ACCOUNT_BALANCE, new ArrayList<>());

        accountDAO.createAccount(new AccountDto(id, account.balance() - money));
        StatementDto statementDto = new StatementDto(null, id, Operation.WITHDRAW,account.balance(),money, account.balance() - money);
        statementDao.saveStatement(statementDto);

    }


    public List<StatementDto> getAllStatements(Long accountId){
        return statementDao.getAllStatements(accountId);
    }



}
