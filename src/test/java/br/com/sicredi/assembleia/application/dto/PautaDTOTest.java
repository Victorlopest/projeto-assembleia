package br.com.sicredi.assembleia.application.dto;

import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

class PautaDTOTest {
    PautaDTO pautaDTO;
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
        this.pautaDTO = PautaDTO.builder().pautaId(this.pautaId).titulo(this.titulo).status(this.status).descricao(this.descricao).horaAbertura(this.horaAbertura).horaFechamento(this.horaFechamento).quantidadeVotosNao(this.quantidadeVotosNao).quantidadeVotosSim(this.quantidadeVotosSim).build();
    }

    @Test
    @DisplayName("Teste PautaDTO getters")
    @Tag("unit")
    void gettersSucesso() {
        Assertions.assertEquals(this.pautaId, this.pautaDTO.getPautaId());
        Assertions.assertEquals(this.titulo, this.pautaDTO.getTitulo());
        Assertions.assertEquals(this.status, this.pautaDTO.getStatus());
        Assertions.assertEquals(this.descricao, this.pautaDTO.getDescricao());
        Assertions.assertEquals(this.horaAbertura, this.pautaDTO.getHoraAbertura());
        Assertions.assertEquals(this.horaFechamento, this.pautaDTO.getHoraFechamento());
        Assertions.assertEquals(this.quantidadeVotosSim, this.pautaDTO.getQuantidadeVotosSim());
        Assertions.assertEquals(this.quantidadeVotosNao, this.pautaDTO.getQuantidadeVotosNao());
    }

    @Test
    @DisplayName("Test PautaDTO setters")
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
        this.pautaDTO.setPautaId(pautaIdNovo);
        this.pautaDTO.setTitulo(tituloNovo);
        this.pautaDTO.setStatus(statusNovo);
        this.pautaDTO.setDescricao(descricaoNovo);
        this.pautaDTO.setHoraAbertura(horaAberturaNovo);
        this.pautaDTO.setHoraFechamento(horaFechamentoNovo);
        this.pautaDTO.setQuantidadeVotosSim(quantidadeVotosSimNovo);
        this.pautaDTO.setQuantidadeVotosNao(quantidadeVotosNaoNovo);
        Assertions.assertEquals(pautaIdNovo, this.pautaDTO.getPautaId());
        Assertions.assertEquals(statusNovo, this.pautaDTO.getStatus());
        Assertions.assertEquals(horaAberturaNovo, this.pautaDTO.getHoraAbertura());
        Assertions.assertEquals(quantidadeVotosSimNovo, this.pautaDTO.getQuantidadeVotosSim());

    }
}
