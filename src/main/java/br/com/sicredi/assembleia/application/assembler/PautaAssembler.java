package br.com.sicredi.assembleia.application.assembler;

import br.com.sicredi.assembleia.application.dto.PautaDTO;
import br.com.sicredi.assembleia.application.model.PautaModelRequest;
import br.com.sicredi.assembleia.infrastructure.database.postgresql.presentation.Pauta;
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
public class PautaAssembler {

    ModelMapper mapper = new ModelMapper();

    public PautaDTO pautaParaPautaDTO(Pauta pauta) {
        return mapper.map(pauta, PautaDTO.class);
    }
    public Pauta pautaRequestParaPauta(PautaModelRequest pauta) {
        return mapper.map(pauta, Pauta.class);
    }



}
