package br.com.sicredi.assembleia.application.validator;

import br.com.sicredi.assembleia.infrastructure.database.presentation.Pauta;
import br.com.sicredi.assembleia.userinterface.exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component

public class PautaValidator {

    public Pauta pautaExiste(Optional<Pauta> pauta) {
        if (pauta.isEmpty()) {
            throw new NotFoundException("Pauta não localizada.");
        }else {
            return pauta.get();
        }
    }
}
