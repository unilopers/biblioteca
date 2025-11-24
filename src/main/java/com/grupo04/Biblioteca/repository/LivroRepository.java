package com.grupo04.Biblioteca.repository;

import com.grupo04.Biblioteca.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {
}
