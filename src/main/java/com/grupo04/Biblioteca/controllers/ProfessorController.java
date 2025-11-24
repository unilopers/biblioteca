package com.grupo04.Biblioteca.controllers;

import com.grupo04.Biblioteca.models.BibliotecarioModel;
import com.grupo04.Biblioteca.models.ProfessorModel;
import com.grupo04.Biblioteca.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    public ProfessorRepository repository;

    @GetMapping
    public ResponseEntity<List<ProfessorModel>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ProfessorModel professor) {
        try {
            repository.save(professor);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity update(@RequestBody ProfessorModel professor) {
        try {
            repository.save(professor);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/{nome}")
    public ResponseEntity patch(@PathVariable Long id, @PathVariable String nome) {
        try {
            ProfessorModel b = repository.findById(id).orElseThrow(() -> {
                throw new InvalidParameterException("Id invalido!");
            });
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}