package com.architecture.domain.services.concrete;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import com.architecture.domain.entities.RamoAtividade;
import com.architecture.domain.repositories.contracts.negocio.IRamoAtividadeRepository;
import com.architecture.domain.services.contracts.IRamoAtividadeService;

public class RamoAtividadeService implements IRamoAtividadeService {

	private static final long serialVersionUID = 5600194066186617942L;
	@Inject
	private IRamoAtividadeRepository ramoAtividadeRepository;
	
	@Override
	public void salvar(RamoAtividade entity) {
		ramoAtividadeRepository.salvar(entity);

	}

	@Override
	public void excluir(UUID id) {
		ramoAtividadeRepository.equals(id);

	}

	@Override
	public RamoAtividade bucarPorId(UUID id) {
		return ramoAtividadeRepository.bucarPorId(id);
	}

	@Override
	public List<RamoAtividade> listar() {
		return ramoAtividadeRepository.listar();
	}

	@Override
	public List<RamoAtividade> listarPorDescricao(String descricao) {
		String paramentro = null;
		if(descricao != null) {
			paramentro = descricao.toLowerCase();
		}
		return ramoAtividadeRepository.listarPorDescricao(paramentro);
	}

}
