package com.architecture.application.services.contracts;

import java.util.List;

import com.architecture.application.model.EmpresaModel;
import com.architecture.infrastructure.util.NegocioException;

public interface IEmpresaAppService extends IGenericAppService<EmpresaModel> {
	public List<EmpresaModel> listarPorNomeFantasia(String nomeFantasia) throws NegocioException;
}
