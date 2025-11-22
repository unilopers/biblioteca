package com.grupo04.Biblioteca.controllers;

import com.grupo04.Biblioteca.dto.BibliotecarioDTO;
import com.grupo04.Biblioteca.models.BibliotecarioModel;
import com.grupo04.Biblioteca.repository.BibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bibliotecarios")
public class BibliotecarioController {
    @Autowired
    public BibliotecarioRepository repository;

    @GetMapping
    public ResponseEntity<List<BibliotecarioDTO>> findAll() {
        List<BibliotecarioModel> list = repository.findAll();
        List<BibliotecarioDTO>  listDTO = new ArrayList<>();

        list.forEach(bibliotecarioModel -> {
            listDTO.add(new BibliotecarioDTO(bibliotecarioModel.getCdBibliotecario(),
                                            bibliotecarioModel.getNmBibliotecario(),
                                            bibliotecarioModel.getDtNascimento(),
                                            bibliotecarioModel.getTpSexo()));
        });
        return ResponseEntity.ok(listDTO);
    }
}
