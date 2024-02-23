package fr.oga.kataproject.adapters.out.persistance;

import fr.oga.kataproject.adapters.out.persistance.repositories.TransactionRepository;
import fr.oga.kataproject.application.mappers.TransactionMapper;
import fr.oga.kataproject.application.ports.TransactionPort;
import fr.oga.kataproject.application.dto.TransactionDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class TransactionPortAdapter implements TransactionPort {

    private final TransactionRepository transactionRepository;


    @Override
    @Transactional
    public void saveStatement(TransactionDto transactionDto) {
        transactionRepository.save(TransactionMapper.toEntity(transactionDto));
    }

    @Override
    @Transactional
    public List<TransactionDto> getAllTransactions(Long accountId) {
        List<TransactionDto> transactionDtos = new ArrayList<>();
        transactionRepository.getStatementEntitiesByAccountId(accountId).
                forEach(transaction -> transactionDtos.add(TransactionMapper.toDto(transaction)));
        return transactionDtos;
    }
}
