package fr.oga.kataproject.application.useCases;

import fr.oga.kataproject.application.ports.AccountPort;
import fr.oga.kataproject.application.dto.AccountDto;
import fr.oga.kataproject.domain.Account;
import fr.oga.kataproject.infrastructure.enums.ErrorCodes;
import fr.oga.kataproject.infrastructure.exceptions.AccountNotFoundException;
import fr.oga.kataproject.infrastructure.exceptions.BalanceShouldNotBeNegative;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@RequiredArgsConstructor
@Service
@Slf4j
public class AccountUseCase {

    private final AccountPort accountPort;
    public String createAccount(AccountDto accountDto){
        if (accountDto.getBalance() < 0 )
            throw new BalanceShouldNotBeNegative("Balance should not be negative", ErrorCodes.INSUFFICIENT_ACCOUNT_BALANCE, Collections.singletonList("You've supplied a balance of " + accountDto.getBalance() + ", which is negative. Please adjust it to a positive value."));
        accountPort.createAccount(accountDto);

        return "Account saved successfully";

    }

    public Account getAccountById(Long id) {
        return accountPort.findAccountById(id).map(a -> new Account(a.getId(), a.getBalance())).orElseThrow(()-> new AccountNotFoundException("Account with id = " + id +" is not found", ErrorCodes.ACCOUNT_NOT_FOUND,new ArrayList<>()));
    }




}
