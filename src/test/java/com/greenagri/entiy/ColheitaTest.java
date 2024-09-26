package com.greenagri.entiy;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.greenagri.entities.Colheita;

class ColheitaTest {
	private Colheita colheita;
	
	@BeforeEach
	void setUp() {
		//Arrange
		colheita = new Colheita (1L, "colheita manual", "5 hectares", LocalDate.of(2024, 9, 10), (LocalDate.of(2024, 11, 11)));
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		//Act
		colheita.setId(2L);
		//Assert
		assertEquals(2L, colheita.getId());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo tipo")
	void testTipo() {
		//Act
		colheita.setTipo("Colheita Mecanizada");
		//Assert
		assertEquals("Colheita Mecanizada", colheita.getTipo());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo area")
	void testArea() {
		//Act
		colheita.setArea("2 hectares");
		//Assert
		assertEquals("2 hectares", colheita.getArea());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo data colheita")
	void testDataColheita() {
		//Act
		colheita.setDataColheita(LocalDate.of(2024, 9, 1));
		//Assert
		assertEquals(LocalDate.of(2024, 9, 1), colheita.getDataColheita());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo previsão colheita")
	void testPrevisaoColheita() {
		//Act
		colheita.setPrevisaoColheita(LocalDate.of(2024, 12, 1));
		//Assert
		assertEquals(LocalDate.of(2024, 12, 1), colheita.getPrevisaoColheita());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testeConstrutorAll() {
		//Act
		Colheita novaColheita = new Colheita(3L, "colheita automatizada","1 hectare", LocalDate.of(2024, 10, 1),LocalDate.of(2024, 12, 1));
		//Assertion
		assertAll("novaColheita",
				()-> assertEquals(3L,novaColheita.getId()),
				()-> assertEquals("colheita automatizada", novaColheita.getTipo()),
				()-> assertEquals("1 hectare",novaColheita.getArea()),
				()-> assertEquals(LocalDate.of(2024, 10, 1),novaColheita.getDataColheita()),
				()-> assertEquals(LocalDate.of(2024, 12, 1), novaColheita.getPrevisaoColheita()));
				

	}

}




	
