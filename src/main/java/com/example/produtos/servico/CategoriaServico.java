package com.example.produtos.servico;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.produtos.modelo.Categoria;

public interface CategoriaServico extends JpaRepository <Categoria, Long>{

}
