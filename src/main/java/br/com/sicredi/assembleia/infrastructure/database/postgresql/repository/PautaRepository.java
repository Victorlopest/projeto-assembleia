package br.com.sicredi.assembleia.infrastructure.database.postgresql.repository;

import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {

}
