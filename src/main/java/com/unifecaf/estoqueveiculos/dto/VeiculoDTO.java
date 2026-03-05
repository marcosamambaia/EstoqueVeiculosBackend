package com.unifecaf.estoqueveiculos.dto;

import com.unifecaf.estoqueveiculos.model.Veiculo;

public class VeiculoDTO {
    private Long id;
    private String nome;
    private int ano;
    private String cor;
    private double preco;
    private double custo;
    private int quilometragem;
    private String status;
    private String marca;
    private String modelo;

    // Construtor que recebe a entidade e extrai os dados
    public VeiculoDTO(Veiculo v) {
        this.id = v.getId();
        this.nome = v.getNome();
        this.ano = v.getAno();
        this.cor = v.getCor();
        this.preco = v.getPreco();
        this.custo = v.getCusto();
        this.quilometragem = v.getQuilometragem();
        this.status = v.getStatus();
        this.marca = (v.getMarca() != null ? v.getMarca().getNome() : null);
        this.modelo = (v.getModelo() != null ? v.getModelo().getNome() : null);
    }

    // Getters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public int getAno() { return ano; }
    public String getCor() { return cor; }
    public double getPreco() { return preco; }
    public double getCusto() { return custo; }
    public int getQuilometragem() { return quilometragem; }
    public String getStatus() { return status; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
}
