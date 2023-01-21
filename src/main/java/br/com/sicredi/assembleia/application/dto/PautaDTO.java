package br.com.sicredi.assembleia.application.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PautaDTO {
    private Long id;
    private String titulo;
    private int status;
    private String descricao;
    private LocalDateTime horaInicio;
    private LocalDateTime horafim;

}
