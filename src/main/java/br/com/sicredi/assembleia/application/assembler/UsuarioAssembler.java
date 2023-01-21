package br.com.sicredi.assembleia.application.assembler;

import br.com.sicredi.assembleia.application.dto.PautaDTO;
import br.com.sicredi.assembleia.application.dto.UsuarioDTO;
import br.com.sicredi.assembleia.infrastructure.database.presentation.Pauta;
import br.com.sicredi.assembleia.infrastructure.database.presentation.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UsuarioAssembler {

    ModelMapper mapper = new ModelMapper();

    public UsuarioDTO toUsuarioDTO(Usuario usuario) {
        return mapper.map(usuario, UsuarioDTO.class);
    }

}
