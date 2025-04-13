package com.example.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.biblioteca.dto.EmprestimoDTO;
import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.repository.EmprestimoRepository;
import com.example.biblioteca.repository.LivroRepository;
import com.example.biblioteca.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final UsuarioRepository usuarioRepository;
    private final LivroRepository livroRepository;

    public Emprestimo realizarEmprestimo(EmprestimoDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getId_usuario())
            .orElseThrow(() -> new IllegalArgumentException("User not found."));

        Livro livro = livroRepository.findById(dto.getId_livro())
            .orElseThrow(() -> new IllegalArgumentException("Book not found."));

        if (livro.getQuantidadeEstoque() <= 0) {
            throw new IllegalStateException("Book not available.");
        }

        livro.setQuantidadeEstoque(livro.getQuantidadeEstoque() - 1);
        livroRepository.save(livro);

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);
        emprestimo.setDataEmprestimo(dto.getDataEmprestimo());
        emprestimo.setDataDevolucao(dto.getDataDevolucao());
        emprestimo.setStatus(dto.getStatus());

        return emprestimoRepository.save(emprestimo);
    }

    public List<Emprestimo> listarTodos() {
        return emprestimoRepository.findAll();
    }
}
