package com.example.produtos.servico;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.produtos.modelo.Produto;

public interface ProdutoServico extends JpaRepository <Produto, Long> {

}
