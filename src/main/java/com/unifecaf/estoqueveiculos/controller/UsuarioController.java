package com.unifecaf.estoqueveiculos.controller;

import com.unifecaf.estoqueveiculos.dto.LoginResponse;
import com.unifecaf.estoqueveiculos.model.Usuario;
import com.unifecaf.estoqueveiculos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        Usuario user = usuarioService.buscarPorEmailESenha(usuario.getEmail(), usuario.getSenha());

        if (user != null) {
            LoginResponse response = new LoginResponse(
                    "Login realizado com sucesso!",
                    user.getPerfil(),
                    user.getEmail(),
                    user.getNome()
            );
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
        }
    }
}
