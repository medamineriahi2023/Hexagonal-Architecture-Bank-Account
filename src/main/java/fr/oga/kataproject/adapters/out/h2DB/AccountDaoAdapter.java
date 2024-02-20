package fr.oga.kataproject.adapters.out.h2DB;

import fr.oga.kataproject.adapters.out.h2DB.entities.AccountEntity;
import fr.oga.kataproject.adapters.out.h2DB.repositories.AccountRepository;
import fr.oga.kataproject.application.dao.AccountDAO;
import fr.oga.kataproject.application.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@RequiredArgsConstructor
@Component
public class AccountDaoAdapter implements AccountDAO {
    private final AccountRepository accountRepository;
    @Override
    public Optional<AccountEntity> findAccountById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public void createAccount(AccountDto accountDto) {
            accountRepository.save(new AccountEntity(accountDto.getId(), accountDto.getBalance()));
    }

}
