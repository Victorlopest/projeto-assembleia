package br.com.sicredi.assembleia.application.validator;

import br.com.sicredi.assembleia.application.dto.PautaDTO;
import br.com.sicredi.assembleia.application.dto.UsuarioDTO;
import br.com.sicredi.assembleia.infrastructure.database.presentation.Pauta;
import br.com.sicredi.assembleia.infrastructure.database.presentation.Usuario;
import br.com.sicredi.assembleia.userinterface.exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component

public class UsuarioValidator {

    public Usuario verificaSeUsuarioExiste(Optional<Usuario> usuario) {
        if (usuario.isEmpty()) {
            throw new NotFoundException("Usuário não localizado.");
        }else {
            return usuario.get();
        }
    }

    public List<UsuarioDTO> verificaSeListaUsuariosEstaVazia(List<UsuarioDTO> usuarioDTOList) {
        if (usuarioDTOList.isEmpty()) {
            throw new NotFoundException("Não existe nenhum usuário cadastrado no sistema");
        }else {
            return usuarioDTOList;
        }
    }

    public void verificaSeUsuarioExisteVoid(Optional<Usuario> usuario) {
        if (usuario.isEmpty()) {
            throw new NotFoundException("Usuário não localizado.");
        }
    }

//    public Pauta validaCamposEntrada(Pauta pauta){
//
//    }
}
