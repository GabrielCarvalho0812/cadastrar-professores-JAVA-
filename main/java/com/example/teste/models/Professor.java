package com.example.teste.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Professores")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String nome;


    @OneToMany(mappedBy = "professor",cascade = CascadeType.ALL) 
    private List<Disciplina> disciplinas;


    public Professor() {
    }

    public Professor(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
