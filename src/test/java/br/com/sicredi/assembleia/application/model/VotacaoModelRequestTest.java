package br.com.sicredi.assembleia.application.model;

import org.junit.jupiter.api.*;

class VotacaoModelRequestTest {
    VotacaoModelRequest votacaoModelRequest;
    private String usuarioCpf;
    private Long pautaId;
    private Integer voto;

    @BeforeEach
    void setUp() {
        this.votacaoModelRequest = VotacaoModelRequest.builder().usuarioCpf(this.usuarioCpf).pautaId(this.pautaId).voto(this.voto).build();
    }

    @Test
    @DisplayName("Teste PautaModelRequest getters")
    @Tag("unit")
    void gettersSucesso() {
        Assertions.assertEquals(this.usuarioCpf, this.votacaoModelRequest.getUsuarioCpf());
        Assertions.assertEquals(this.pautaId, this.votacaoModelRequest.getPautaId());
        Assertions.assertEquals(this.voto, this.votacaoModelRequest.getVoto());
    }

}
