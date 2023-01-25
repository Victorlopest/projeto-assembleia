package br.com.sicredi.assembleia.application.validator;

import br.com.sicredi.assembleia.application.dto.PautaDTO;
import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Pauta;
import br.com.sicredi.assembleia.userinterface.exception.ApiException;
import br.com.sicredi.assembleia.userinterface.exception.FormatoHoraException;
import br.com.sicredi.assembleia.userinterface.exception.NaoEncontradoException;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component

public class PautaValidator {


    /**
     * <p>
     * Metodo valida se a pauta existe no sistema
     * </p>
     *
     * @param pauta
     * @return Pauta - Objeto no formato Json de retorno
     */
    public Pauta verificaSePautaExiste(Optional<Pauta> pauta) {
        if (pauta.isEmpty()) {
            throw new NaoEncontradoException("Pauta não localizada.");
        } else {
            return alteraStatusPauta(pauta.get());
        }
    }

    public void verificaVoto(Integer voto) {
        if (!(voto.equals(1) || (voto.equals(2)))) {
            throw new ApiException("O Voto deve ser 1 para SIM, 2 para NAO");
        }
    }

    /**
     * <p>
     * Metodo valida se uma lista de pauta está vazia
     * </p>
     *
     * @param pautaDTOList
     * @return List<PautaDTO> - Objeto no formato Json de retorno
     */
    public List<PautaDTO> verificaSeListaPautasEstaVazia(List<PautaDTO> pautaDTOList) {
        if (pautaDTOList.isEmpty()) {
            throw new NaoEncontradoException("Não existe nenhuma pauta cadastrada no sistema");
        } else {
            return pautaDTOList;
        }
    }

    /**
     * <p>
     * Metodo responsável por validar o tempo de abertura digitado pelo usuário e o formato do input.
     * </p>
     *
     * @param horasVotacaoAberta
     * @return Integer - Quantidade de minutos a ser aberto na pauta
     */
    public Integer verificaTempoAberturaPauta(String horasVotacaoAberta) {
        if (horasVotacaoAberta != null && !horasVotacaoAberta.isBlank()) {
            if (horasVotacaoAberta.length() != 6 ||
                    !horasVotacaoAberta.contains(":")) {
                throw new FormatoHoraException("O formato da hora digitado é inválido, por favor digite no formato 'HHH:MM'.");
            }
            int index = horasVotacaoAberta.indexOf(":");
            if (index != 3) {
                throw new FormatoHoraException("O formato da hora digitado é inválido, por favor digite no formato 'HHH:MM'.");
            }
            String[] horaMinuto = horasVotacaoAberta.split(":");
            if (!horaMinuto[0].matches("[0-9]*") || !horaMinuto[1].matches("[0-9]*")) {
                throw new FormatoHoraException("Utilizar apenas números para hora e minuto, por favor digite no formato 'HHH:MM'.");
            }
            int hora = Integer.parseInt(horaMinuto[0]);
            if (Integer.parseInt(horaMinuto[1]) > 59) {
                throw new FormatoHoraException("A quantidade de minutos é inválida.");
            }
            int minutos = Integer.parseInt(horaMinuto[1]);
            return ((hora * 60) + minutos);

        }
        return 1;
    }


    /**
     * <p>
     * Metodo responsável alterar o status da pauta para fechado se a hora de fechamento for menor que a hora atual.
     *
     * </p>
     *
     * @param pauta
     * @return Pauta - Objeto no formato Json de retornota
     */
    public Pauta alteraStatusPauta(Pauta pauta) {

        if (pauta.getHoraFechamento().isBefore(LocalDateTime.now())) {
            pauta.setStatus("FECHADA");
        }
        return pauta;
    }
}


