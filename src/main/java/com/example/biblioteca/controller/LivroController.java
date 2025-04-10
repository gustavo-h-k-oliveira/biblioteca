package com.example.biblioteca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.dto.LivroDTO;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.LivroRepository;

import jakarta.validation.Valid;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {
    private final LivroRepository livroRepo;

    @GetMapping
    public List<Livro> listarTodos() {
        return livroRepo.findAll();
    }

    @PostMapping
    public ResponseEntity<Livro> criar(@RequestBody @Valid LivroDTO dto) {
        Livro livro = new Livro();
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        
        return ResponseEntity.ok(livroRepo.save(livro));
    }
}
