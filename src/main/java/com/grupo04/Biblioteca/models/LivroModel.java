package com.grupo04.Biblioteca.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "livros")

public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_livro")
    private Long cd_livro;

    @Column(name = "nm_livro")
    private String nm_livro;

    @Column(name = "cd_bibliotecario")
    private Long cd_bibliotecario;

    @Column(name = "cd_categoria")
    private Long cd_categoria;

    @Column(name = "cd_autor")
    private Long cd_autor;

    @Column(name = "cd_aluno")
    private Long cd_aluno;

    @Column(name = "cd_professor")
    private Long cd_professor;

    @Column(name = "sn_locado")
    private char sn_locado;

    @Column(name = "dt_cadastro")
    private Timestamp dt_cadastro;

    @Column(name = "sn_ativo")
    private char sn_ativo;

    public Long getCd_livro() {
        return cd_livro;
    }

    public void setCd_livro(Long cd_livro) {
        this.cd_livro = cd_livro;
    }

    public String getNm_livro() {
        return nm_livro;
    }

    public void setNm_livro(String nm_livro) {
        this.nm_livro = nm_livro;
    }

    public Long getCd_bibliotecario() {
        return cd_bibliotecario;
    }

    public void setCd_bibliotecario(Long cd_bibliotecario) {
        this.cd_bibliotecario = cd_bibliotecario;
    }

    public Long getCd_categoria() {
        return cd_categoria;
    }

    public void setCd_categoria(Long cd_categoria) {
        this.cd_categoria = cd_categoria;
    }

    public Long getCd_autor() {
        return cd_autor;
    }

    public void setCd_autor(Long cd_autor) {
        this.cd_autor = cd_autor;
    }

    public Long getCd_aluno() {
        return cd_aluno;
    }

    public void setCd_aluno(Long cd_aluno) {
        this.cd_aluno = cd_aluno;
    }

    public Long getCd_professor() {
        return cd_professor;
    }

    public void setCd_professor(Long cd_professor) {
        this.cd_professor = cd_professor;
    }

    public char getSn_locado() {
        return sn_locado;
    }

    public void setSn_locado(char sn_locado) {
        this.sn_locado = sn_locado;
    }

    public Timestamp getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Timestamp dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public char getSn_ativo() {
        return sn_ativo;
    }

    public void setSn_ativo(char sn_ativo) {
        this.sn_ativo = sn_ativo;
    }
}
