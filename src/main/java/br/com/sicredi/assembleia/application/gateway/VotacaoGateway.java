package br.com.sicredi.assembleia.application.gateway;

import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Votacao;

public interface VotacaoGateway {
    int quantidadeVotosCpfPorPauta(Long id, String cpf);

    int retornaTotalVotosSim();

    int retornaTotalVotosNao();

    Votacao salvar(Votacao votacao);
}
