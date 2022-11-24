package com.example.appclinica.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Table(name = "tutor")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TUTOR_SEQ")
    @SequenceGenerator(name = "TUTOR_SEQ", sequenceName = "TUTOR_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "nome")
    @NotEmpty(message = "O campo nome não pode ser vazio.")
    private String nome;

    @Column(name = "data_nascimento")
    @NotBlank(message = "O campo data nascimento não pode ficar em branco.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate nascimento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "tutor_endereco",
            joinColumns = { @JoinColumn(name = "tutor_id") },
            inverseJoinColumns = { @JoinColumn(name = "endereco_id") })
    private Endereco endereco;

    @NotBlank(message = "O campo email não pode ficar em branco.")
    @Email(message = "O campo email está com valor inválido.")
    private String email;

    @Pattern(regexp = "^\\(0?[1-9]{2}\\) (?:[2-8]|9[1-9])\\d{5}-\\d{4}$", message = "O campo telefone precisa estar no formato (DDD) XXXXX-XXXX.")
    private String telefone;
    @Column(name = "cpf")
    @NotBlank
    @CPF
    private String cpf;
    private String identidade;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "tutor_pet",
            joinColumns = { @JoinColumn(name = "tutor_id") },
            inverseJoinColumns = { @JoinColumn(name = "pet_id") })
    private Pet pet;

    public Tutor() {
    }

    public Tutor(Long id, String nome, LocalDate nascimento, Endereco endereco, String email, String telefone,
                 String cpf, String identidade, Pet pet) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.identidade = identidade;
        this.pet = pet;
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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
