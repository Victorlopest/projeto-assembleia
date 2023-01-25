package br.com.sicredi.assembleia.userinterface.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class FormatoHoraException extends RuntimeException {

    public FormatoHoraException(String mensagem) {
        super(mensagem);
    }
}
