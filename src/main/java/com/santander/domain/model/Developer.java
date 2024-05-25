package com.santander.domain.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Collections;
import java.util.List;
import lombok.Data;

@Data
@Entity(name ="tb_developer")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private int idade;

    //@ElementCollection
    //private List<Skill> skill;

    // Construtor vazio (obrigatório para o JPA)
    public Developer() {}

    // Construtor com todos os atributos
    public Developer(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}