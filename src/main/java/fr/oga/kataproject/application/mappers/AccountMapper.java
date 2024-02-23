package fr.oga.kataproject.application.mappers;

import fr.oga.kataproject.adapters.out.persistance.entities.AccountEntity;
import fr.oga.kataproject.application.dto.AccountDto;

public class AccountMapper {

    public static AccountEntity toEntity(AccountDto accountDto) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(accountDto.getId());
        accountEntity.setBalance(accountDto.getBalance());
        return accountEntity;
    }

    public static AccountDto toDto(AccountEntity accountEntity) {

        AccountDto accountDto = new AccountDto();
        accountDto.setId(accountEntity.getId());
        accountDto.setBalance(accountEntity.getBalance());

        return accountDto;
    }
}
