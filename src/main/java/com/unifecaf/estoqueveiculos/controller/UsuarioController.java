package com.unifecaf.estoqueveiculos.controller;

import com.unifecaf.estoqueveiculos.dto.LoginResponse;
import com.unifecaf.estoqueveiculos.model.Usuario;
import com.unifecaf.estoqueveiculos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Controller responsável pelos endpoints relacionados a usuários
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Endpoint para cadastro de usuário
    @PostMapping("/cadastro")
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return usuarioService.salvarUsuario(usuario);
    }

    // Endpoint para login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        Usuario user = usuarioService.buscarPorEmailESenha(usuario.getEmail(), usuario.getSenha());

        if (user != null) {
            // Retorna DTO com mensagem e perfil
            return ResponseEntity.ok(new LoginResponse("Login realizado com sucesso!", user.getPerfil()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
        }
    }
}
