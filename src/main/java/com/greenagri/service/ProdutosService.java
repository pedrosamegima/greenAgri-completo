package com.greenagri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenagri.entities.Produtos;
import com.greenagri.repository.ProdutosRepository;

@Service
public class ProdutosService {
	private final ProdutosRepository produtosRepository;
	
	@Autowired
	public ProdutosService(ProdutosRepository produtosRepository) {
		this.produtosRepository = produtosRepository;
		}

		public List<Produtos> getAllProdutos() {
			return produtosRepository.findAll();
		}

		public Produtos getProdutosById(Long id) {
			Optional<Produtos> Produtos = produtosRepository.findById(id);
			return Produtos.orElse(null);
		}
		//Query Method
		//public List<Consulta> getConsultaPorData(String data){
			//return consultaRepository.findByData(data);
		//}
		//@Query
		//public List<Consulta> findByHora(String hora){
			//return consultaRepository.findByHora(hora);
		//}
		//@Query
		//public List<Consulta> findByDescricao(String descricao){
			//return consultaRepository.findByHora(descricao);
		//}

		public Produtos salvarProdutos(Produtos produtos) {
			return produtosRepository.save(produtos);
		}

		public Produtos updateProdutos(Long id, Produtos updatedProdutos) {
			Optional<Produtos> existingProdutos = produtosRepository.findById(id);
			if (existingProdutos.isPresent()) {
				updatedProdutos.setId(id);
				return produtosRepository.save(updatedProdutos);
			}
			return null;
		}

		public boolean deleteProdutos(Long id) {
			Optional<Produtos> existingProdutos = produtosRepository.findById(id);
			if (existingProdutos.isPresent()) {
				produtosRepository.deleteById(id);
				return true;
			}
			return false;
		}
	



	}

