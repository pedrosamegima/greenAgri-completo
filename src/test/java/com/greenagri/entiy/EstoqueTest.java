package com.greenagri.entiy;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.greenagri.entities.Estoque;
import com.greenagri.entities.Produtos;


class EstoqueTest {
	private Estoque estoque;
	private Produtos produtos;
	
	@BeforeEach
	public void setUp() {
		//Arrange
		estoque = new Estoque (1L, "Milho", "milho verde", "100 pacotes", "0", "grãos", produtos);
	}
	@Test
	public void testId() {
		//Act: Atribui o valor atribuido 'id'
		estoque.setId(2L);

		//Assert: Verifica se o valor foi corretamente atribuido
		assertEquals(2L, estoque.getId(), "O ID deve ser igual ao valor atribuido");
	}
	@Test
	public void testProdutos() {
		//Act:
		estoque.setProdutos(produtos);

		//Assert:
		assertEquals(produtos, estoque.getProdutos(), "O hospede deve ser igual ao valor atribuido");
	}

	@Test
	public void testNome () {
		// Act:
		estoque.setNome("Soja");

		// Assert:
		assertEquals("Soja", estoque.getNome(),
				"O nome deve ser igual ao valor atribuido");

	}
	@Test
	public void testDescricao () {
		// Act:
		estoque.setDescricao("Grãos de soja");

		// Assert:
		assertEquals("Grãos de soja", estoque.getDescricao(),
				"A descricao deve ser igual ao valor atribuido");
	}
	@Test
	public void testEntrou () {
		// Act:
		estoque.setEntrou("0");

		// Assert:
		assertEquals("0", estoque.getEntrou(),
				"O entrou deve ser igual ao valor atribuido");
	}
	@Test
	public void testSaiu() {
		// Act:
		estoque.setSaiu("100 pacotes");

		// Assert:
		assertEquals("100 pacotes", estoque.getSaiu(),
				"O saiu deve ser igual ao valor atribuido");
	}
	@Test
	public void testCategoria() {
		// Act:
		estoque.setCategoria("Grãos");

		// Assert:
		assertEquals("Grãos", estoque.getCategoria(),
				"A categoria deve ser igual ao valor atribuido");
	}
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstrutorAll() {
		// Act
		Estoque novaEstoque = new Estoque (3L, "algodão", "fofinho", "0", "10 pacotes", "fofo", produtos );
		// Assertion
		assertAll("novaEstoque", () -> assertEquals(3L, novaEstoque.getId()),
				() -> assertEquals("algodão", novaEstoque.getNome()),
				() -> assertEquals("fofinho", novaEstoque.getDescricao()),
				() -> assertEquals("0", novaEstoque.getEntrou()),
				() -> assertEquals("10 pacotes", novaEstoque.getSaiu()),
				() -> assertEquals("fofo", novaEstoque.getCategoria()),
				() -> assertEquals(produtos, novaEstoque.getProdutos()));
	}
}
