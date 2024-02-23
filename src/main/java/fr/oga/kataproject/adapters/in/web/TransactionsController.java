package fr.oga.kataproject.adapters.in.web;

import fr.oga.kataproject.application.dto.TransactionDto;
import fr.oga.kataproject.application.useCases.TransactionsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statements")
@RequiredArgsConstructor
public class TransactionsController {
    private final TransactionsUseCase transactionsUseCase;

    @PutMapping("deposit/{accountId}/{money}")
    public ResponseEntity<String> depositMoney(@PathVariable(name = "accountId") Long id, @PathVariable(name = "money") float money){
        transactionsUseCase.depositMoney(id, money);
        return ResponseEntity.ok("deposit done successfully");
    }

    @PutMapping("withdraw/{accountId}/{money}")
    public ResponseEntity<String> withdrawMoney(@PathVariable(name = "accountId") Long id,@PathVariable(name = "money") float money){
        transactionsUseCase.withdrawMoney(id, money);
        return ResponseEntity.ok("withdraw done successfully");
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<List<TransactionDto>> getAllTransactions(@PathVariable(name = "accountId") Long id){
        return ResponseEntity.ok(transactionsUseCase.getAllStatements(id));

    }


}
