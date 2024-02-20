package fr.oga.kataproject.adapters.out.h2DB;

import fr.oga.kataproject.adapters.out.h2DB.entities.StatementEntity;
import fr.oga.kataproject.adapters.out.h2DB.repositories.StatementRepository;
import fr.oga.kataproject.application.dao.StatementDao;
import fr.oga.kataproject.application.dto.StatementDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class StatementDaoAdapter implements StatementDao {

    private final StatementRepository statementRepository;


    @Override
    public void saveStatement(StatementDto statementDto) {
        statementRepository.save(new StatementEntity(
           null,
           statementDto.getAccountId(),
           statementDto.getOperation(),
           statementDto.getOldBalance(),
           statementDto.getDifference(),
           statementDto.getNewBalance()
        ));
    }

    @Override
    public List<StatementDto> getAllStatements(Long accountId) {
        List<StatementDto> statementDtos= new ArrayList<>();
        statementRepository.getStatementEntitiesByAccountId(accountId).
                forEach(s -> statementDtos.add(new StatementDto(s.getId(),s.getAccountId(),s.getOperation(),s.getOldBalance(),s.getDifference(),s.getNewBalance())));
        return statementDtos;
    }
}
