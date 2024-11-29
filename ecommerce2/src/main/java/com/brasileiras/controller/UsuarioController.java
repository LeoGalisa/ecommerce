package com.brasileiras.controller;

import com.brasileiras.entity.Usuario;
import com.brasileiras.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // GET: Buscar todos os usuários
    @GetMapping
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    // GET: Buscar um usuário por ID
    @GetMapping("/{id}")
    public Optional<Usuario> getById(@PathVariable Long id) {
        return usuarioRepository.findById(id);
    }

    // POST: Criar um novo usuário
    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // PUT: Atualizar um usuário existente
    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    // DELETE: Remover um usuário
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }
}
