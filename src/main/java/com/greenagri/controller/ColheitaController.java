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

import com.greenagri.entities.Colheita;
import com.greenagri.service.ColheitaService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/colheita")
@CrossOrigin(origins = "*")
public class ColheitaController {
	private final ColheitaService colheitaService;
	@Autowired
	public ColheitaController(ColheitaService colheitaService) {
		this.colheitaService = colheitaService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza colheita por ID")
	public ResponseEntity<Colheita> getColheitaById(@PathVariable Long id) {
		Colheita colheita = colheitaService.getColheitaById(id);
		if (colheita != null) {
			return ResponseEntity.ok(colheita);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	@Operation(summary = "Aprensenta todos as colheita")
	public ResponseEntity<List<Colheita>> getAllColheita() {
		List<Colheita> colheita = colheitaService.getAllColheita();
		return ResponseEntity.ok(colheita);
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
	@Operation(summary = "Cadastra uma colheita")
	public ResponseEntity<Colheita> criarColheita(@RequestBody Colheita colheita) {
		Colheita criarColheita = colheitaService.salvarColheita(colheita);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarColheita);
	}


	@PutMapping("/{id}")
	@Operation(summary = "Altera a colheita")
	public ResponseEntity<Colheita> updateColheita(@PathVariable Long id,@RequestBody Colheita colheita) {
		Colheita updatedColheita = colheitaService.updateColheita(id, colheita);
		if (updatedColheita != null) {
			return ResponseEntity.ok(updatedColheita);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta uma colheita")
	public ResponseEntity<String> deleteColheita(@PathVariable Long id) {
		boolean deleted = colheitaService.deleteColheita(id);
		if (deleted) {
			return ResponseEntity.ok().body("A colheita foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}


