package br.com.sicredi.assembleia.application.validator;

import br.com.sicredi.assembleia.application.dto.PautaDTO;
import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Pauta;
import br.com.sicredi.assembleia.userinterface.exception.FormatoHoraException;
import br.com.sicredi.assembleia.userinterface.exception.NaoEncontradoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class PautaValidatorTest {

    PautaValidator pautaValidator;

    PautaValidatorTest(){
    }

    @BeforeEach
    void setUp() {this.pautaValidator = new PautaValidator();}

    @Test
    void verificaSePautaExisteSucesso() {
        Pauta pauta = Pauta.builder().pautaId(1L).titulo("titulo").status("FECHADA").descricao("DESCRICAO").horaAbertura(LocalDateTime.now()).horaFechamento(LocalDateTime.now().plusMinutes(5)).quantidadeVotosSim(2).quantidadeVotosNao(3).build();
        Optional<Pauta> pautaOptional = Optional.of(pauta);
        Assertions.assertDoesNotThrow(() -> {
            return this.pautaValidator.verificaSePautaExiste((pautaOptional));
        });
    }
    @Test
    void verificaSePautaExisteErro() {
        Optional<Pauta> pautaOptional = Optional.empty();
        NaoEncontradoException thrown = (NaoEncontradoException)Assertions.assertThrows(NaoEncontradoException.class, () -> {
            this.pautaValidator.verificaSePautaExiste(pautaOptional);
        }, "NaoEncontradoException");
        Assertions.assertTrue(thrown.getMessage().contains("Pauta não localizada."));
    }

    @Test
    void verificaSeListaPautasEstaVaziaSucesso() {
        PautaDTO pautaDTO = PautaDTO.builder().pautaId(1L).titulo("titulo").status("FECHADA").descricao("DESCRICAO").horaAbertura(LocalDateTime.now()).horaFechamento(LocalDateTime.now().plusMinutes(5)).quantidadeVotosSim(2).quantidadeVotosNao(3).build();
        List<PautaDTO> pautaDTOList = new ArrayList<>();
        pautaDTOList.add(pautaDTO);
        Assertions.assertDoesNotThrow(() -> {
            return this.pautaValidator.verificaSeListaPautasEstaVazia((pautaDTOList));
        });
    }

    @Test
    void verificaSeListaPautasEstaVaziaErro() {
        List<PautaDTO> pautaDTOList = new ArrayList<>();
        NaoEncontradoException thrown = (NaoEncontradoException)Assertions.assertThrows(NaoEncontradoException.class, () -> {
            this.pautaValidator.verificaSeListaPautasEstaVazia(pautaDTOList);
        }, "NaoEncontradoException");
        Assertions.assertTrue(thrown.getMessage().contains("Não existe nenhuma pauta cadastrada no sistema"));
    }

    @Test
    void verificaTempoAberturaPautaSucesso() {
        String horasVotacaoAberta = "000:10";
        Assertions.assertDoesNotThrow(() -> {
        Integer retorno = pautaValidator.verificaTempoAberturaPauta(horasVotacaoAberta);
        Assertions.assertEquals(10, retorno);
        });
    }
    @Test
    void verificaTempoAberturaPautaNull() {
        String horasVotacaoAberta = null;
        Assertions.assertDoesNotThrow(() -> {
            Integer retorno = pautaValidator.verificaTempoAberturaPauta(horasVotacaoAberta);
            Assertions.assertEquals(1, retorno);
        });
    }

    @Test
    void verificaTempoAberturaPautaBlank() {
        String horasVotacaoAberta = "  ";
        Assertions.assertDoesNotThrow(() -> {
            Integer retorno = pautaValidator.verificaTempoAberturaPauta(horasVotacaoAberta);
            Assertions.assertEquals(1, retorno);
        });
    }

    @Test
    void verificaTempoAberturaPautaDiferenteSeisCasas() {
        String horasVotacaoAberta = "0:0";
        FormatoHoraException thrown = (FormatoHoraException)Assertions.assertThrows(FormatoHoraException.class, () -> {
            this.pautaValidator.verificaTempoAberturaPauta(horasVotacaoAberta);
        }, "FormatoHoraException");
        Assertions.assertTrue(thrown.getMessage().contains("O formato da hora digitado é inválido, por favor digite no formato 'HHH:MM'."));
    }

    @Test
    void verificaTempoAberturaPautaDiferenteDoisPontos() {
        String horasVotacaoAberta = "000.10";
        FormatoHoraException thrown = (FormatoHoraException)Assertions.assertThrows(FormatoHoraException.class, () -> {
            this.pautaValidator.verificaTempoAberturaPauta(horasVotacaoAberta);
        }, "FormatoHoraException");
        Assertions.assertTrue(thrown.getMessage().contains("O formato da hora digitado é inválido, por favor digite no formato 'HHH:MM'."));
    }

    @Test
    void verificaTempoAberturaPautaDiferenteIndex() {
        String horasVotacaoAberta = "00:010";
        FormatoHoraException thrown = (FormatoHoraException)Assertions.assertThrows(FormatoHoraException.class, () -> {
            this.pautaValidator.verificaTempoAberturaPauta(horasVotacaoAberta);
        }, "FormatoHoraException");
        Assertions.assertTrue(thrown.getMessage().contains("O formato da hora digitado é inválido, por favor digite no formato 'HHH:MM'."));
    }
    @Test
    void verificaTempoAberturaPautaSomenteNumeroHora() {
        String horasVotacaoAberta = "aaa:00";
        FormatoHoraException thrown = (FormatoHoraException)Assertions.assertThrows(FormatoHoraException.class, () -> {
            this.pautaValidator.verificaTempoAberturaPauta(horasVotacaoAberta);
        }, "FormatoHoraException");
        Assertions.assertTrue(thrown.getMessage().contains("Utilizar apenas números para hora e minuto, por favor digite no formato 'HHH:MM'."));
    }

    @Test
    void verificaTempoAberturaPautaSomenteNumeroMinuto() {
        String horasVotacaoAberta = "000:aa";
        FormatoHoraException thrown = (FormatoHoraException)Assertions.assertThrows(FormatoHoraException.class, () -> {
            this.pautaValidator.verificaTempoAberturaPauta(horasVotacaoAberta);
        }, "FormatoHoraException");
        Assertions.assertTrue(thrown.getMessage().contains("Utilizar apenas números para hora e minuto, por favor digite no formato 'HHH:MM'."));
    }

    @Test
    void verificaTempoAberturaPautaMinutoMais60() {
        String horasVotacaoAberta = "000:80";
        FormatoHoraException thrown = (FormatoHoraException)Assertions.assertThrows(FormatoHoraException.class, () -> {
            this.pautaValidator.verificaTempoAberturaPauta(horasVotacaoAberta);
        }, "FormatoHoraException");
        Assertions.assertTrue(thrown.getMessage().contains("A quantidade de minutos é inválida."));
    }

    @Test
    void verificaPautaAberta() {
        Pauta pauta = Pauta.builder().pautaId(1L).titulo("titulo").status("ABERTA").descricao("DESCRICAO").horaAbertura(LocalDateTime.now()).horaFechamento(LocalDateTime.now().minusDays(1)).quantidadeVotosSim(2).quantidadeVotosNao(3).build();

        Pauta pautaAtualizada = pautaValidator.alteraStatusPauta(pauta);
        Assertions.assertEquals( "FECHADA", pautaAtualizada.getStatus());
    }
}
