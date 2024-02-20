package fr.oga.kataproject.application.dto;

import fr.oga.kataproject.infrastructure.enums.Operation;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatementDto {
    private Long id;
    private Long accountId;
    private Operation operation;
    private float oldBalance;
    private float difference;
    private float newBalance;
}
