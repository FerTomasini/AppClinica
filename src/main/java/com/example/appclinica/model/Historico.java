package com.example.appclinica.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
@Entity
public class Historico {

    @Id
    private long id;
    private String examesImagem;
    private String examesLab;
    private String atendimentos;
    private String diagnosticos;
    private String cirurgias;
    private String antiparasitariosEx;

    public Historico() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExamesImagem() {
        return examesImagem;
    }

    public void setExamesImagem(String examesImagem) {
        this.examesImagem = examesImagem;
    }

    public String getExamesLab() {
        return examesLab;
    }

    public void setExamesLab(String examesLab) {
        this.examesLab = examesLab;
    }

    public String getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(String atendimentos) {
        this.atendimentos = atendimentos;
    }

    public String getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(String diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public String getCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(String cirurgias) {
        this.cirurgias = cirurgias;
    }

    public String getAntiparasitariosEx() {
        return antiparasitariosEx;
    }

    public void setAntiparasitariosEx(String antiparasitariosEx) {
        this.antiparasitariosEx = antiparasitariosEx;
    }
}