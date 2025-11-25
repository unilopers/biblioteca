package com.grupo04.Biblioteca.controllers;

import com.grupo04.Biblioteca.models.AutorModel;
import com.grupo04.Biblioteca.repository.AutorRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@RestController
@RequestMapping("/autores")
@Tag(name = "Autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity criarAutor(@RequestBody AutorModel autor) {
        try{
            autorRepository.save(autor);
            return ResponseEntity.ok().build();
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public List<AutorModel> listarAutores() {
        return autorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
         return ResponseEntity.ok().body(autorRepository.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarAutor(@PathVariable Long id, @RequestBody AutorModel autorAtualizado) {
        AutorModel autor;
        try{
            autor = autorRepository.findById(id).orElseThrow(()->{throw new InvalidParameterException("Autor invalido!");});
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
        autor.setNome(autorAtualizado.getNome());
        autorRepository.save(autor);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarAutor(@PathVariable Long id) {
        autorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}