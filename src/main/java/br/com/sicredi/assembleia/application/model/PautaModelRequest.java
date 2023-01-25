package br.com.sicredi.assembleia.application.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * PautaModelRequest - Request
 * <p>
 * Classe que contem as informacoes necessarias para fazer o cadastro de uma nova pauta.
 * </p>
 *
 */
@AllArgsConstructor
@Getter
@Builder
public class PautaModelRequest {

    @ApiModelProperty(value = "Id da Pauta", name = "pautaId", example = "1")

    private Long pautaId;
    @ApiModelProperty(value = "Titulo da Pauta", name = "pautaId", example = "Titulo 1")
    @NotNull(message = "O campo titulo não pode ser nulo")
    @NotBlank(message = "O campo titulo não pode ser vazio ou em branco")
    private String titulo;
    @ApiModelProperty(value = "Descrição da Pauta", name = "descricao", example = "Descrição 1")
    @NotNull(message = "O campo descricao não pode ser nulo")
    @NotBlank(message = "O campo descricao não pode ser vazio ou em branco")
    private String descricao;
}
