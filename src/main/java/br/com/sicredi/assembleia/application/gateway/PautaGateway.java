package br.com.sicredi.assembleia.application.gateway;

import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Pauta;

import java.util.List;
import java.util.Optional;

public interface PautaGateway {
    List<Pauta> buscarTodos();

    Optional<Pauta> buscarPorId(Long id);

    Pauta salvar(Pauta pauta);
}
