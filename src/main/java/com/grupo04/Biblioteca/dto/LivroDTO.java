package com.grupo04.Biblioteca.dto;

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