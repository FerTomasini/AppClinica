package com.example.appclinica.model;

import java.time.LocalDate;

public class Tutor {

    private Long id;
    private String nome;
    private LocalDate nascimento;
    private String email;
    private String cpf;
    private Pet seuPet;

    private Endereco endereco;

    public Tutor() {
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

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Pet getSeuPet() {
        return seuPet;
    }

    public void setSeuPet(Pet seuPet) {
        this.seuPet = seuPet;
    }
}
