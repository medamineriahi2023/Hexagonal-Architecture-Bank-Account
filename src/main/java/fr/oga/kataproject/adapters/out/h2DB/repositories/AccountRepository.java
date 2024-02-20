package fr.oga.kataproject.adapters.out.h2DB.repositories;

import fr.oga.kataproject.adapters.out.h2DB.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
