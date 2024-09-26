package com.greenagri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenagri.entities.Estoque;

public interface EstoqueRepository extends JpaRepository <Estoque, Long> {

}
