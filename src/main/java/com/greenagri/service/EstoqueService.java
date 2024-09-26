package com.greenagri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenagri.entities.Estoque;
import com.greenagri.repository.EstoqueRepository;

@Service
public class EstoqueService {
	private final EstoqueRepository estoqueRepository;

	@Autowired
	public EstoqueService(EstoqueRepository estoqueRepository) {
		this.estoqueRepository = estoqueRepository;
	}

	public List<Estoque> getAllEstoque() {
		return estoqueRepository.findAll();
	}

	public Estoque getEstoqueById(Long id) {
		Optional<Estoque> Estoque = estoqueRepository.findById(id);
		return Estoque.orElse(null);
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

	public Estoque salvarEstoque(Estoque estoque) {
		return estoqueRepository.save(estoque);
	}

	public Estoque updateEstoque(Long id, Estoque updatedEstoque) {
		Optional<Estoque> existingEstoque = estoqueRepository.findById(id);
		if (existingEstoque.isPresent()) {
			updatedEstoque.setId(id);
			return estoqueRepository.save(updatedEstoque);
		}
		return null;
	}

	public boolean deleteEstoque(Long id) {
		Optional<Estoque> existingEstoque = estoqueRepository.findById(id);
		if (existingEstoque.isPresent()) {
			estoqueRepository.deleteById(id);
			return true;
		}
		return false;
	}




}

