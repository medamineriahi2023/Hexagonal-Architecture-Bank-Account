package fr.oga.kataproject.infrastructure.exceptions.abstracts;

import fr.oga.kataproject.infrastructure.enums.ErrorCodes;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class AbstractEntityException extends RuntimeException {
    @Getter
    private ErrorCodes errorCodes ;
    @Getter
    private List<String> errors;


    public AbstractEntityException(String message , ErrorCodes errorCodes , List<String> errors){
        super(message);
        this.errorCodes = errorCodes;
        this.errors = errors;
    }

    public AbstractEntityException(String message , ErrorCodes errorCodes){
        super(message);
        this.errorCodes = errorCodes;
    }
}
