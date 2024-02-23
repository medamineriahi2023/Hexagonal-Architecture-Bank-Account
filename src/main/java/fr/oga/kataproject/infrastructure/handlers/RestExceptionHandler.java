package fr.oga.kataproject.infrastructure.handlers;

import fr.oga.kataproject.infrastructure.exceptions.AccountNotFoundException;
import fr.oga.kataproject.infrastructure.exceptions.BalanceShouldNotBeNegative;
import fr.oga.kataproject.infrastructure.exceptions.InsufficientBalanceAmount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleException(AccountNotFoundException exception , WebRequest webRequest){
        final HttpStatus badRequest = HttpStatus.NOT_FOUND;
        ErrorDTO error =  ErrorDTO.builder()
                .errorCodes(exception.getErrorCodes())
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();
        return new ResponseEntity<>(error , badRequest);

    }


    @ExceptionHandler(InsufficientBalanceAmount.class)
    public ResponseEntity<ErrorDTO> handleException(InsufficientBalanceAmount exception , WebRequest webRequest){
        final HttpStatus badRequest = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorDTO error =  ErrorDTO.builder()
                .errorCodes(exception.getErrorCodes())
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();
        return new ResponseEntity<>(error , badRequest);

    }


    @ExceptionHandler(BalanceShouldNotBeNegative.class)
    public ResponseEntity<ErrorDTO> handleException(BalanceShouldNotBeNegative exception , WebRequest webRequest){
        final HttpStatus badRequest = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorDTO error =  ErrorDTO.builder()
                .errorCodes(exception.getErrorCodes())
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();
        return new ResponseEntity<>(error , badRequest);

    }
}
