package com.example.appclinica.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Alergia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALER_SEQ")
    @SequenceGenerator(name = "ALER_SEQ", sequenceName = "ALER_SEQ", allocationSize = 1)
    private Long id;

    @NotBlank(message = "O campo alergia não pode ficar em branco.")
    private String alergia;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Alergia() {
    }

    public Alergia(Long id, String alergia, Pet pet) {
        this.id = id;
        this.alergia = alergia;
        this.pet = pet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}