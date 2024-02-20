package fr.oga.kataproject.adapters.out.h2DB.entities;

import fr.oga.kataproject.infrastructure.enums.Operation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "statements")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long accountId;
    @Enumerated(EnumType.STRING)
    private Operation operation;
    private float oldBalance;
    private float difference;
    private float newBalance;
}
