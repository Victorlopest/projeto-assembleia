package br.com.sicredi.assembleia.application.validator;

import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Pauta;
import br.com.sicredi.assembleia.userinterface.exception.ApiException;
import br.com.sicredi.assembleia.userinterface.exception.CpfException;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component

public class VotacaoValidator {

    /**
     * <p>
     * Metodo responsável por verificar se o CPF está aptou ou inapto para o voto com base em um numero random gerado passado por parametro.
     * esse metodo foi criado para simular a chamada externa que não está funcionando.
     *
     * </p>
     *
     * @param numeroAleatorio
     */
    public void verificaSeCpfAptoOuInaptoAleatorio(int numeroAleatorio) {
        if (numeroAleatorio < 20) {
            throw new CpfException("O CPF digitado é inválido");
        } else if (numeroAleatorio < 60) {
            throw new CpfException("O CPF digitado não está apto para votar");
        }
    }

    /**
     * <p>
     * Metodo responsável por verificar se a votação está com status aberta antes de cada input de votação
     *
     * </p>
     *
     * @param pauta
     */
    public void verificaSeVotacaoEstaAberta(Pauta pauta) {
        if (pauta.getStatus().equals("FECHADA")) {
            throw new ApiException("Não é possivel votar nessa pauta pois ela está fechada");
        }
    }

    /**
     * <p>
     * Metodo responsável por verificar se o CPF já votou naquela sessão de votação
     * recebe um inteiro que é gerado na outra classe com base em uma Query para contagem do registro do CPF+PautaId no banco;
     *
     * </p>
     *
     * @param votacao
     */
    public void verificaSeCpfJaVotou(int votacao) {
        if (votacao >= 1) {
            throw new CpfException("O CPF digitado já votou nessa pauta");
        }
    }
}

