package com.brasileiras.controller;

import com.brasileiras.entity.NotaFiscal;
import com.brasileiras.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notas-fiscais")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    // GET: Buscar todas as notas fiscais
    @GetMapping
    public List<NotaFiscal> getAll() {
        return notaFiscalRepository.findAll();
    }

    // GET: Buscar uma nota fiscal por ID
    @GetMapping("/{id}")
    public Optional<NotaFiscal> getById(@PathVariable Long id) {
        return notaFiscalRepository.findById(id);
    }

    // POST: Criar uma nova nota fiscal
    @PostMapping
    public NotaFiscal create(@RequestBody NotaFiscal notaFiscal) {
        return notaFiscalRepository.save(notaFiscal);
    }

    // PUT: Atualizar uma nota fiscal existente
    @PutMapping("/{id}")
    public NotaFiscal update(@PathVariable Long id, @RequestBody NotaFiscal notaFiscal) {
        notaFiscal.setId(id);
        return notaFiscalRepository.save(notaFiscal);
    }

    // DELETE: Remover uma nota fiscal
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        notaFiscalRepository.deleteById(id);
    }
}
