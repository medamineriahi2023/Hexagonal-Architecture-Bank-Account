package fr.oga.kataproject.application.ports;

import fr.oga.kataproject.application.dto.TransactionDto;

import java.util.List;

public interface TransactionPort {
   void saveStatement(TransactionDto transactionDto);

   List<TransactionDto> getAllTransactions(Long accountId);



}
