package com.grupo04.Biblioteca.models;
public class autor {
    
}
@Entity
@Table(name = "autor")
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "cd_autor")
private Integer id;

@Column(name = "nm_autor", nullable = false, length = 50)
private String nome; 
