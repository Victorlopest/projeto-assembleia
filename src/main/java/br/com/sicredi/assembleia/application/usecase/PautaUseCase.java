package br.com.sicredi.assembleia.application.usecase;

import br.com.sicredi.assembleia.application.assembler.PautaAssembler;
import br.com.sicredi.assembleia.application.dto.PautaDTO;
import br.com.sicredi.assembleia.application.gateway.PautaGateway;
import br.com.sicredi.assembleia.application.model.PautaAberturaModelRequest;
import br.com.sicredi.assembleia.application.model.PautaModelRequest;
import br.com.sicredi.assembleia.application.validator.PautaValidator;
import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Pauta;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PautaUseCase {
    @Autowired
    private PautaGateway pautaGateway;
    @Autowired
    private PautaAssembler pautaAssembler;
    @Autowired
    private PautaValidator pautaValidator;

    /**
     * <p>
     * Metodo que realiza a consulta de todas as pautas cadastradas no sistema, não recebe paramentros e retorna uma lista de Pauta
     * </p>
     *
     * @return List<PautaDTO> - Objeto no formato Json de retorno
     */
    public List<PautaDTO> buscarTodasPautas() {
        List<PautaDTO> pautasDTO = new ArrayList<>();
        List<Pauta> pautas = pautaGateway.buscarTodos();
        for (Pauta pauta : pautas) {
            pautasDTO.add(pautaAssembler.pautaParaPautaDTO(pautaValidator.alteraStatusPauta(pauta)));

        }
        return pautaValidator.verificaSeListaPautasEstaVazia(pautasDTO);
    }

    /**
     * <p>
     * Metodo que realiza a consulta de de uma pauta com base no seu ID, recebe um ID como parametro de busca, retorna uma pauta
     * </p>
     *
     * @param pautaId
     * @return PautaDTO - Objeto no formato Json de retorno
     */
    public PautaDTO buscarPorId(Long pautaId) {

        Optional<Pauta> pauta = (pautaGateway.buscarPorId(pautaId));
        return pautaAssembler.pautaParaPautaDTO(pautaValidator.verificaSePautaExiste(pauta));
    }

    /**
     * <p>
     * Metodo que realiza o cadastro de uma nova pauta, recebe um request com dados a serem salvos no banco, retorna a pauta cadastrada
     * </p>
     *
     * @param pautaModelRequest
     * @return PautaDTO - Objeto no formato Json de retorno
     */
    public PautaDTO salvar(PautaModelRequest pautaModelRequest) {

        Pauta pautaSalva = pautaGateway.salvar(pautaAssembler.pautaRequestParaPauta(pautaModelRequest));
        return pautaAssembler.pautaParaPautaDTO(pautaSalva);
    }


    /**
     * <p>
     * Metodo que edita uma pauta cadastrada no sistema com base no seu id
     * </p>
     *
     * @param pautaRequest
     * @param pautaId
     * @return PautaDTO - Objeto no formato Json de retorno
     */
    public PautaDTO atualizarPauta(PautaModelRequest pautaRequest, Long pautaId) {

        Optional<Pauta> pautaOptional = (pautaGateway.buscarPorId(pautaId));
        Pauta pauta = pautaValidator.verificaSePautaExiste(pautaOptional);

        pauta.setPautaId(pautaId);
        pauta.setTitulo(pautaRequest.getTitulo());
        pauta.setDescricao(pautaRequest.getDescricao());

        return pautaAssembler.pautaParaPautaDTO(pautaGateway.salvar(pauta));
    }

    /**
     * <p>
     * Metodo que abre a sessão de votação para uma pauta já existente no sistema
     * </p>
     *
     * @param pautaAberturaModelRequest
     * @param pautaId
     * @return PautaDTO - Objeto no formato Json de retorno
     */
    public PautaDTO abrirPauta(PautaAberturaModelRequest pautaAberturaModelRequest, Long pautaId) {

        Optional<Pauta> pautaOptional = (pautaGateway.buscarPorId(pautaId));
        Pauta pautaAberta = pautaValidator.verificaSePautaExiste(pautaOptional);

        pautaAberta.setStatus("ABERTA");
        pautaAberta.setHoraAbertura(LocalDateTime.now());
        pautaAberta.setHoraFechamento(LocalDateTime.now().plusMinutes(pautaValidator.verificaTempoAberturaPauta(pautaAberturaModelRequest.getHorasVotacaoAberta())));
        return pautaAssembler.pautaParaPautaDTO(pautaGateway.salvar(pautaAberta));
    }

    /**
     * <p>
     * Metodo responsável por atualizar a contagem de votos na Pauta após cada chamada do endpoint de votação
     * </p>
     *
     * @param sim
     * @param nao
     * @param pautaId
     */
    public void atualizarContagemVotos(int sim, int nao, Long pautaId) {

        Optional<Pauta> pautaOptional = (pautaGateway.buscarPorId(pautaId));
        Pauta pautaVotos = pautaValidator.verificaSePautaExiste(pautaOptional);

        pautaVotos.setQuantidadeVotosSim(sim);
        pautaVotos.setQuantidadeVotosNao(nao);

        pautaGateway.salvar(pautaVotos);
    }
}