package com.example.biblioteca.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.repository.UsuarioRepository;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioRepository usuarioRepo;

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioRepo.findAll();
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        usuario.setDataCadastro(LocalDate.now());
        return usuarioRepo.save(usuario);
    }
}
