package com.architecture.domain.repositories.contracts.negocio;

import java.io.Serializable;
import java.util.List;

import com.architecture.domain.entities.RamoAtividade;
import com.architecture.domain.repositories.contracts.IGenericRepository;

public interface IRamoAtividadeRepository extends IGenericRepository<RamoAtividade>, Serializable {
	public List<RamoAtividade> listarPorDescricao(String descricao);
}
