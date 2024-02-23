package fr.oga.kataproject.adapters.out.persistance.repositories;

import fr.oga.kataproject.adapters.out.persistance.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    List<TransactionEntity> getStatementEntitiesByAccountId(Long accountId);

}
