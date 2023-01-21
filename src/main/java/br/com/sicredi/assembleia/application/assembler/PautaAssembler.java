package br.com.sicredi.assembleia.application.assembler;

import br.com.sicredi.assembleia.application.dto.PautaDTO;
import br.com.sicredi.assembleia.infrastructure.database.presentation.Pauta;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PautaAssembler {

    ModelMapper mapper = new ModelMapper();

    public PautaDTO toPautaDTO(Pauta pauta) {
        return mapper.map(pauta, PautaDTO.class);
    }

}
