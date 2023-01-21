package br.com.sicredi.assembleia.application.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String cpf;

}
