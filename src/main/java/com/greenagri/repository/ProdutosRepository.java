package com.greenagri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenagri.entities.Produtos;

public interface ProdutosRepository extends JpaRepository <Produtos, Long> {

}
