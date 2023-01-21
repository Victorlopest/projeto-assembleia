package br.com.sicredi.assembleia.userinterface.controller;


import br.com.sicredi.assembleia.application.dto.PautaDTO;
import br.com.sicredi.assembleia.application.usecase.PautaUseCase;
import br.com.sicredi.assembleia.infrastructure.database.presentation.Pauta;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pautas")
@AllArgsConstructor
public class PautaController {

    private final PautaUseCase pautaUseCase;

    @GetMapping(name = "Consulta todas as pautas")
    public ResponseEntity<List<PautaDTO>> buscarTodas() {
        return ResponseEntity.ok(pautaUseCase.buscarTodasPautas());
    }

    @GetMapping(value = "/{pautaId}", name = "Consulta uma pauta por Id")
    public ResponseEntity<PautaDTO> buscarPorId(@PathVariable Long pautaId) {
        return ResponseEntity.ok(pautaUseCase.buscarPorId(pautaId));
    }

    @PostMapping(name = "Cria uma nova pauta")
    public Pauta save(@RequestBody Pauta pauta) {
        return pautaUseCase.salvar(pauta);

    }

    @PatchMapping(value = "/{pautaId}", name = "Edita uma pauta existente")
    public ResponseEntity<PautaDTO> atualizarPauta(@ApiParam(value = "Dados da pauta a ser editada") @RequestBody Pauta pauta, @PathVariable Long pautaId) {
        return ResponseEntity.ok(pautaUseCase.atualizarPauta(pauta, pautaId));
    }

    @PatchMapping(value = "/abrir/{pautaId}", name = "Abre uma votação para uma pauta existente")
    public ResponseEntity<PautaDTO> abrirVotacaoPauta(@ApiParam(value = "Altera uma pauta para aberta ou fechada") @RequestBody Pauta pauta, @PathVariable Long pautaId) {
        return ResponseEntity.ok(pautaUseCase.atualizarPauta(pauta, pautaId));
    }

}
