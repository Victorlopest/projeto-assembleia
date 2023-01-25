package br.com.sicredi.assembleia.infrastructure.database.postgresql.implementation;

import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Pauta;
import br.com.sicredi.assembleia.infrastructure.database.postgresql.repository.PautaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
class PautaGatewayImplTest {

    private PautaGatewayImpl gateway;
    private PautaRepository repository;
    private Pauta pauta;

    @BeforeEach
    void setUp(){
        gateway = mock(PautaGatewayImpl.class);
        repository = mock(PautaRepository.class);
        pauta = Pauta.builder().pautaId(1L).titulo("titulo").status("FECHADA").descricao("DESCRICAO").horaAbertura(LocalDateTime.now()).horaFechamento(LocalDateTime.now().plusMinutes(5)).quantidadeVotosSim(2).quantidadeVotosNao(3).build();

    }

    @Test
    void buscarTodos(){
        List<Pauta> pautas = new ArrayList<>();
        pautas.add(pauta);
        when(gateway.buscarTodos()).thenReturn(pautas);
        var list = gateway.buscarTodos();
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void buscarPorId() {
        when(gateway.buscarPorId(1L)).thenReturn(Optional.of(pauta));

        var teste = gateway.buscarPorId(1L);
        Assertions.assertNotNull(teste);
        Assertions.assertEquals(1, teste.get().getPautaId());
    }
    @Test
    void salvar() {
        when(gateway.salvar(pauta)).thenReturn(pauta);
        var teste = gateway.salvar(pauta);
        Assertions.assertNotNull(teste);
        Assertions.assertEquals("titulo", teste.getTitulo());
    }

}
