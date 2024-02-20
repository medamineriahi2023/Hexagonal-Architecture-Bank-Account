package fr.oga.kataproject.infrastructure.exceptions;

import fr.oga.kataproject.infrastructure.enums.ErrorCodes;
import fr.oga.kataproject.infrastructure.exceptions.abstracts.AbstractEntityException;

import java.util.List;

public class InsufficientBalanceAmount extends AbstractEntityException {
    public InsufficientBalanceAmount(String message , ErrorCodes errorCodes , List<String> errors){
        super(message,errorCodes,errors);
    }

    public InsufficientBalanceAmount(String message , ErrorCodes errorCodes){
        super(message,errorCodes);
    }
}
