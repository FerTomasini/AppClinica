package com.example.appclinica.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProblemaSaude {
    @Id
    private Long id;
    private String nome;

    public ProblemaSaude() {
    }

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
}
