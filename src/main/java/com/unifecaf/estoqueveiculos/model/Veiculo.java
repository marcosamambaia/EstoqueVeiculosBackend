package com.unifecaf.estoqueveiculos.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único do veículo

    private String nome; // Nome do veículo (ex: Gol, Corolla, Civic)
    private int ano; // Ano de fabricação
    private String cor; // Cor do veículo
    private double preco; // Preço de venda
    private double custo; // Custo de aquisição
    private int quilometragem; // Quilometragem atual
    private String status; // Status (ex: "Disponível", "Vendido")

    // Relacionamento com Marca
    @ManyToOne
    @JoinColumn(name = "marca_id")
    @JsonBackReference(value = "veiculo-marca") // nome único para evitar conflito
    private Marca marca;

    // Relacionamento com Modelo
    @ManyToOne
    @JoinColumn(name = "modelo_id")
    @JsonBackReference(value = "veiculo-modelo") // nome único para evitar conflito
    private Modelo modelo;

    // Construtor padrão (necessário para JPA)
    public Veiculo() {}

    // Construtor completo
    public Veiculo(String nome, int ano, String cor, double preco, double custo,
                   int quilometragem, String status, Marca marca, Modelo modelo) {
        this.nome = nome;
        this.ano = ano;
        this.cor = cor;
        this.preco = preco;
        this.custo = custo;
        this.quilometragem = quilometragem;
        this.status = status;
        this.marca = marca;
        this.modelo = modelo;
    }

    // Getters e Setters
    public Long getId() { return id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public double getCusto() { return custo; }
    public void setCusto(double custo) { this.custo = custo; }

    public int getQuilometragem() { return quilometragem; }
    public void setQuilometragem(int quilometragem) { this.quilometragem = quilometragem; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Marca getMarca() { return marca; }
    public void setMarca(Marca marca) { this.marca = marca; }

    public Modelo getModelo() { return modelo; }
    public void setModelo(Modelo modelo) { this.modelo = modelo; }
}
