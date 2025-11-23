package com.grupo04.Biblioteca.dto;

import java.time.LocalDateTime;

public record LocacaoDTO(
        Long id,
        Long idAluno,
        Long idLivro,
        LocalDateTime dtLocacao,
        LocalDateTime dtDevolucaoPrevista,
        LocalDateTime dtDevolucaoReal,
        String status
) { }
