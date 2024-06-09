package com.example.teste.service;

import com.example.teste.models.Disciplina;
import com.example.teste.models.Professor;
import com.example.teste.repository.DisciplinaRepository;
import com.example.teste.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudDisciplinaService {
    private DisciplinaRepository  disciplinaRepository;
    private ProfessorRepository professorRepository;

    public CrudDisciplinaService(DisciplinaRepository disciplinaRepository, ProfessorRepository professorRepository) {
        this.disciplinaRepository = disciplinaRepository;
        this.professorRepository = professorRepository;
    }

    public void menu(Scanner scanner){
        boolean istrue = true;

        while (istrue){
            System.out.println("\nqual acão voce quer executar");
            System.out.println("0 - voltar ao menu anterior");
            System.out.println("1 - cadastrar nova disciplina");
            System.out.println("2 - atualizar uma Disciplina");
            System.out.println("3 - Visualizar todas as Disciplinas");
            System.out.println("4 - Deletar uma Disciplina");

            int opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    this.cadastrar(scanner);
                    break;

                case 2:
                    this.atualizar(scanner);
                    break;

                case 3 :
                    this.visualizar();
                    break;

                case 4:
                    this.deletar(scanner);
                    break;

                default:
                    istrue = false;
                    break;
            }
            System.out.println();
        }
    }


    private void cadastrar(Scanner scanner){
        System.out.println("Nome da Disciplina: ");
        String nome = scanner.next();

        System.out.println("Semestre: ");
        Integer semestre = scanner.nextInt();

        System.out.println("Professor ID: ");
        long professorid  = scanner.nextLong();

        Optional<Professor> optional = professorRepository.findById(professorid);
        if (optional.isPresent()){
            Professor professor = optional.get();
            Disciplina disciplina =  new Disciplina(nome,semestre,professor);
            disciplinaRepository.save(disciplina);
            System.out.println("\n disciplina cadastrada");
        }else {
            System.out.println("professor id " + professorid + "invalido");
        }
    }

    private void atualizar(Scanner scanner) {
        System.out.println("digite o ID da disciplina para ser atualizado: ");
        long id = scanner.nextLong();

        Optional<Disciplina> optionalDisciplina = this.disciplinaRepository.findById(id);

        if (optionalDisciplina.isPresent()){
            Disciplina disciplina = optionalDisciplina.get();

            System.out.println("nome da discplina: ");
            String nome = scanner.next();

            System.out.println("Semestre: ");
            Integer semestre = scanner.nextInt();

            System.out.println("professor ID: ");
            long professorid = scanner.nextLong();

            Optional<Professor> optionalProfessor = this.professorRepository.findById(professorid);
            if (optionalProfessor.isPresent()){
                Professor professor = optionalProfessor.get();

                disciplina.setNome(nome);
                disciplina.setSemestre(semestre);
                disciplina.setProfessor(professor);

                disciplinaRepository.save(disciplina);
                System.out.println("disciplina autualizada com sucesso");
            }
            else {
                System.out.println("professor " + professorid + " é invalido\n");
            }
        }
        else {
            System.out.println("o id da disciplina informado :" + id + "é invalido\n");
        }
    }

    private void visualizar(){
        Iterable<Disciplina> disciplinas = this.disciplinaRepository.findAll();
        for (Disciplina disciplina : disciplinas){
            System.out.println(disciplina);
        }
        System.out.println();
    }

    private void deletar(Scanner scanner){
        System.out.println("id:");
        long id = scanner.nextLong();

        this.disciplinaRepository.deleteById(id);
        System.out.println("disciplina deletada com sucesso\n");
    }
}



