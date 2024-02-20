package fr.oga.kataproject.adapters.out.h2DB.repositories;

import fr.oga.kataproject.adapters.out.h2DB.entities.StatementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatementRepository extends JpaRepository<StatementEntity, Long> {

    List<StatementEntity> getStatementEntitiesByAccountId(Long accountId);

}
