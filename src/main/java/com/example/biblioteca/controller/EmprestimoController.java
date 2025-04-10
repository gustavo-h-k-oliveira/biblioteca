package com.example.biblioteca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.dto.EmprestimoDTO;
import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.repository.EmprestimoRepository;
import com.example.biblioteca.repository.LivroRepository;
import com.example.biblioteca.repository.UsuarioRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/emprestimos")
@RequiredArgsConstructor
public class EmprestimoController {
    
    private final EmprestimoRepository emprestimoRepo;
    private final UsuarioRepository usuarioRepo;
    private final LivroRepository livroRepo;

    @PostMapping
    public ResponseEntity<?> criarEmprestimo(@RequestBody @Valid EmprestimoDTO dto) {

        Optional<Usuario> usuarioOpt = usuarioRepo.findById(dto.getId_usuario());
        Optional<Livro> livroOpt = livroRepo.findById(dto.getId_livro());

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found.");
        }
        if (livroOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Book not found.");
        }

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuarioOpt.get());
        emprestimo.setLivro(livroOpt.get());
        emprestimo.setDataEmprestimo(dto.getDataEmprestimo());
        emprestimo.setDataDevolucao(dto.getDataDevolucao());
        emprestimo.setStatus(dto.getStatus());

        return ResponseEntity.ok(emprestimoRepo.save(emprestimo));
    }

    @GetMapping
    public List<Emprestimo> listarTodos() {
        return emprestimoRepo.findAll();
    }
}
