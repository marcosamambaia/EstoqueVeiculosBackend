package com.unifecaf.estoqueveiculos.repository;

import com.unifecaf.estoqueveiculos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// Interface de acesso ao banco de dados para a entidade Usuario
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Busca usuário pelo email
    Optional<Usuario> findByEmail(String email);

    // Busca usuário pelo email e senha (usado no login)
    Usuario findByEmailAndSenha(String email, String senha);
}
