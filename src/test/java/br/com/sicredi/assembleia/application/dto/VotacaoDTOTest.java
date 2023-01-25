package br.com.sicredi.assembleia.application.dto;

import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

class VotacaoDTOTest {
    VotacaoDTO votacaoDTO;
    Long ticketVotacao = 1L;
    String usuarioCpf = "12345678901";
    Long pautaId = 20L;
    Integer voto = 1;

    @BeforeEach
    void setUp() {
        this.votacaoDTO = VotacaoDTO.builder().ticketVotacao(this.ticketVotacao).usuarioCpf(this.usuarioCpf).pautaId(this.pautaId).voto(this.voto).build();
    }

    @Test
    @DisplayName("Teste VotacaoDTO getters")
    @Tag("unit")
    void gettersSucesso() {
        Assertions.assertEquals(this.ticketVotacao, this.votacaoDTO.getTicketVotacao());
        Assertions.assertEquals(this.usuarioCpf, this.votacaoDTO.getUsuarioCpf());
        Assertions.assertEquals(this.pautaId, this.votacaoDTO.getPautaId());
        Assertions.assertEquals(this.voto, this.votacaoDTO.getVoto());
    }

    @Test
    @DisplayName("Test VotacaoDTO setters")
    @Tag("unit")
    void settersSucesso() {
        Long ticketVotacaoNovo = 2L;
        String usuarioCpfNovo = "12345678999";
        Long pautaIdNovo = 10L;
        Integer votoNovo = 2;
        this.votacaoDTO.setTicketVotacao(ticketVotacaoNovo);
        this.votacaoDTO.setUsuarioCpf(usuarioCpfNovo);
        this.votacaoDTO.setPautaId(pautaIdNovo);
        this.votacaoDTO.setVoto(votoNovo);
        Assertions.assertEquals(ticketVotacaoNovo, this.votacaoDTO.getTicketVotacao());
        Assertions.assertEquals(usuarioCpfNovo, this.votacaoDTO.getUsuarioCpf());
        Assertions.assertEquals(pautaIdNovo, this.votacaoDTO.getPautaId());
        Assertions.assertEquals(votoNovo, this.votacaoDTO.getVoto());

    }
}
