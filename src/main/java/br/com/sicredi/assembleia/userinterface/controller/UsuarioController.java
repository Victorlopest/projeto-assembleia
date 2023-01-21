package br.com.sicredi.assembleia.userinterface.controller;


import br.com.sicredi.assembleia.application.dto.PautaDTO;
import br.com.sicredi.assembleia.application.dto.UsuarioDTO;
import br.com.sicredi.assembleia.application.usecase.PautaUseCase;
import br.com.sicredi.assembleia.application.usecase.UsuarioUseCase;
import br.com.sicredi.assembleia.infrastructure.database.presentation.Pauta;
import br.com.sicredi.assembleia.infrastructure.database.presentation.Usuario;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioUseCase usuarioUseCase;

    @GetMapping(name = "Consulta todos os usuarios")
    public ResponseEntity<List<UsuarioDTO>> buscarTodos() {
        return ResponseEntity.ok(usuarioUseCase.buscarTodosUsuarios());
    }

    @GetMapping(value = "/{usuarioId}", name = "Consulta um usuário por Id")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(usuarioUseCase.buscarPorId(usuarioId));
    }

    @PostMapping(name = "Cria um novo usuário")
    public Usuario salvar(@RequestBody Usuario usuario) {
        return usuarioUseCase.salvar(usuario);

    }

    @PatchMapping(value = "/{usuarioId}", name = "Edita um usuário existente")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@ApiParam(value = "Dados do usuário a ser editado") @RequestBody Usuario usuario, @PathVariable Long usuarioId) {
        return ResponseEntity.ok(usuarioUseCase.atualizaUsuario(usuario, usuarioId));
    }


}
