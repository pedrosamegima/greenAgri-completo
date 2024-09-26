package com.greenagri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenagri.entities.Veiculos;
import com.greenagri.repository.VeiculosRepository;

@Service
public class VeiculosService {
	private final VeiculosRepository veiculosRepository;

	@Autowired
	public VeiculosService(VeiculosRepository veiculosRepository) {
		this.veiculosRepository = veiculosRepository;
	}

	public List<Veiculos> getAllVeiculos() {
		return veiculosRepository.findAll();
	}

	public Veiculos getVeiculosById(Long id) {
		Optional<Veiculos> Veiculos = veiculosRepository.findById(id);
		return Veiculos.orElse(null);
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

	public Veiculos salvarVeiculos(Veiculos veiculos) {
		return veiculosRepository.save(veiculos);
	}

	public Veiculos updateVeiculos(Long id, Veiculos updatedVeiculos) {
		Optional<Veiculos> existingVeiculos = veiculosRepository.findById(id);
		if (existingVeiculos.isPresent()) {
			updatedVeiculos.setId(id);
			return veiculosRepository.save(updatedVeiculos);
		}
		return null;
	}

	public boolean deleteVeiculos(Long id) {
		Optional<Veiculos> existingVeiculos = veiculosRepository.findById(id);
		if (existingVeiculos.isPresent()) {
			veiculosRepository.deleteById(id);
			return true;
		}
		return false;
	}




}



