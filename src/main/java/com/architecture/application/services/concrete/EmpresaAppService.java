package com.architecture.application.services.concrete;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import com.architecture.application.model.EmpresaModel;
import com.architecture.application.services.contracts.IEmpresaAppService;
import com.architecture.domain.entities.Empresa;
import com.architecture.domain.services.contracts.IEmpresaService;
import com.architecture.infrastructure.util.IMapper;
import com.architecture.infrastructure.util.NegocioException;
import com.architecture.infrastructure.util.Transacional;

public class EmpresaAppService implements IEmpresaAppService {

	private static final long serialVersionUID = 419013117985420837L;
	
	@Inject
	private IEmpresaService empresaService;
	@Inject
	private IMapper mapper;
	
	@Override
	@Transacional
	public void salvar(EmpresaModel model)  throws NegocioException{
		Empresa empresa = this.mapper.map(model, Empresa.class);
		
		try {
			this.empresaService.salvar(empresa);
		}catch (Exception e) {
			throw new NegocioException("Ocorreu um erro ao salvar empresa.");
		}

	}

	@Override
	@Transacional
	public void excluir(UUID id)  throws NegocioException{
		try {
			this.empresaService.excluir(id);
		}catch (Exception e) {
			throw new NegocioException("Ocorreu um erro ao excluir empresa.");
		}

	}

	@Override
	public EmpresaModel bucarPorId(UUID id)  throws NegocioException{
		Empresa empresa = null;
		try {
			empresa = this.empresaService.bucarPorId(id);
			if (empresa == null) {
				throw new NegocioException("Empresa n\u00E3o encontrada.");
			}
		}catch (Exception e) {
			throw new NegocioException("Ocorreu um erro ao buscar empresa.");
		}
		
		return mapper.map(empresa, EmpresaModel.class);
	}

	@Override
	public List<EmpresaModel> listar(){
		List<Empresa> empresas = this.empresaService.listar();			
		return mapper.map(empresas, EmpresaModel[].class);
	}

	@Override
	public List<EmpresaModel> listarPorNomeFantasia(String nomeFantasia)  throws NegocioException{
		List<Empresa> empresas = null;
		try {
			empresas = this.empresaService.listarPorNomeFantasia(nomeFantasia);
			if (empresas.isEmpty()) {
				throw new NegocioException("N\u00E3o temos empresa cadastradas.");
			}
		}catch (Exception e) {
			throw new NegocioException("Ocorreu um erro ao buscar empresas.");
		}
		return mapper.map(empresas, EmpresaModel[].class);
	}

}
