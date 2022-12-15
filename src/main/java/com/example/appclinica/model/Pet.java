package com.example.appclinica.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PET_SEQ")
    @SequenceGenerator(name = "PET_SEQ", sequenceName = "PET_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "nome")
    @NotEmpty(message = "O campo nome não pode ser vazio.")
    private String nome;
    @Column(name = "data_nascimento")
    @NotBlank(message = "O campo data nascimento não pode ficar em branco.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate nascimento;
    @NotBlank(message = "O campo data nascimento não pode ficar em branco.")
    private String raca;
    @NotBlank(message = "O campo data nascimento não pode ficar em branco.")
    private double peso;
    @NotBlank(message = "O campo data nascimento não pode ficar em branco.")
    private String corPelagem;
    @NotBlank(message = "O campo data nascimento não pode ficar em branco. Ex de preenchimento: Canino ou Felino")
    private String especie;
    @NotBlank(message = "O campo data nascimento não pode ficar em branco.")
    private String genero;

    public Pet() {
    }

    public Pet(Long id, String nome, LocalDate nascimento, String raca, double peso, String corPelagem, String especie,
               String genero) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.raca = raca;
        this.peso = peso;
        this.corPelagem = corPelagem;
        this.especie = especie;
        this.genero = genero;
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

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCorPelagem() {
        return corPelagem;
    }

    public void setCorPelagem(String corPelagem) {
        this.corPelagem = corPelagem;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}