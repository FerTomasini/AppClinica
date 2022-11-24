package com.example.appclinica.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "doencas")
public class ProblemaSaude {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PS_SEQ")
    @SequenceGenerator(name = "PS_SEQ", sequenceName = "PS_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "doenca")
    @NotEmpty(message = "O campo nome não pode ser vazio.")
    private String doenca;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public ProblemaSaude() {
    }

    public ProblemaSaude(Long id, String doenca, Pet pet) {
        this.id = id;
        this.doenca = doenca;
        this.pet = pet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
