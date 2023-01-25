package br.com.sicredi.assembleia.application.usecase;

import br.com.sicredi.assembleia.application.assembler.PautaAssembler;
import br.com.sicredi.assembleia.application.dto.PautaDTO;
import br.com.sicredi.assembleia.application.gateway.PautaGateway;
import br.com.sicredi.assembleia.application.model.PautaAberturaModelRequest;
import br.com.sicredi.assembleia.application.model.PautaModelRequest;
import br.com.sicredi.assembleia.application.validator.PautaValidator;
import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Pauta;
import br.com.sicredi.assembleia.userinterface.exception.NaoEncontradoException;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

class PautaUseCaseTest {
    private PautaGateway pautaGateway;
    private PautaAssembler pautaAssembler;
    private PautaValidator pautaValidator;
    private PautaUseCase pautaUseCase;
    private Pauta pauta;
    private PautaDTO pautaDTO;


    public PautaUseCaseTest() {
    }

    @BeforeEach
    void setUp() {
        this.pautaAssembler = (PautaAssembler) Mockito.mock(PautaAssembler.class);
        this.pautaValidator = (PautaValidator) Mockito.mock(PautaValidator.class);
        this.pautaGateway = (PautaGateway) Mockito.mock(PautaGateway.class);
        this.pautaUseCase = new PautaUseCase(this.pautaGateway, this.pautaAssembler, this.pautaValidator);
        this.pauta = Pauta.builder().pautaId(1L).titulo("titulo").status("FECHADA").descricao("DESCRICAO").horaAbertura(LocalDateTime.now()).horaFechamento(LocalDateTime.now().plusMinutes(5)).quantidadeVotosSim(2).quantidadeVotosNao(3).build();
        this.pautaDTO = PautaDTO.builder().pautaId(1L).titulo("titulo").status("FECHADA").descricao("DESCRICAO").horaAbertura(LocalDateTime.now()).horaFechamento(LocalDateTime.now().plusMinutes(5)).quantidadeVotosSim(2).quantidadeVotosNao(3).build();
    }

    @Test
    @DisplayName("Teste PautaUseCase busca todas as pautas")
    @Tag("unit")
    void buscarTodasPautas() {
        List<PautaDTO> pautaListDto = new ArrayList<>();
        pautaListDto.add(pautaDTO);
        List<Pauta> pautaList = new ArrayList<>();
        pautaList.add(pauta);
        when(pautaGateway.buscarTodos()).thenReturn(pautaList);
        when(pautaAssembler.pautaParaPautaDTO(pauta)).thenReturn(pautaDTO);
        when(pautaValidator.alteraStatusPauta(pauta)).thenReturn(pauta);
        when(pautaValidator.verificaSeListaPautasEstaVazia(pautaListDto)).thenReturn(pautaListDto);
        pautaListDto = pautaUseCase.buscarTodasPautas();
        Assertions.assertEquals(1, pautaListDto.size());
    }
    @Test
    @DisplayName("Teste PautaUseCase salvar")
    @Tag("unit")
        void salvar() {
        Pauta pauta = new Pauta();
        pauta = this.pauta;
        PautaDTO pautaDTO = new PautaDTO();
        pautaDTO = this.pautaDTO;

        PautaModelRequest pautaModelRequest = new PautaModelRequest(1L, "titulo", "DESCRICAO");
        when(pautaGateway.salvar(pauta)).thenReturn(pauta);
        when(pautaAssembler.pautaParaPautaDTO(pauta)).thenReturn(pautaDTO);
        when(pautaAssembler.pautaRequestParaPauta(pautaModelRequest)).thenReturn(pauta);
        pautaDTO = pautaUseCase.salvar(pautaModelRequest);
        Assertions.assertEquals(pautaDTO.getPautaId(), pautaModelRequest.getPautaId());
    }
    @Test
    @DisplayName("Teste PautaUseCase busca por Id")
    @Tag("unit")
    void buscarPorId() {
        Optional<Pauta> pautaOptional = Optional.of(pauta);
        when(pautaGateway.buscarPorId(1L)).thenReturn(pautaOptional);
        when(pautaValidator.verificaSePautaExiste(pautaOptional)).thenReturn(pauta);
        when(pautaAssembler.pautaParaPautaDTO(pauta)).thenReturn(pautaDTO);
        PautaDTO pautaDTO = pautaUseCase.buscarPorId(1L);
        Assertions.assertEquals(pauta.getPautaId(), pautaDTO.getPautaId());
    }


}