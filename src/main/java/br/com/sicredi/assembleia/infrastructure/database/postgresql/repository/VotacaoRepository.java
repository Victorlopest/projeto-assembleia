package br.com.sicredi.assembleia.infrastructure.database.postgresql.repository;

import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Long> {

    @Query("SELECT COUNT(v) FROM Votacao v WHERE v.pauta.pautaId =:id AND v.usuarioCpf =:cpf")
    int quantidadeVotosCpfPorPauta(Long id, String cpf);
    @Query("SELECT COUNT(v) FROM Votacao v  WHERE v.voto = 1")
    int retornaTotalVotosSim();
    @Query("SELECT COUNT(v) FROM Votacao v WHERE v.voto = 2")
    int retornaTotalVotosNao();

}
