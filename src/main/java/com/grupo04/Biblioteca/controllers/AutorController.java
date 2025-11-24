package com.grupo04.Biblioteca.controllers;

import com.grupo04.Biblioteca.models.Autor;
import com.grupo04.Biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {
}

 @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public Autor criarAutor(@RequestBody Autor autor) {
        autor.setDataCadastro(LocalDateTime.now());
        return autorRepository.save(autor);
    }

    @GetMapping
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Autor> buscarPorId(@PathVariable Integer id) {
        return autorRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Autor atualizarAutor(@PathVariable Integer id, @RequestBody Autor autorAtualizado) {

        return autorRepository.findById(id).map(autor -> {
            autor.setNome(autorAtualizado.getNome());
            autor.setAtivo(autorAtualizado.getAtivo());
            return autorRepository.save(autor);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarAutor(@PathVariable Integer id) {
        autorRepository.deleteById(id);
    }
}
