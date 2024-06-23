package com.architecture.domain.services.concrete;

import java.util.List;

import javax.inject.Inject;

import com.architecture.domain.entities.Empresa;
import com.architecture.domain.repositories.contracts.negocio.IEmpresaRepository;
import com.architecture.domain.services.contracts.IEmpresaService;

public class EmpresaService implements IEmpresaService {

	private static final long serialVersionUID = -2819334017271712181L;
	
	@Inject
	private IEmpresaRepository empresaRepository;
	@Override
	public void salvar(Empresa entity) {
		empresaRepository.salvar(entity);
	}

	@Override
	public void excluir(Long id) {
		empresaRepository.excluir(id);
	}

	@Override
	public Empresa bucarPorId(Long id) {
		return empresaRepository.bucarPorId(id);
	}

	@Override
	public List<Empresa> listar() {
		return empresaRepository.listar();
	}

	@Override
	public List<Empresa> listarPorNomeFantasia(String nomeFantasia) {
		return empresaRepository.listarPorNomeFantasia(nomeFantasia);
	}

}
