package br.com.sicredi.assembleia.application.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * VotacaoModelRequest - Request
 * <p>
 * Classe que contem as informacoes necessarias para fazer o cadastro de uma nova votação.
 * </p>
 *
 */
@AllArgsConstructor
@Getter
@Builder
public class VotacaoModelRequest {

    @ApiModelProperty(value = "CPF do Usário que vai votar na pauta", name = "usuarioCpf", example = "12345678910")
    @NotNull(message = "O campo usuarioCpf não pode ser nulo")
    @NotBlank(message = "O campo usuarioCpf não pode ser vazio ou em branco")
    private String usuarioCpf;
    @ApiModelProperty(value = "Id da Pauta que vai realizar o voto", name = "pautaId", example = "1")
    @NotNull(message = "O campo pautaId não pode ser nulo")
    @NotBlank(message = "O campo pautaId não pode ser vazio ou em branco")
    private Long pautaId;
    @ApiModelProperty(value = "Voto na pauta", name = "voto", example = "1 para sim, 2 para não")
    private Integer voto;
}
