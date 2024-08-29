package com.example.produtos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.produtos.modelo.Categoria;
import com.example.produtos.servico.CategoriaServico;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaServico categoriaServico;
    public CategoriaController(CategoriaServico categoriaServico) {
        this.categoriaServico = categoriaServico;
    }

    @PostMapping
    public Categoria criarCategoria(@RequestBody Categoria categoria){
        return categoriaServico.save(categoria);
    }    
    

    public List<Categoria> listarCategorias(){
        return categoriaServico.findAll();
    }
    @DeleteMapping("/{id}")
    public void excluirCategoria(@PathVariable Long id){
        categoriaServico.deleteById(id);
    }
    public Categoria atualizarCategoria(@PathVariable Long id, @RequestBody Categoria novaCategoria){
        return categoriaServico.findById(id)
        .map(categoria -> {
            categoria.setNome(novaCategoria.getNome());
            return categoriaServico.save(categoria);
        })
        .orElseGet(() ->{
            novaCategoria.setId(id);
            return categoriaServico.save(novaCategoria);
 
        });
    }
}
