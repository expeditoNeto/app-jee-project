package com.architecture.domain.repositories.contracts.negocio;

import java.io.Serializable;
import java.util.List;

import com.architecture.domain.entities.Empresa;
import com.architecture.domain.repositories.contracts.IGenericRepository;

public interface IEmpresaRepository extends IGenericRepository<Empresa>, Serializable {
	
	public List<Empresa> listarPorNomeFantasia(String nomeFantasia);
}
