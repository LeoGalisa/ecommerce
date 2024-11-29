package com.brasileiras.controller;

import com.brasileiras.entity.Produto;
import com.brasileiras.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // GET: Buscar todos os produtos
    @GetMapping
    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    // GET: Buscar um produto por ID
    @GetMapping("/{id}")
    public Optional<Produto> getById(@PathVariable Long id) {
        return produtoRepository.findById(id);
    }

    // POST: Criar um novo produto
    @PostMapping
    public Produto create(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    // PUT: Atualizar um produto existente
    @PutMapping("/{id}")
    public Produto update(@PathVariable Long id, @RequestBody Produto produto) {
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    // DELETE: Remover um produto
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}
