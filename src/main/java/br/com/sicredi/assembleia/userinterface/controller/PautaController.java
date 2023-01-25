package br.com.sicredi.assembleia.userinterface.controller;


import br.com.sicredi.assembleia.application.dto.PautaDTO;
import br.com.sicredi.assembleia.application.model.PautaAberturaModelRequest;
import br.com.sicredi.assembleia.application.model.PautaModelRequest;
import br.com.sicredi.assembleia.application.usecase.PautaUseCase;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/pautas/v1")
@AllArgsConstructor
public class PautaController {

    private final PautaUseCase pautaUseCase;

    /**
     * <p>
     * Metodo que realiza a consulta de todas as pautas cadastradas no sistema, não recebe paramentros e retorna uma lista de Pauta
     * </p>
     *
     * @return List<PautaDTO> - Objeto no formato Json de retorno
     */
    @ApiOperation(value = "Consulta todas as pautas", notes = "Realiza a consulta de todas as pautas cadastradas no sistema, não recebe paramentros e retorna uma lista de Pauta")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de Pautas"),
            @ApiResponse(code = 404, message = "Não existe nenhuma pauta cadastrada no sistema")
    })
    @GetMapping(name = "Consulta todas as pautas",produces="application/json")
    public ResponseEntity<List<PautaDTO>> buscarTodas() {
        log.info("Buscando todas as pautas...");
        return ResponseEntity.ok(pautaUseCase.buscarTodasPautas());
    }


    /**
     * <p>
     * Metodo que realiza a consulta de de uma pauta com base no seu ID, recebe um ID como parametro de busca, retorna uma pauta
     * </p>
     *
     * @param pautaId
     * @return PautaDTO - Objeto no formato Json de retorno
     */
    @ApiOperation(value = "Consulta uma pauta por ID", notes = "Realiza a consulta de de uma pauta com base no seu ID, recebe um ID como parametro de busca")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma pauta"),
            @ApiResponse(code = 404, message = "Pauta não localizada.")
    })
    @GetMapping(value = "/{pautaId}", name = "Consulta uma pauta por Id", produces="application/json")
    public ResponseEntity<PautaDTO> buscarPorId(@PathVariable Long pautaId) {
        log.info("Buscando a pauta do ID: " + pautaId);
        return ResponseEntity.ok(pautaUseCase.buscarPorId(pautaId));
    }


    /**
     * <p>
     * Metodo que realiza o cadastro de uma nova pauta, recebe um request com dados a serem salvos no banco, retorna a pauta cadastrada
     * </p>
     *
     * @param pauta
     * @return PautaDTO - Objeto no formato Json de retorno
     */
    @ApiOperation(value = "Cria uma nova pauta", notes = "Realiza o cadastro de uma nova pauta, recebe um request com dados a serem salvos no banco, retorna a pauta cadastrada")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Pauta Criada")
    })
    @PostMapping(name = "Cria uma nova pauta",produces="application/json", consumes="application/json")
    public ResponseEntity<PautaDTO> salvar(@Valid @RequestBody PautaModelRequest pauta) {
        log.info("Criando uma nova pauta");
        return new ResponseEntity<>((pautaUseCase.salvar(pauta)), HttpStatus.CREATED);

    }


    /**
     * <p>
     * Metodo que edita uma pauta cadastrada no sistema com base no seu id
     * </p>
     *
     * @param pauta
     * @param pautaId
     * @return PautaDTO - Objeto no formato Json de retorno
     */
    @ApiOperation(value = "Edita uma pauta existente", notes = "Realiza a edição uma pauta cadastrada no sistema com base no seu id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Pauta não localizada.")
    })
    @PatchMapping(value = "/{pautaId}", name = "Edita uma pauta existente",produces="application/json", consumes="application/json")
    public ResponseEntity<PautaDTO> atualizarPauta(@Valid @ApiParam(value = "Dados da pauta a ser editada") @RequestBody PautaModelRequest pauta, @PathVariable Long pautaId) {
        log.info("Editando a pauta: " + pauta.getTitulo());
        return ResponseEntity.ok(pautaUseCase.atualizarPauta(pauta, pautaId));
    }


    /**
     * <p>
     * Metodo que abre a sessão de votação para uma pauta já existente no sistema
     * </p>
     *
     * @param pautaAberturaModelRequest
     * @param pautaId
     * @return PautaDTO - Objeto no formato Json de retorno
     */
    @ApiOperation(value = "Abre uma sessão de votação", notes = "Abre a sessão de votação para uma pauta já existente no sistema")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "O formato da hora digitado é inválido, por favor digite no formato 'HHH:MM'."),
            @ApiResponse(code = 400, message = "Utilizar apenas números para hora e minuto, por favor digite no formato 'HHH:MM'."),
            @ApiResponse(code = 400, message = "A quantidade de minutos é inválida.")
    })
    @PatchMapping(value = "/abrir/{pautaId}", name = "Abre uma votação para uma pauta existente",produces="application/json", consumes="application/json")
    public ResponseEntity<PautaDTO> abrirVotacaoPauta(@Valid @ApiParam(value = "Altera uma pauta para aberta ou fechada e define o tempo que ficará aberta")
                                                      @RequestBody PautaAberturaModelRequest pautaAberturaModelRequest, @PathVariable Long pautaId) {
        log.info("Abrindo uma sessão de votação para a pauta" + pautaId);
        return ResponseEntity.ok(pautaUseCase.abrirPauta(pautaAberturaModelRequest, pautaId));
    }

}
