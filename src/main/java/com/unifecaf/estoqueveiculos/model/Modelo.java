package com.unifecaf.estoqueveiculos.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

// A anotação @Entity indica que essa classe será mapeada para uma tabela no banco de dados
@Entity
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;

    // Relacionamento muitos-para-um com Marca
    // @JsonBackReference indica que este é o lado "filho" da relação
    @ManyToOne
    @JoinColumn(name = "marca_id")
    //@JsonBackReference
    private Marca marca;

    public Modelo() {}

    public Modelo(String nome, String tipo, Marca marca) {
        this.nome = nome;
        this.tipo = tipo;
        this.marca = marca;
    }

    // Getters e Setters
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
