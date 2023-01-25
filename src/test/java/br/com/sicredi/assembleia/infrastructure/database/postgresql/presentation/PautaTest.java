package br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation;

import br.com.sicredi.assembleia.application.dto.PautaDTO;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

class PautaTest {
    Pauta pauta;
    Long pautaId = 1L;
    String titulo = "TITULO";
    String status = "STATUS";
    String descricao = "DESCRIÇÃO";
    LocalDateTime horaAbertura = LocalDateTime.now();
    LocalDateTime horaFechamento = LocalDateTime.now().plusMinutes(5);
    int quantidadeVotosSim = 5;
    int quantidadeVotosNao = 4;

    @BeforeEach
    void setUp(){
        this.pauta = Pauta.builder().pautaId(this.pautaId).titulo(this.titulo).status(this.status).descricao(this.descricao).horaAbertura(this.horaAbertura).horaFechamento(this.horaFechamento).quantidadeVotosNao(this.quantidadeVotosNao).quantidadeVotosSim(this.quantidadeVotosSim).build();
    }

    @Test
    @DisplayName("Teste Pauta getters")
    @Tag("unit")
    void gettersSucesso() {
        Assertions.assertEquals(this.pautaId, this.pauta.getPautaId());
        Assertions.assertEquals(this.titulo, this.pauta.getTitulo());
        Assertions.assertEquals(this.status, this.pauta.getStatus());
        Assertions.assertEquals(this.descricao, this.pauta.getDescricao());
        Assertions.assertEquals(this.horaAbertura, this.pauta.getHoraAbertura());
        Assertions.assertEquals(this.horaFechamento, this.pauta.getHoraFechamento());
        Assertions.assertEquals(this.quantidadeVotosSim, this.pauta.getQuantidadeVotosSim());
        Assertions.assertEquals(this.quantidadeVotosNao, this.pauta.getQuantidadeVotosNao());
    }

    @Test
    @DisplayName("Test Pauta setters")
    @Tag("unit")
    void settersSucesso() {
        Long pautaIdNovo = 2L;
        String tituloNovo = "TITULO NOVO";
        String statusNovo = "STATUS NOVO";
        String descricaoNovo = "DESCRIÇÃO NOVO";
        LocalDateTime horaAberturaNovo = LocalDateTime.now();
        LocalDateTime horaFechamentoNovo = LocalDateTime.now().plusMinutes(5);
        int quantidadeVotosSimNovo = 2;
        int quantidadeVotosNaoNovo = 3;
        this.pauta.setPautaId(pautaIdNovo);
        this.pauta.setTitulo(tituloNovo);
        this.pauta.setStatus(statusNovo);
        this.pauta.setDescricao(descricaoNovo);
        this.pauta.setHoraAbertura(horaAberturaNovo);
        this.pauta.setHoraFechamento(horaFechamentoNovo);
        this.pauta.setQuantidadeVotosSim(quantidadeVotosSimNovo);
        this.pauta.setQuantidadeVotosNao(quantidadeVotosNaoNovo);
        Assertions.assertEquals(pautaIdNovo, this.pauta.getPautaId());
        Assertions.assertEquals(statusNovo, this.pauta.getStatus());
        Assertions.assertEquals(horaAberturaNovo, this.pauta.getHoraAbertura());
        Assertions.assertEquals(quantidadeVotosSimNovo, this.pauta.getQuantidadeVotosSim());

    }
}
