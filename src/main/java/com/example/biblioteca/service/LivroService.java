package com.example.biblioteca.service;

import java.util.List;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.example.biblioteca.repository.LivroRepository;
import com.example.biblioteca.dto.LivroDTO;
import com.example.biblioteca.model.Livro;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LivroService {
    
    private final LivroRepository livroRepo;

    public Livro salvar(LivroDTO dto) {
        Livro livro = new Livro();
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        return livroRepo.save(livro);
    }

    public List<Livro> listarTodos() {
        return livroRepo.findAll();
    }

    public Optional<Livro> buscarPorId(Long id) {
        return livroRepo.findById(id);
    }
}
