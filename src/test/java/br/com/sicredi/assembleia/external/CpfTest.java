package br.com.sicredi.assembleia.external;

import br.com.sicredi.assembleia.external.Cpf;
import org.junit.jupiter.api.*;

class CpfTest {
    Cpf cpf;
    String status = "ABLE";

    @BeforeEach
    void setUp() {
        this.cpf = Cpf.builder().status(this.status).build();
    }

    @Test
    @DisplayName("Teste Cpf getters")
    @Tag("unit")
    void gettersSucesso() {
        Assertions.assertEquals(this.status, this.cpf.getStatus());
    }

    @Test
    @DisplayName("Test Cpf setters")
    @Tag("unit")
    void settersSucesso() {
        String statusNovo = "UNABLE";
        this.cpf.setStatus(statusNovo);
        Assertions.assertEquals(statusNovo, this.cpf.getStatus());

    }
}
