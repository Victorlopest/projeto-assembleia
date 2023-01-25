package br.com.sicredi.assembleia.application.assembler;

import br.com.sicredi.assembleia.application.dto.PautaDTO;
import br.com.sicredi.assembleia.application.dto.VotacaoDTO;
import br.com.sicredi.assembleia.application.model.PautaModelRequest;
import br.com.sicredi.assembleia.application.model.VotacaoModelRequest;
import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Pauta;
import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Votacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class VotacaoAssemblerTest {

    private final VotacaoAssembler votacaoAssembler = new VotacaoAssembler();
    @Test
    @DisplayName("Teste Votacao para VotacaoDTO")
    @Tag("unit")
    void votacaoParaVotacaoDTO(){
        Pauta pauta = Pauta.builder()
                .pautaId(20L)
                .titulo("titulo")
                .status("FECHADA")
                .descricao("DESCRICAO")
                .horaAbertura(LocalDateTime.now())
                .horaFechamento(LocalDateTime.now().plusMinutes(5))
                .quantidadeVotosSim(2)
                .quantidadeVotosNao(3)
                .build();
        Votacao votacao = Votacao.builder().votacaoId(1L)
                .usuarioCpf("12345678910")
                .pauta(pauta)
                .voto(1)
                .build();

        VotacaoDTO votacaoDTO = this.votacaoAssembler.votacaoParaVotacaoDTO(votacao);
        Assertions.assertEquals(1, votacaoDTO.getTicketVotacao());
        Assertions.assertEquals(20, votacaoDTO.getPautaId());
        Assertions.assertEquals(votacao.getUsuarioCpf(), votacaoDTO.getUsuarioCpf());

    }

    @Test
    @DisplayName("Teste VotacaoRequest para Votacao")
    @Tag("unit")
    void votacaoRequestParaVotacao(){
        Pauta pauta = Pauta.builder()
                .pautaId(20L)
                .titulo("titulo")
                .status("FECHADA")
                .descricao("DESCRICAO")
                .horaAbertura(LocalDateTime.now())
                .horaFechamento(LocalDateTime.now().plusMinutes(5))
                .quantidadeVotosSim(2)
                .quantidadeVotosNao(3)
                .build();
        VotacaoModelRequest votacaoModelRequest = VotacaoModelRequest.builder()
                .usuarioCpf("12345678910")
                .pautaId(20L)
                .voto(1)
                .build();

        Votacao votacao = this.votacaoAssembler.votacaoRequestParaVotacao(votacaoModelRequest, pauta);
        Assertions.assertEquals(1, votacao.getVoto());
        Assertions.assertEquals("12345678910", votacao.getUsuarioCpf());
        Assertions.assertEquals(votacao.getPauta().getPautaId(), pauta.getPautaId());

    }


}
