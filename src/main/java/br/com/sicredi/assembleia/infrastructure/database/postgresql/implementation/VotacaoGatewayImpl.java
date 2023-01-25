package br.com.sicredi.assembleia.infrastructure.database.postgresql.implementation;

import br.com.sicredi.assembleia.application.gateway.VotacaoGateway;
import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Votacao;
import br.com.sicredi.assembleia.infrastructure.database.postgresql.repository.VotacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class VotacaoGatewayImpl implements VotacaoGateway {

    private final VotacaoRepository votacaoRepository;

    @Override
    public int quantidadeVotosCpfPorPauta(Long id, String cpf) {
        return votacaoRepository.quantidadeVotosCpfPorPauta(id, cpf);
    }

    @Override
    public int retornaTotalVotosSim() {
        return votacaoRepository.retornaTotalVotosSim();
    }
    @Override
    public int retornaTotalVotosNao() {
        return votacaoRepository.retornaTotalVotosNao();
    }

    @Override
    public Votacao salvar(Votacao votacao) {
        return votacaoRepository.save(votacao);
    }

}
