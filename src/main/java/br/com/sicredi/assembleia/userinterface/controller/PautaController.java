package br.com.sicredi.assembleia.userinterface.controller;


import br.com.sicredi.assembleia.application.dto.PautaDTO;
import br.com.sicredi.assembleia.application.usecase.PautaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
