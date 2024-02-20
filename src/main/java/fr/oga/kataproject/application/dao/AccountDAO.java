package fr.oga.kataproject.application.dao;

import fr.oga.kataproject.adapters.out.h2DB.entities.AccountEntity;
import fr.oga.kataproject.application.dto.AccountDto;

import java.util.Optional;

public interface AccountDAO {
    Optional<AccountEntity> findAccountById(Long id);
    void createAccount(AccountDto accountDto);


}
