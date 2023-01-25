package br.com.sicredi.assembleia.application.assembler;

import br.com.sicredi.assembleia.application.dto.PautaDTO;
import br.com.sicredi.assembleia.application.model.PautaModelRequest;
import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Pauta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class PautaAssemblerTest {

    private final PautaAssembler pautaAssembler = new PautaAssembler();
    @Test
    @DisplayName("Teste pauta para pautaDTO")
    @Tag("unit")
    void pautaParaPautaDTO(){
        Pauta pauta = Pauta.builder()
                .pautaId(1L)
                .titulo("titulo")
                .status("FECHADA")
                .descricao("DESCRICAO")
                .horaAbertura(LocalDateTime.now())
                .horaFechamento(LocalDateTime.now().plusMinutes(5))
                .quantidadeVotosSim(2)
                .quantidadeVotosNao(3)
                .build();
        PautaDTO pautaDTO = this.pautaAssembler.pautaParaPautaDTO(pauta);
        Assertions.assertEquals(1, pautaDTO.getPautaId());
        Assertions.assertEquals(pauta.getTitulo(), pautaDTO.getTitulo());

    }

    @Test
    @DisplayName("Teste pautaModelRequest para Pauta")
    @Tag("unit")
    void pautaRequestParaPauta(){
        PautaModelRequest pautaModelRequest = PautaModelRequest.builder()
                .pautaId(null)
                .titulo("titulo")
                .descricao("DESCRICAO")
                .build();
        Pauta pauta = this.pautaAssembler.pautaRequestParaPauta(pautaModelRequest);
        Assertions.assertEquals("titulo", pauta.getTitulo());
        Assertions.assertEquals(pautaModelRequest.getDescricao(), pauta.getDescricao());

    }
}
