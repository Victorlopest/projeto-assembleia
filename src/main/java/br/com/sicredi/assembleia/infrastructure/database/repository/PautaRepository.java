package br.com.sicredi.assembleia.infrastructure.database.repository;

import br.com.sicredi.assembleia.infrastructure.database.presentation.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {

}
