package br.com.sicredi.assembleia.userinterface.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorMessage {
    private String titulo;
    private int codigo;
    private String descricao;
}
