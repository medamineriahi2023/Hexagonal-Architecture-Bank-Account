package fr.oga.kataproject.application.dto;

import fr.oga.kataproject.infrastructure.enums.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    private Long id;
    private Long accountId;
    private Operation operation;
    private float oldBalance;
    private float difference;
    private float newBalance;
}
