package br.com.sicredi.assembleia.application.validator;

import br.com.sicredi.assembleia.application.dto.PautaDTO;
import br.com.sicredi.assembleia.infrastructure.database.presentation.Pauta;
import br.com.sicredi.assembleia.userinterface.exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component

public class PautaValidator {

    public Pauta verificaSePautaExiste(Optional<Pauta> pauta) {
        if (pauta.isEmpty()) {
            throw new NotFoundException("Pauta não localizada.");
        }else {
            return pauta.get();
        }
    }

    public List<PautaDTO> verificaSeListaPautasEstaVazia(List<PautaDTO> pautaDTOList) {
        if (pautaDTOList.isEmpty()) {
            throw new NotFoundException("Não existe nenhuma pauta cadastrada no sistema");
        }else {
            return pautaDTOList;
        }
    }

    public void verificaSePautaExisteVoid(Optional<Pauta> pauta) {
        if (pauta.isEmpty()) {
            throw new NotFoundException("Pauta não localizada.");
        }
    }

//    public Pauta validaCamposEntrada(Pauta pauta){
//
//    }
}
