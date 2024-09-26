package com.greenagri.entiy;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.greenagri.entities.Produtos;

class ProdutosTest {
	private Produtos produtos;
	
	@BeforeEach
	void setUp() {
		//Arrange
		produtos = new Produtos (1L, "grão", "milho", "10 pacotes de milho");
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		//Act
		produtos.setId(2L);
		//Assert
		assertEquals(2L, produtos.getId());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo modelo")
	void testModelo() {
		//Act
		produtos.setCategoria("cereais");
		//Assert
		assertEquals("cereais", produtos.getCategoria());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo ano")
	void testAno() {
		//Act
		produtos.setNome("Arroz");
		//Assert
		assertEquals("Arroz", produtos.getNome());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo km")
	void testKm() {
		//Act
		produtos.setDescricao("Arroz integral");
		//Assert
		assertEquals("Arroz integral", produtos.getDescricao());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testeConstrutorAll() {
		//Act
		Produtos novoProdutos = new Produtos(3L, "grãos","Café", "café torrado");
		//Assertion
		assertAll("novoProdutos",
				()-> assertEquals(3L,novoProdutos.getId()),
				()-> assertEquals("grãos", novoProdutos.getCategoria()),
				()-> assertEquals("Café",novoProdutos.getNome()),
				()-> assertEquals("café torrado", novoProdutos.getDescricao()));
				

	}

}




	
