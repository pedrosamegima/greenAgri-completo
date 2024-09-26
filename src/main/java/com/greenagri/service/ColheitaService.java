package com.greenagri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenagri.entities.Colheita;
import com.greenagri.repository.ColheitaRepository;

@Service
public class ColheitaService {
	private final ColheitaRepository colheitaRepository;
	
	@Autowired
	public ColheitaService(ColheitaRepository colheitaRepository) {
		this.colheitaRepository = colheitaRepository;
	}

	public List<Colheita> getAllColheita() {
		return colheitaRepository.findAll();
	}

	public Colheita getColheitaById(Long id) {
		Optional<Colheita> Colheita = colheitaRepository.findById(id);
		return Colheita.orElse(null);
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

	public Colheita salvarColheita(Colheita colheita) {
		return colheitaRepository.save(colheita);
	}

	public Colheita updateColheita(Long id, Colheita updatedColheita) {
		Optional<Colheita> existingColheita = colheitaRepository.findById(id);
		if (existingColheita.isPresent()) {
			updatedColheita.setId(id);
			return colheitaRepository.save(updatedColheita);
		}
		return null;
	}

	public boolean deleteColheita(Long id) {
		Optional<Colheita> existingColheita = colheitaRepository.findById(id);
		if (existingColheita.isPresent()) {
			colheitaRepository.deleteById(id);
			return true;
		}
		return false;
	}


}
