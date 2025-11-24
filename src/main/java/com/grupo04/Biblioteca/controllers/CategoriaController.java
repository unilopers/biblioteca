package com.grupo04.Biblioteca.controllers;

import com.grupo04.Biblioteca.dto.CategoriaDTO;
import com.grupo04.Biblioteca.models.CategoriaModel;
import com.grupo04.Biblioteca.repository.CategoriaRepository;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categorias")
@Tag(name = "Categoria")
public class CategoriaController {

    @Autowired
    public CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<CategoriaModel> list = categoriaRepository.findAll();
        List<CategoriaDTO> listDTO = new ArrayList<>();

        list.forEach(c -> {
            listDTO.add(new CategoriaDTO(
                    c.getCdCategoria(),
                    c.getNmCategoria(),
                    c.getDsCategoria()
            ));
        });

        return ResponseEntity.ok(listDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        try {
            CategoriaModel categoria = categoriaRepository.findById(id)
                    .orElseThrow(() -> new InvalidParameterException("Categoria inexistente!"));

            CategoriaDTO dto = new CategoriaDTO(
                    categoria.getCdCategoria(),
                    categoria.getNmCategoria(),
                    categoria.getDsCategoria()
            );

            return ResponseEntity.ok(dto);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CategoriaDTO body) {
        try {
            CategoriaModel nova = new CategoriaModel();
            nova.setNmCategoria(body.nome());
            nova.setDsCategoria(body.descricao());

            categoriaRepository.save(nova);

            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody CategoriaModel categoriaBody) {
        try {
            CategoriaModel atual = categoriaRepository.findById(categoriaBody.getCdCategoria())
                    .orElseThrow(() -> new InvalidParameterException("Categoria inexistente!"));

            atual.setNmCategoria(categoriaBody.getNmCategoria());
            atual.setDsCategoria(categoriaBody.getDsCategoria());

            categoriaRepository.save(atual);

            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            categoriaRepository.deleteById(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
