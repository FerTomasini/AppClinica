package com.example.appclinica.model;

import java.util.List;

public class Historico {

    private List<String> examesImagem;
    private List<String> examesLab;
    private List<String> atendimentos;
    private List<String> diagnosticos;
    private List<String> cirurgias;
    private List<String> antiparasitariosEx;

    public Historico() {
    }

    public List<String> getExamesImagem() {
        return examesImagem;
    }

    public void setExamesImagem(List<String> examesImagem) {
        this.examesImagem = examesImagem;
    }

    public List<String> getExamesLab() {
        return examesLab;
    }

    public void setExamesLab(List<String> examesLab) {
        this.examesLab = examesLab;
    }

    public List<String> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<String> atendimentos) {
        this.atendimentos = atendimentos;
    }

    public List<String> getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(List<String> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public List<String> getCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(List<String> cirurgias) {
        this.cirurgias = cirurgias;
    }

    public List<String> getAntiparasitariosEx() {
        return antiparasitariosEx;
    }

    public void setAntiparasitariosEx(List<String> antiparasitariosEx) {
        this.antiparasitariosEx = antiparasitariosEx;
    }
}
