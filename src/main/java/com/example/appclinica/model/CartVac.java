package com.example.appclinica.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
@Entity
public class CartVac {
    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Column(name = "vacina")
    @NotEmpty(message = "O campo vacina não pode ser vazio.")
    private String nomeVac;

    @Column(name = "data_vacinacao")
    @NotBlank(message = "O campo data de aplicação da vacina não pode ficar em branco.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVacina;

    @Column(name = "data_proxima_vacinacao")
    @NotBlank(message = "O campo data de aplicação da próxima vacina não pode ficar em branco.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataProxVacina;

    @Column(name = "vermifugo")
    @NotEmpty(message = "O campo vermifugo não pode ser vazio.")
    private String nomeVermifugo;

    @Column(name = "data_vermifugo")
    @NotBlank(message = "O campo data de aplicação do vermífugo não pode ficar em branco.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVermifugo;

    @Column(name = "data_proximo_vermifugo")
    @NotBlank(message = "O campo data da aplicação do próximo vermífugo não pode ficar em branco.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataProxVermifugo;

    public CartVac() {
    }

    public CartVac(long id, Pet pet, String nomeVac, LocalDate dataVacina, LocalDate dataProxVacina,
                   String nomeVermifugo, LocalDate dataVermifugo, LocalDate dataProxVermifugo) {
        this.id = id;
        this.pet = pet;
        this.nomeVac = nomeVac;
        this.dataVacina = dataVacina;
        this.dataProxVacina = dataProxVacina;
        this.nomeVermifugo = nomeVermifugo;
        this.dataVermifugo = dataVermifugo;
        this.dataProxVermifugo = dataProxVermifugo;
    }

    public CartVac(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getNomeVac() {
        return nomeVac;
    }

    public void setNomeVac(String nomeVac) {
        this.nomeVac = nomeVac;
    }

    public LocalDate getDataVacina() {
        return dataVacina;
    }

    public void setDataVacina(LocalDate dataVacina) {
        this.dataVacina = dataVacina;
    }

    public LocalDate getDataProxVacina() {
        return dataProxVacina;
    }

    public void setDataProxVacina(LocalDate dataProxVacina) {
        this.dataProxVacina = dataProxVacina;
    }

    public String getNomeVermifugo() {
        return nomeVermifugo;
    }

    public void setNomeVermifugo(String nomeVermifugo) {
        this.nomeVermifugo = nomeVermifugo;
    }

    public LocalDate getDataVermifugo() {
        return dataVermifugo;
    }

    public void setDataVermifugo(LocalDate dataVermifugo) {
        this.dataVermifugo = dataVermifugo;
    }

    public LocalDate getDataProxVermifugo() {
        return dataProxVermifugo;
    }

    public void setDataProxVermifugo(LocalDate dataProxVermifugo) {
        this.dataProxVermifugo = dataProxVermifugo;
    }
}