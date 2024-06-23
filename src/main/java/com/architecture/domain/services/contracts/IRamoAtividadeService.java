package com.architecture.domain.services.contracts;

import java.util.List;

import com.architecture.domain.entities.RamoAtividade;

public interface IRamoAtividadeService extends IGenericService<RamoAtividade> {
	public List<RamoAtividade> listarPorDescricao(String descricao);
}
