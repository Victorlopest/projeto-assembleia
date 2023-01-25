package br.com.sicredi.assembleia.infrastructure.database.postgresql.repository;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public interface PautaRepositoryTest {
}
