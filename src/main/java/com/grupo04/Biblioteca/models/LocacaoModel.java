package com.grupo04.Biblioteca.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "locacao")
public class LocacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locacao_seq")
    @SequenceGenerator(
            name = "locacao_seq",
            sequenceName = "locacao_seq",
            allocationSize = 1
    )
    @Column(name = "cd_locacao")
    private Long cdLocacao;

    @ManyToOne
    @JoinColumn(name = "cd_aluno", referencedColumnName = "cd_aluno")
    private AlunoModel aluno;

    @ManyToOne
    @JoinColumn(name = "cd_livro", referencedColumnName = "cd_livro")
    private LivroModel livro;

    @Column(name = "dt_locacao")
    private LocalDateTime dtLocacao;

    @Column(name = "dt_devolucao_prevista")
    private LocalDateTime dtDevolucaoPrevista;

    @Column(name = "dt_devolucao_real")
    private LocalDateTime dtDevolucaoReal;

    @Column(name = "ds_status")
    private String dsStatus;  
}
