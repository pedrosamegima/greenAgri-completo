package com.greenagri.entiy;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.greenagri.entities.Veiculos;


class VeiculosTest {
	private Veiculos veiculos;
	@BeforeEach
	void setUp() {
		//Arrange 
		veiculos = new Veiculos(1L, "Trator", 2019, "180.000", "Manutenção");
	}
	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		//Act
		veiculos.setId(2L);
		//Assert
		assertEquals(2L, veiculos.getId());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo modelo")
	void testModelo() {
		//Act
		veiculos.setModelo("trator esteira");
		//Assert
		assertEquals("trator esteira", veiculos.getModelo());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo ano")
	void testAno() {
		//Act
		veiculos.setAno(2022);
		//Assert
		assertEquals(2022, veiculos.getAno());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo km")
	void testKm() {
		//Act
		veiculos.setKm("2.000km");
		//Assert
		assertEquals("2.000km", veiculos.getKm());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo status")
	void testStatus() {
		//Act
		veiculos.setStatus("Funcionando");
		//Assert
		assertEquals("Funcionando", veiculos.getStatus());
	}
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testeConstrutorAll() {
		//Act
		Veiculos novoVeiculos = new Veiculos(3L, "Colheitadeira", 2024, "1.500km", "Manutenção");
		//Assertion
		assertAll("novoHospede",
				()-> assertEquals(3L,novoVeiculos.getId()),
				()-> assertEquals("Colheitadeira", novoVeiculos.getModelo()),
				()-> assertEquals(2024,novoVeiculos.getAno()),
				()-> assertEquals("1.500km", novoVeiculos.getKm()),
				()-> assertEquals("Manutenção", novoVeiculos.getStatus()));

	}

}



