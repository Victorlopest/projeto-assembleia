package br.com.sicredi.assembleia.application.usecase;

import br.com.sicredi.assembleia.application.assembler.VotacaoAssembler;
import br.com.sicredi.assembleia.application.dto.VotacaoDTO;
import br.com.sicredi.assembleia.application.gateway.VotacaoGateway;
import br.com.sicredi.assembleia.application.model.VotacaoModelRequest;
import br.com.sicredi.assembleia.application.validator.PautaValidator;
import br.com.sicredi.assembleia.application.validator.VotacaoValidator;
import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Pauta;
import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Votacao;
import br.com.sicredi.assembleia.infrastructure.database.postgresql.repository.PautaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class VotacaoUseCase {
    private PautaRepository pautaRepository;
    private VotacaoAssembler votacaoAssembler;
    private PautaValidator pautaValidator;
    private VotacaoGateway votacaoGateway;
    private VotacaoValidator votacaoValidator;
    private PautaUseCase pautaUseCase;

    /**
     * <p>
     * Metodo que realiza o cadastro de um voto em uma determinada pauta aberta
     * realiza validações de pauta para ver se ela está aberta, realiza validaçoes de CPF
     * para ver se o mesmo é válido e se for, se está apto ou não para o voto, valida se o CPF já votou nessa pauta
     * salva a votação e atualiza a quantidade de votos daquela pauta.
     * </p>
     *
     * @param votacaoModelRequest
     * @return VotacaoDTO - Objeto no formato Json de retorno
     */
    public VotacaoDTO salvar(VotacaoModelRequest votacaoModelRequest) {

        Optional<Pauta> pautaOptional = (pautaRepository.findById(votacaoModelRequest.getPautaId()));
        Pauta pauta = pautaValidator.verificaSePautaExiste(pautaOptional);
        pautaValidator.verificaVoto(votacaoModelRequest.getVoto());
//        String stauts = serviceCpf.validaCpf(votacaoModelRequest.getUsuarioCpf());
        Random numeroAleatorio = new Random();
        votacaoValidator.verificaSeCpfAptoOuInaptoAleatorio(numeroAleatorio.nextInt(100));
        pauta = pautaValidator.alteraStatusPauta(pauta);
        votacaoValidator.verificaSeVotacaoEstaAberta(pauta);
        int qtdVotacao = votacaoGateway.quantidadeVotosCpfPorPauta(pauta.getPautaId(), votacaoModelRequest.getUsuarioCpf());
        votacaoValidator.verificaSeCpfJaVotou(qtdVotacao);
        Votacao votacaoSalva = votacaoGateway.salvar(votacaoAssembler.votacaoRequestParaVotacao((votacaoModelRequest), pauta));
        pautaUseCase.atualizarContagemVotos(votacaoGateway.retornaTotalVotosSim(), votacaoGateway.retornaTotalVotosNao(), votacaoSalva.getPauta().getPautaId());
        return votacaoAssembler.votacaoParaVotacaoDTO(votacaoSalva);
    }

}
