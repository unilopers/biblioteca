package com.grupo04.Biblioteca.dto;

import com.grupo04.Biblioteca.models.CategoriaModel;

public record LivroDTO(
        Long id,
        String nome,
        Long categoria,
        Long autor,
        Long bibliotecario,
        Long aluno,
        Long professor,
        char locado
        ) {}