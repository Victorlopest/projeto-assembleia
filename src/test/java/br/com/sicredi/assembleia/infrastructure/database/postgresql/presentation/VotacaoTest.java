package br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation;

import br.com.sicredi.assembleia.application.dto.VotacaoDTO;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

class VotacaoTest {
    Votacao votacao;
    Long votacaoId = 1L;
    Pauta pauta = new Pauta();
    String usuarioCpf = "12345678901";
    Integer voto = 1;
    Pauta pautaCriada = new Pauta();

    @BeforeEach
    void setUp() {
        this.pautaCriada = Pauta.builder().pautaId(1L).titulo("titulo").status("FECHADA").descricao("DESCRICAO").horaAbertura(LocalDateTime.now()).horaFechamento(LocalDateTime.now().plusMinutes(5)).quantidadeVotosSim(2).quantidadeVotosNao(3).build();

        this.votacao = Votacao.builder().votacaoId(this.votacaoId).usuarioCpf(this.usuarioCpf).pauta(this.pautaCriada).voto(this.voto).build();
    }

    @Test
    @DisplayName("Teste VotacaoDTO getters")
    @Tag("unit")
    void gettersSucesso() {
        Assertions.assertEquals(this.votacaoId, this.votacao.getVotacaoId());
        Assertions.assertEquals(this.usuarioCpf, this.votacao.getUsuarioCpf());
        Assertions.assertEquals(this.pautaCriada, this.votacao.getPauta());
        Assertions.assertEquals(this.voto, this.votacao.getVoto());
    }

    @Test
    @DisplayName("Test VotacaoDTO setters")
    @Tag("unit")
    void settersSucesso() {
        Long votacaoIdNovo = 2L;
        String usuarioCpfNovo = "12345678999";
        Pauta pautaNovo = Pauta.builder().pautaId(2L).titulo("titulo").status("FECHADA").descricao("DESCRICAO").horaAbertura(LocalDateTime.now()).horaFechamento(LocalDateTime.now().plusMinutes(5)).quantidadeVotosSim(2).quantidadeVotosNao(3).build();
        Integer votoNovo = 2;
        this.votacao.setVotacaoId(votacaoIdNovo);
        this.votacao.setUsuarioCpf(usuarioCpfNovo);
        this.votacao.setPauta(pautaNovo);
        this.votacao.setVoto(votoNovo);
        Assertions.assertEquals(votacaoIdNovo, this.votacao.getVotacaoId());
        Assertions.assertEquals(usuarioCpfNovo, this.votacao.getUsuarioCpf());
        Assertions.assertEquals(pautaNovo, this.votacao.getPauta());
        Assertions.assertEquals(votoNovo, this.votacao.getVoto());

    }
}
