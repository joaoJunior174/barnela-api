package com.barnela.barnela.model;

import jakarta.persistence.*;

@Entity
@Table(name = "presente")
public class Presente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    // Quantidade que foi escolhido
    private Integer escolhido;

    // Identificador da pessoa que escolheu (string)
    @Column(name = "pessoa_id")
    private String pessoaId;

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

    public Integer getEscolhido() {
        return escolhido;
    }

    public void setEscolhido(Integer escolhido) {
        this.escolhido = escolhido;
    }

    public String getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(String pessoaId) {
        this.pessoaId = pessoaId;
    }
}

