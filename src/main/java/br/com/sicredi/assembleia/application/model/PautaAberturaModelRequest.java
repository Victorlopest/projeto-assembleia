package br.com.sicredi.assembleia.application.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * PautaAberturaModelRequest - Request
 * <p>
 * Classe que contem as informacoes necessarias para fazer a abertura de uma votação em uma pauta.
 * </p>
 *
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PautaAberturaModelRequest {

    @ApiModelProperty(value = "Tempo que a pauta deve permanecer aberta", name = "horasVotacaoAberta", example = "HHH:MM")
    @NotNull(message = "O campo horasVotacaoAberta não pode ser nulo")
    @NotBlank(message = "O campo horasVotacaoAberta não pode ser vazio ou em branco")
    private String horasVotacaoAberta;
}
