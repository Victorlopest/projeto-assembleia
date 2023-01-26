package br.com.sicredi.assembleia.userinterface.controller;


import br.com.sicredi.assembleia.application.dto.VotacaoDTO;
import br.com.sicredi.assembleia.application.model.VotacaoModelRequest;
import br.com.sicredi.assembleia.application.usecase.VotacaoUseCase;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/votacao/v1")
@AllArgsConstructor
public class VotacaoController {

    private final VotacaoUseCase votacaoUseCase;

    /**
     * <p>
     * Metodo que realiza o cadastro de um voto em uma determinada pauta aberta
     * </p>
     *
     * @param votacaoModelRequest
     * @return VotacaoDTO - Objeto no formato Json de retorno
     */
    @ApiOperation(value = "Salva um voto de um usuário", notes = "Realiza o cadastro de um voto em uma determinada pauta aberta")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Pauta não localizada."),
            @ApiResponse(code = 400, message = "O CPF digitado é inválido"),
            @ApiResponse(code = 400, message = "O CPF digitado não está apto para votar"),
            @ApiResponse(code = 400, message = "Não é possivel votar nessa pauta pois ela está fechada"),
            @ApiResponse(code = 400, message = "O CPF digitado já votou nessa pauta")
    })
    @PostMapping(name = "Salva um voto de um usuário", produces="application/json", consumes="application/json")
    public ResponseEntity<VotacaoDTO> salvar(@RequestBody VotacaoModelRequest votacaoModelRequest) {
        return new ResponseEntity<>((votacaoUseCase.salvar(votacaoModelRequest)), HttpStatus.CREATED);

    }

}
