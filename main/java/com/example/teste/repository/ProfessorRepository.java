package com.example.teste.repository;

import com.example.teste.models.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProfessorRepository extends CrudRepository<Professor, Long> {
}
