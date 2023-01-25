package br.com.sicredi.assembleia.infrastructure.database.postgresql.implementation;

import br.com.sicredi.assembleia.application.gateway.PautaGateway;
import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Pauta;
import br.com.sicredi.assembleia.infrastructure.database.postgresql.repository.PautaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class PautaGatewayImpl implements PautaGateway {

    private final PautaRepository pautaRepository;
    @Override
    public List<Pauta> buscarTodos() {
        return pautaRepository.findAll();
    }
    @Override
    public Optional<Pauta> buscarPorId(Long id) {
        return pautaRepository.findById(id);
    }
    @Override
    public Pauta salvar(Pauta pauta) {
        return pautaRepository.save(pauta);
    }

}
