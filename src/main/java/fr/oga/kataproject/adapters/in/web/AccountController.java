package fr.oga.kataproject.adapters.in.web;

import fr.oga.kataproject.application.dto.AccountDto;
import fr.oga.kataproject.application.useCases.AccountUseCase;
import fr.oga.kataproject.domain.Account;
import fr.oga.kataproject.infrastructure.exceptions.AccountNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountUseCase accountUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable(name = "id") Long id) throws AccountNotFoundException {
        return ResponseEntity.ok(accountUseCase.getAccountById(id));
    }

    @PostMapping
    public ResponseEntity<String> createAccount(AccountDto accountDto){
        return ResponseEntity.ok(accountUseCase.createAccount(accountDto));
    }


}
