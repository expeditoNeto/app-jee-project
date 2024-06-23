package com.architecture.application.services.contracts;

import java.io.Serializable;
import java.util.List;

import com.architecture.application.model.BaseModel;
import com.architecture.infrastructure.util.NegocioException;

public interface IGenericAppService<Model extends BaseModel> extends Serializable {
	public void salvar(Model model) throws NegocioException;
	public void excluir(Long id) throws NegocioException;
	public Model bucarPorId(Long id) throws NegocioException;
	public List<Model> listar() throws NegocioException;
}
