package br.com.sicredi.assembleia.application.usecase;

import br.com.sicredi.assembleia.application.assembler.PautaAssembler;
import br.com.sicredi.assembleia.application.assembler.UsuarioAssembler;
import br.com.sicredi.assembleia.application.dto.PautaDTO;
import br.com.sicredi.assembleia.application.dto.UsuarioDTO;
import br.com.sicredi.assembleia.application.validator.PautaValidator;
import br.com.sicredi.assembleia.application.validator.UsuarioValidator;
import br.com.sicredi.assembleia.infrastructure.database.presentation.Pauta;
import br.com.sicredi.assembleia.infrastructure.database.presentation.Usuario;
import br.com.sicredi.assembleia.infrastructure.database.repository.PautaRepository;
import br.com.sicredi.assembleia.infrastructure.database.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioUseCase {
    private UsuarioRepository usuarioRepository;
    private UsuarioAssembler usuarioAssembler;
    private UsuarioValidator usuarioValidator;

    public List<UsuarioDTO> buscarTodosUsuarios() {
        List<UsuarioDTO> usuarioDTO = new ArrayList<>();
        List<Usuario> usuarios = usuarioRepository.findAll();
        for (Usuario usuario : usuarios) {
            usuarioDTO.add(usuarioAssembler.toUsuarioDTO(usuario));
        }
        return usuarioValidator.verificaSeListaUsuariosEstaVazia(usuarioDTO);
    }

    public UsuarioDTO buscarPorId(Long usuarioId) {

        Optional<Usuario> usuario = (usuarioRepository.findById(usuarioId));
        return usuarioAssembler.toUsuarioDTO(usuarioValidator.verificaSeUsuarioExiste(usuario));
    }

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public UsuarioDTO atualizaUsuario(Usuario usuario, Long usuarioId) {

        Optional<Usuario> usuarioOptional = (usuarioRepository.findById(usuarioId));
        usuarioValidator.verificaSeUsuarioExisteVoid(usuarioOptional);

        usuario.setId(usuarioId);
        return usuarioAssembler.toUsuarioDTO(usuarioRepository.save(usuario));
    }

}
