package br.com.sicredi.assembleia.application.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PautaDTO {

    @ApiModelProperty(value = "Id da Pauta", name = "pautaId", example = "1")
    private Long pautaId;
    @ApiModelProperty(value = "Titulo da Pauta", name = "pautaId", example = "Titulo 1")
    private String titulo;
    @ApiModelProperty(value = "Status da Pauta", name = "status", example = "FECHADA")
    private String status;
    @ApiModelProperty(value = "Descrição da Pauta", name = "descricao", example = "Descrição 1")
    private String descricao;
    @ApiModelProperty(value = "Hora de Abertura da Pauta", name = "horaAbertura")
    private LocalDateTime horaAbertura;
    @ApiModelProperty(value = "Hora de fechamento da Pauta", name = "horaFechamento")
    private LocalDateTime horaFechamento;
    @ApiModelProperty(value = "Quantidade de votos Sim da Pauta", name = "quantidadeVotosSim", example = "20")
    private int quantidadeVotosSim;
    @ApiModelProperty(value = "Quantidade de votos Não da Pauta", name = "quantidadeVotosNao", example = "10")
    private int quantidadeVotosNao;

}
