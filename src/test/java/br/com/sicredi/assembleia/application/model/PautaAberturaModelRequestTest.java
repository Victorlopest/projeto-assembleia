package br.com.sicredi.assembleia.application.model;

import br.com.sicredi.assembleia.application.dto.VotacaoDTO;
import org.junit.jupiter.api.*;

class PautaAberturaModelRequestTest {
    PautaAberturaModelRequest pautaAberturaModelRequest;
    String horasVotacaoAberta = "000:20";

    @BeforeEach
    void setUp() {
        this.pautaAberturaModelRequest = PautaAberturaModelRequest.builder().horasVotacaoAberta(this.horasVotacaoAberta).build();
    }

    @Test
    @DisplayName("Teste PautaAberturaModelRequest getters")
    @Tag("unit")
    void gettersSucesso() {
        Assertions.assertEquals(this.horasVotacaoAberta, this.pautaAberturaModelRequest.getHorasVotacaoAberta());
    }

}
