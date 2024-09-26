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

import com.greenagri.entities.Produtos;
import com.greenagri.service.ProdutosService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*")
public class ProdutosController {
	private final ProdutosService produtosService;
	@Autowired
	public ProdutosController(ProdutosService produtosService) {
		this.produtosService = produtosService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza produto por ID")
	public ResponseEntity<Produtos> getProdutosById(@PathVariable Long id) {
		Produtos produtos = produtosService.getProdutosById(id);
		if (produtos != null) {
			return ResponseEntity.ok(produtos);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	@Operation(summary = "Aprensenta todos os produtos")
	public ResponseEntity<List<Produtos>> getAllProdutos() {
		List<Produtos> produtos = produtosService.getAllProdutos();
		return ResponseEntity.ok(produtos);
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
	@Operation(summary = "Cadastra um produto")
	public ResponseEntity<Produtos> criarProdutos(@RequestBody Produtos produtos) {
		Produtos criarProdutos = produtosService.salvarProdutos(produtos);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarProdutos);
	}


	@PutMapping("/{id}")
	@Operation(summary = "Altera o produto")
	public ResponseEntity<Produtos> updateProdutos(@PathVariable Long id,@RequestBody Produtos produtos) {
		Produtos updatedProdutos = produtosService.updateProdutos(id, produtos);
		if (updatedProdutos != null) {
			return ResponseEntity.ok(updatedProdutos);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta um produto")
	public ResponseEntity<String> deleteProdutos(@PathVariable Long id) {
		boolean deleted = produtosService.deleteProdutos(id);
		if (deleted) {
			return ResponseEntity.ok().body("O produto foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}

