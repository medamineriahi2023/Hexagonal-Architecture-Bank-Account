package fr.oga.kataproject.application.mappers;

import fr.oga.kataproject.adapters.out.persistance.entities.TransactionEntity;
import fr.oga.kataproject.application.dto.TransactionDto;

public class TransactionMapper {

    public static TransactionEntity toEntity(TransactionDto transactionDto) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setId(transactionDto.getId());
        transactionEntity.setAccountId(transactionDto.getAccountId());
        transactionEntity.setOperation(transactionDto.getOperation());
        transactionEntity.setOldBalance(transactionDto.getOldBalance());
        transactionEntity.setDifference(transactionDto.getDifference());
        transactionEntity.setNewBalance(transactionDto.getNewBalance());
        return transactionEntity;
    }

    public static TransactionDto toDto(TransactionEntity transactionEntity) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transactionEntity.getId());
        transactionDto.setAccountId(transactionEntity.getAccountId());
        transactionDto.setOperation(transactionEntity.getOperation());
        transactionDto.setOldBalance(transactionEntity.getOldBalance());
        transactionDto.setDifference(transactionEntity.getDifference());
        transactionDto.setNewBalance(transactionEntity.getNewBalance());
        return transactionDto;
    }
}
