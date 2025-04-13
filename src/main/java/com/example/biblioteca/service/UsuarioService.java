package com.example.biblioteca.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.biblioteca.repository.UsuarioRepository;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.dto.UsuarioDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepo;

    public Usuario salvar(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setTelefone(dto.getTelefone());
        usuario.setDataCadastro(LocalDate.now());
        return usuarioRepo.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepo.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepo.findById(id);
    }
}
