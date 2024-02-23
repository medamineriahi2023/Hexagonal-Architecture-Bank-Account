package fr.oga.kataproject.application.ports;

import fr.oga.kataproject.adapters.out.persistance.entities.AccountEntity;
import fr.oga.kataproject.application.dto.AccountDto;

import java.util.Optional;

public interface AccountPort {
    Optional<AccountEntity> findAccountById(Long id);
    void createAccount(AccountDto accountDto);


}
