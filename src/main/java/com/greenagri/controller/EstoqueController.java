package com.greenagri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenagri.entities.Estoque;
import com.greenagri.service.EstoqueService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/estoque")
@CrossOrigin(origins = "*")
public class EstoqueController {
	private final EstoqueService estoqueService;
	
	@Autowired
	public EstoqueController(EstoqueService estoqueService) {
		this.estoqueService = estoqueService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza veiculo por ID")
	public ResponseEntity<Estoque> getEstoqueById(@PathVariable Long id) {
		Estoque estoque = estoqueService.getEstoqueById(id);
		if (estoque != null) {
			return ResponseEntity.ok(estoque);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	@Operation(summary = "Aprensenta todos os estoque")
	public ResponseEntity<List<Estoque>> getAllEstoque() {
		List<Estoque> estoque = estoqueService.getAllEstoque();
		return ResponseEntity.ok(estoque);
	}
	//@Query
	//@GetMapping("/data/{data}")
	//@Operation(summary = "Aprensenta a data da consulta")
	//public ResponseEntity<List<Consulta>> getConsultaPorData(@PathVariable String data){
		//List<Consulta> consultas = consultaService.getConsultaPorData(data);
		//return ResponseEntity.ok(consultas);
	//}
	//@Query
	//@GetMapping("/hora/{hora}")
	//@Operation(summary = "Aprensenta a hora consulta")
	//public List<Consulta> findConsultasPorHora(@PathVariable String hora){
		//return consultaService.findByHora(hora);
	//}

	//@Query
	//@GetMapping("/descricao/{descricao}")
	//@Operation(summary = "Aprensenta a descricao consulta")
	//public List<Consulta> findPorDescricao(@PathVariable String descricao){
		//return consultaService.findByDescricao(descricao);
	//}


	@PostMapping("/")
	@Operation(summary = "Cadastra um estoque")
	public ResponseEntity<Estoque> criarEstoque(@RequestBody Estoque estoque) {
		Estoque criarEstoque = estoqueService.salvarEstoque(estoque);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarEstoque);
	}


	@PutMapping("/{id}")
	@Operation(summary = "Altera o estoque")
	public ResponseEntity<Estoque> updateEstoque(@PathVariable Long id,@RequestBody Estoque estoque) {
		Estoque updatedEstoque = estoqueService.updateEstoque(id, estoque);
		if (updatedEstoque != null) {
			return ResponseEntity.ok(updatedEstoque);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta um estoque")
	public ResponseEntity<String> deleteEstoque(@PathVariable Long id) {
		boolean deleted = estoqueService.deleteEstoque(id);
		if (deleted) {
			return ResponseEntity.ok().body("O veiculo foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}

