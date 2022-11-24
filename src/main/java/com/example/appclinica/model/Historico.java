package com.example.appclinica.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "historico")
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HIST_SEQ")
    @SequenceGenerator(name = "HIST_SEQ", sequenceName = "HIST_SEQ", allocationSize = 1)
    private long id;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
    private String examesImagem;
    private String examesLab;
    private String atendimentos;
    private String diagnosticos;
    private String cirurgias;
    private String antiparasitariosEx;

    public Historico() {
    }

    public Historico(long id, Pet pet, String examesImagem, String examesLab, String atendimentos, String diagnosticos,
                     String cirurgias, String antiparasitariosEx) {
        this.id = id;
        this.pet = pet;
        this.examesImagem = examesImagem;
        this.examesLab = examesLab;
        this.atendimentos = atendimentos;
        this.diagnosticos = diagnosticos;
        this.cirurgias = cirurgias;
        this.antiparasitariosEx = antiparasitariosEx;
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