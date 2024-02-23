package fr.oga.kataproject.adapters.out.persistance;

import fr.oga.kataproject.adapters.out.persistance.entities.AccountEntity;
import fr.oga.kataproject.adapters.out.persistance.repositories.AccountRepository;
import fr.oga.kataproject.application.mappers.AccountMapper;
import fr.oga.kataproject.application.ports.AccountPort;
import fr.oga.kataproject.application.dto.AccountDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@RequiredArgsConstructor
@Component
public class AccountPortAdapter implements AccountPort {
    private final AccountRepository accountRepository;
    @Override
    @Transactional
    public Optional<AccountEntity> findAccountById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    @Transactional
    public void createAccount(AccountDto accountDto) {
            accountRepository.save(AccountMapper.toEntity(accountDto));
    }

}
