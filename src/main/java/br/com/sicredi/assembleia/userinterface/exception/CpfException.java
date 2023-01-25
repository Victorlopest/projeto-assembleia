package br.com.sicredi.assembleia.userinterface.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CpfException extends RuntimeException {

    public CpfException(String mensagem) {
        super(mensagem);
    }
}
