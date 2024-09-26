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

import com.greenagri.entities.Veiculos;
import com.greenagri.service.VeiculosService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin(origins = "*")
public class VeiculosController {
	private final VeiculosService veiculosService;
	
	@Autowired
	public VeiculosController(VeiculosService veiculosService) {
		this.veiculosService = veiculosService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza veiculo por ID")
	public ResponseEntity<Veiculos> getVeiculosById(@PathVariable Long id) {
		Veiculos veiculos = veiculosService.getVeiculosById(id);
		if (veiculos != null) {
			return ResponseEntity.ok(veiculos);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	@Operation(summary = "Aprensenta todos os veiculos")
	public ResponseEntity<List<Veiculos>> getAllVeiculos() {
		List<Veiculos> veiculo = veiculosService.getAllVeiculos();
		return ResponseEntity.ok(veiculo);
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
	@Operation(summary = "Cadastra um veiculo")
	public ResponseEntity<Veiculos> criarVeiculos(@RequestBody Veiculos veiculos) {
		Veiculos criarVeiculos = veiculosService.salvarVeiculos(veiculos);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarVeiculos);
	}


	@PutMapping("/{id}")
	@Operation(summary = "Altera o hospde")
	public ResponseEntity<Veiculos> updateVeiculos(@PathVariable Long id,@RequestBody Veiculos veiculos) {
		Veiculos updatedVeiculos = veiculosService.updateVeiculos(id, veiculos);
		if (updatedVeiculos != null) {
			return ResponseEntity.ok(updatedVeiculos);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta um veiculo")
	public ResponseEntity<String> deleteVeiculos(@PathVariable Long id) {
		boolean deleted = veiculosService.deleteVeiculos(id);
		if (deleted) {
			return ResponseEntity.ok().body("O veiculo foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}



