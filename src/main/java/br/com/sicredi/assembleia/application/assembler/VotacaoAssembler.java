package br.com.sicredi.assembleia.application.assembler;

import br.com.sicredi.assembleia.application.dto.VotacaoDTO;
import br.com.sicredi.assembleia.application.model.VotacaoModelRequest;
import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Pauta;
import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Votacao;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * PautaAssembler - Assembler
 * <p>
 * Essa classe e responsavel por receber uma classe, mapear ela em outra e
 * retorna-la.
 * </p>
 *
 */
@Component
public class VotacaoAssembler {

    ModelMapper mapper = new ModelMapper();

    public VotacaoDTO votacaoParaVotacaoDTO(Votacao votacao) {
        VotacaoDTO votacaoDTO = mapper.map(votacao, VotacaoDTO.class);
        votacaoDTO.setTicketVotacao(votacao.getVotacaoId());
        votacaoDTO.setPautaId(votacao.getPauta().getPautaId());
        return votacaoDTO;
    }

    public Votacao votacaoRequestParaVotacao(VotacaoModelRequest votacaoModelRequest, Pauta pauta) {
        Votacao votacao = mapper.map(votacaoModelRequest, Votacao.class);
        votacao.setPauta(pauta);
        return votacao;
    }



}
