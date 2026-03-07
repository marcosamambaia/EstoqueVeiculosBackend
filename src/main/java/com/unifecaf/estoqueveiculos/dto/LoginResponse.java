package com.unifecaf.estoqueveiculos.dto;

// DTO simples para resposta de login
public class LoginResponse {
    private String mensagem;
    private String perfil;

    // Construtor
    public LoginResponse(String mensagem, String perfil) {
        this.mensagem = mensagem;
        this.perfil = perfil;
    }

    // Getters
    public String getMensagem() { return mensagem; }
    public String getPerfil() { return perfil; }
}
