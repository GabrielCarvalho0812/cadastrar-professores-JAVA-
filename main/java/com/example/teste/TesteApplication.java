package com.example.teste;


import com.example.teste.service.CrudDisciplinaService;
import com.example.teste.service.CrudProfessorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TesteApplication implements CommandLineRunner {
	private CrudProfessorService professorService;
	private CrudDisciplinaService disciplinaService;




	public TesteApplication(CrudProfessorService professorService, CrudDisciplinaService disciplinaService ){
        this.professorService = professorService;
        this.disciplinaService = disciplinaService;

    }

	public static void main(String[] args) {
		SpringApplication.run(TesteApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		boolean istrue = true;
		Scanner scanner = new Scanner(System.in); //para ler dados de entrada do teclado

		while (istrue){  //enquanto is true for verdadeiro
			System.out.println("qual entidade voce deseja interagir?");
			System.out.println("0 - sair");
			System.out.println("1 - professor");
			System.out.println("2 - Disciplina");

			int opcao = scanner.nextInt();

			switch (opcao){
				case 1 :
					this.professorService.menu(scanner);
					break;

				case 2 :
					this.disciplinaService.menu(scanner);
					break;

				default:
					istrue = false;
					break;
			}
		}
	}
}


//parei na aula 10 spring data