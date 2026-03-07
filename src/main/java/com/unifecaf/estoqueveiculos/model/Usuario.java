package com.unifecaf.estoqueveiculos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Classe que representa um usuário do sistema.
 * Pode ser ADMIN ou VENDEDOR, dependendo do perfil.
 */
@Entity
public class Usuario {

    // Identificador único do usuário (chave primária no banco)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome completo do usuário
    private String nome;

    // Email usado para login
    private String email;

    // Senha do usuário (idealmente deve ser criptografada)
    private String senha;

    // Perfil define permissões: ADMIN ou VENDEDOR
    private String perfil;

    // Construtor vazio (necessário para JPA)
    public Usuario() {
    }

    // Construtor com parâmetros (facilita criação de objetos)
    public Usuario(String nome, String email, String senha, String perfil) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }

    // Getters e Setters (encapsulamento)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
