package fr.oga.kataproject.application.useCases;

import fr.oga.kataproject.application.dao.AccountDAO;
import fr.oga.kataproject.application.dto.AccountDto;
import fr.oga.kataproject.domain.Account;
import fr.oga.kataproject.infrastructure.enums.ErrorCodes;
import fr.oga.kataproject.infrastructure.exceptions.AccountNotFoundException;
import fr.oga.kataproject.infrastructure.exceptions.InsufficientBalanceAmount;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
@Slf4j
public class AccountUseCase {

    private final AccountDAO accountDAO;
    public String createAccount(AccountDto accountDto){
        accountDAO.createAccount(accountDto);

        return "Account saved successfully";

    }

    public Account getAccountById(Long id) throws AccountNotFoundException {
        return accountDAO.findAccountById(id).map(a -> new Account(a.getId(), a.getBalance())).orElseThrow(()-> new AccountNotFoundException("Account with id = " + id +" is not found", ErrorCodes.ACCOUNT_NOT_FOUND,new ArrayList<>()));
    }




}
