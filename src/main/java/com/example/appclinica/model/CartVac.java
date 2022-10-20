package com.example.appclinica.model;

import java.time.LocalDate;
import java.util.Date;

public class CartVac {

    private Pet nome;
    private String nomeVac;
    private LocalDate dataVacina;
    private LocalDate dataProxVacina;
    private String nomeVermifugo;
    private LocalDate dataVermifugo;
    private LocalDate dataProxVermifugo;

    public CartVac() {
    }

    public Pet getNome() {
        return nome;
    }

    public void setNome(Pet nome) {
        this.nome = nome;
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