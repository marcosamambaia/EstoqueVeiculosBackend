package com.unifecaf.estoqueveiculos.dto;

public class LoginResponse {
    private String mensagem;
    private String perfil;
    private String email;
    private String nome;

    public LoginResponse(String mensagem, String perfil, String email, String nome) {
        this.mensagem = mensagem;
        this.perfil = perfil;
        this.email = email;
        this.nome = nome;
    }

    public String getMensagem() { return mensagem; }
    public String getPerfil() { return perfil; }
    public String getEmail() { return email; }
    public String getNome() { return nome; }
}
