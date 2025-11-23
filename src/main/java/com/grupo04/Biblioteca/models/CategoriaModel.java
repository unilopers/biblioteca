package com.grupo04.Biblioteca.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categoria")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_seq")
    @SequenceGenerator(
            name = "categoria_seq",
            sequenceName = "categoria_seq",
            allocationSize = 1
    )
    @Column(name = "cd_categoria")
    private Long cdCategoria;

    @Column(name = "nm_categoria", nullable = false)
    private String nmCategoria;

    @Column(name = "ds_categoria")
    private String dsCategoria;
}
