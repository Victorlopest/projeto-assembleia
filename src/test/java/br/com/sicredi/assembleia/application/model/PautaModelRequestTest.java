package br.com.sicredi.assembleia.application.model;

import org.junit.jupiter.api.*;

class PautaModelRequestTest {
    PautaModelRequest pautaModelRequest;
    Long pautaId = 1L;
    String titulo = "TITULO";
    String descricao = "DESCRICAO";

    @BeforeEach
    void setUp() {
        this.pautaModelRequest = PautaModelRequest.builder().pautaId(this.pautaId).titulo(this.titulo).descricao(this.descricao).build();
    }

    @Test
    @DisplayName("Teste PautaModelRequest getters")
    @Tag("unit")
    void gettersSucesso() {
        Assertions.assertEquals(this.pautaId, this.pautaModelRequest.getPautaId());
        Assertions.assertEquals(this.titulo, this.pautaModelRequest.getTitulo());
        Assertions.assertEquals(this.descricao, this.pautaModelRequest.getDescricao());
    }

}
