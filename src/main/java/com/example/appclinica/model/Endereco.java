package com.example.appclinica.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
    @SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "ENDERECO_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "logradouro")
    @NotEmpty(message = "O campo logradouro não pode ser vazio.")
    private String logradouro;
    @Column(name = "numero")
    @NotEmpty(message = "O campo numero não pode ser vazio.")
    private int numero;
    @Column(name = "CEP")
    @NotBlank
    @Pattern(regexp = "^\\d{5}-\\d{3}$")
    private String cep;
    @Column(name = "bairro")
    @NotEmpty(message = "O campo bairro não pode ser vazio.")
    private String bairro;
    @Column(name = "cidade")
    @NotEmpty(message = "O campo cidade não pode ser vazio.")
    private String cidade;
    @Column(name = "estado")
    @NotBlank
    private String estado;

    public Endereco() {
    }

    public Endereco(Long id, String logradouro, int numero, String cep, String bairro, String cidade, String estado) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
