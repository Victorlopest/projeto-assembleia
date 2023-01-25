package br.com.sicredi.assembleia.application.validator;

import br.com.sicredi.assembleia.application.dto.PautaDTO;
import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Pauta;
import br.com.sicredi.assembleia.userinterface.exception.ApiException;
import br.com.sicredi.assembleia.userinterface.exception.CpfException;
import br.com.sicredi.assembleia.userinterface.exception.FormatoHoraException;
import br.com.sicredi.assembleia.userinterface.exception.NaoEncontradoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class VotacaoValidatorTest {

    VotacaoValidator votacaoValidator;

    VotacaoValidatorTest() {
    }

    @BeforeEach
    void setUp() {
        this.votacaoValidator = new VotacaoValidator();
    }

    @Test
    void verificaSeCpfAptoOuInaptoAleatorioSucesso() {
        Assertions.assertDoesNotThrow(() -> {
            votacaoValidator.verificaSeCpfAptoOuInaptoAleatorio(65);
        });
    }

    @Test
    void verificaSeVotacaoEstaAbertaApiExceptionInapto() {
        CpfException thrown = (CpfException) Assertions.assertThrows(CpfException.class, () -> {
            this.votacaoValidator.verificaSeCpfAptoOuInaptoAleatorio(50);
        }, "CpfException");
        Assertions.assertTrue(thrown.getMessage().contains("O CPF digitado não está apto para votar"));
    }
    @Test
    void verificaSeVotacaoEstaAbertaApiExceptionInvalido() {
        CpfException thrown = (CpfException) Assertions.assertThrows(CpfException.class, () -> {
            this.votacaoValidator.verificaSeCpfAptoOuInaptoAleatorio(10);
        }, "CpfException");
        Assertions.assertTrue(thrown.getMessage().contains("O CPF digitado é inválido"));
    }
    @Test
    void verificaSeVotacaoEstaAbertaSucesso() {
        Pauta pauta = Pauta.builder().pautaId(1L).titulo("titulo").status("ABERTA").descricao("DESCRICAO").horaAbertura(LocalDateTime.now()).horaFechamento(LocalDateTime.now().plusMinutes(5)).quantidadeVotosSim(2).quantidadeVotosNao(3).build();
        Assertions.assertDoesNotThrow(() -> {
            votacaoValidator.verificaSeVotacaoEstaAberta((pauta));
        });
    }

    @Test
    void verificaSeVotacaoEstaAbertaApiException() {
        Pauta pauta = Pauta.builder().pautaId(1L).titulo("titulo").status("FECHADA").descricao("DESCRICAO").horaAbertura(LocalDateTime.now()).horaFechamento(LocalDateTime.now().plusMinutes(5)).quantidadeVotosSim(2).quantidadeVotosNao(3).build();
        ApiException thrown = (ApiException) Assertions.assertThrows(ApiException.class, () -> {
            this.votacaoValidator.verificaSeVotacaoEstaAberta(pauta);
        }, "ApiException");
        Assertions.assertTrue(thrown.getMessage().contains("Não é possivel votar nessa pauta pois ela está fechada"));
    }

    @Test
    void verificaSeCpfJaVotouSucesso() {
        Assertions.assertDoesNotThrow(() -> {
            votacaoValidator.verificaSeCpfJaVotou((0));
        });
    }

    @Test
    void verificaSeCpfJaVotouCpfException() {
        CpfException thrown = (CpfException) Assertions.assertThrows(CpfException.class, () -> {
            this.votacaoValidator.verificaSeCpfJaVotou(1);
        }, "CpfException");
        Assertions.assertTrue(thrown.getMessage().contains("O CPF digitado já votou nessa pauta"));
    }
}

