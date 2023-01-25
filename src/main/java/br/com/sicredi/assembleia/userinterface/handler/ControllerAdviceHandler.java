package br.com.sicredi.assembleia.userinterface.handler;

import br.com.sicredi.assembleia.userinterface.exception.*;
import br.com.sicredi.assembleia.userinterface.exception.error.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdviceHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NaoEncontradoException.class)
    public ResponseEntity<?> naoEncontradoException(NaoEncontradoException ex) {

        ErrorMessage erro = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FormatoHoraException.class)
    public ResponseEntity<?> formatoHoraException(FormatoHoraException ex) {

        ErrorMessage erro = new ErrorMessage("Bad Request", HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> apiException(ApiException ex) {

        ErrorMessage erro = new ErrorMessage("Bad Request", HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CpfException.class)
    public ResponseEntity<?> cpfException(CpfException ex) {

        ErrorMessage erro = new ErrorMessage("Bad Request", HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }

}
