package com.architecture.application.services.contracts;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import com.architecture.application.model.BaseModel;
import com.architecture.infrastructure.util.NegocioException;

public interface IGenericAppService<Model extends BaseModel> extends Serializable {
	public void salvar(Model model) throws NegocioException;
	public void excluir(UUID id) throws NegocioException;
	public Model bucarPorId(UUID id) throws NegocioException;
	public List<Model> listar();
}
