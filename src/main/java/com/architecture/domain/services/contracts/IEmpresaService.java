package com.architecture.domain.services.contracts;

import java.util.List;

import com.architecture.domain.entities.Empresa;

public interface IEmpresaService extends IGenericService<Empresa> {
	
	public List<Empresa> listarPorNomeFantasia(String nomeFantasia);
}
