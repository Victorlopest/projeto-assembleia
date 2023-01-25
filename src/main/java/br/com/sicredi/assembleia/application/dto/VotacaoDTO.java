package br.com.sicredi.assembleia.application.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VotacaoDTO {
    @ApiModelProperty(value = "Id da Votação", name = "votacaoId", example = "1")
    private Long ticketVotacao;
    @ApiModelProperty(value = "CPF do Usário que vai votar na pauta", name = "usuarioCpf", example = "12345678910")
    private String usuarioCpf;
    @ApiModelProperty(value = "Pauta relacionada a votação", name = "pauta")
    private Long pautaId;
    @ApiModelProperty(value = "Voto na pauta", name = "voto", example = "1 para sim, 2 para não")
    private Integer voto;

}
