package com.example.teste.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Disciplinas")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false) //não vai deixar ser nulo
    private String nome;
    private Integer semestre;

    @ManyToOne
    @JoinColumn(name = "professor_id",nullable = true) //nulnable (uma disciplina pode ser criada sem ser associada a um professor)
    private Professor professor;



    @Deprecated
    public Disciplina() {
    }

    public Disciplina(String nome, Integer semestre,Professor professor) {
        this.nome = nome;
        this.semestre = semestre;
        this.professor = professor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", semestre=" + semestre +
                ", professor=" + professor +
                '}';
    }
}
