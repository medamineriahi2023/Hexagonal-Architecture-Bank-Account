package fr.oga.kataproject.infrastructure.handlers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import fr.oga.kataproject.infrastructure.enums.ErrorCodes;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDTO {
    private Integer httpCode;
    private ErrorCodes errorCodes;
    private String message;
    private List<String> errors = new ArrayList<>();
}
