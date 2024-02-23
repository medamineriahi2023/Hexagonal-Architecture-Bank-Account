package fr.oga.kataproject.adapters.out.persistance.entities;

import fr.oga.kataproject.infrastructure.enums.Operation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "transaction")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {
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
