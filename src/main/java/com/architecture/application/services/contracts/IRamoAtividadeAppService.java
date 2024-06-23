package com.architecture.application.services.contracts;

import java.util.List;

import com.architecture.application.model.RamoAtividadeModel;
import com.architecture.infrastructure.util.NegocioException;

public interface IRamoAtividadeAppService extends IGenericAppService<RamoAtividadeModel> {
	public List<RamoAtividadeModel> listarPorDescricao(String descricao) throws NegocioException;
}
