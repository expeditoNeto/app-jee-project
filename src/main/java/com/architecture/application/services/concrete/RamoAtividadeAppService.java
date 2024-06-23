package com.architecture.application.services.concrete;

import java.util.List;

import javax.inject.Inject;

import com.architecture.application.model.RamoAtividadeModel;
import com.architecture.application.services.contracts.IRamoAtividadeAppService;
import com.architecture.domain.entities.RamoAtividade;
import com.architecture.domain.services.contracts.IRamoAtividadeService;
import com.architecture.infrastructure.util.IMapper;
import com.architecture.infrastructure.util.NegocioException;

import jakarta.transaction.Transactional;

@Transactional(value = Transactional.TxType.REQUIRES_NEW)
public class RamoAtividadeAppService implements IRamoAtividadeAppService {

	private static final long serialVersionUID = 4137538678362148877L;
	
	@Inject
	private IRamoAtividadeService ramoAtividadeService;
	@Inject
	private IMapper mapper;
	@Override
	public void salvar(RamoAtividadeModel model)  throws NegocioException{
		RamoAtividade ramoAtividade = this.mapper.map(model, RamoAtividade.class);
		
		try {
			this.ramoAtividadeService.salvar(ramoAtividade);
		}catch (Exception e) {
			throw new NegocioException("Ocorreu um erro ao salvar Ramo Atividade.");
		}

	}

	@Override
	public void excluir(Long id)  throws NegocioException{

		try {
			this.ramoAtividadeService.excluir(id);;
		}catch (Exception e) {
			throw new NegocioException("Ocorreu um erro ao excluir Ramo Atividade.");
		}

	}

	@Override
	public RamoAtividadeModel bucarPorId(Long id)  throws NegocioException{
		RamoAtividade ramoAtividade = null;
		try {
			ramoAtividade = this.ramoAtividadeService.bucarPorId(id);
			if (ramoAtividade == null) {
				throw new NegocioException("Ramo Atividade n\u00E3o encontrado.");
			}
		}catch (Exception e) {
			throw new NegocioException("Ocorreu um erro ao buscar Ramo Atividade.");
		}
		
		return mapper.map(ramoAtividade, RamoAtividadeModel.class);
	}

	@Override
	public List<RamoAtividadeModel> listar()  throws NegocioException{
		List<RamoAtividade> ramoAtividades = null;
		try {
			ramoAtividades = this.ramoAtividadeService.listar();
			if (ramoAtividades.isEmpty()) {
				throw new NegocioException("N\u00E3o temos Ramo Atividade cadastradas.");
			}
		}catch (Exception e) {
			throw new NegocioException("Ocorreu um erro ao buscar Ramo Atividade.");
		}
		return mapper.map(ramoAtividades, RamoAtividadeModel[].class);
	}

	@Override
	public List<RamoAtividadeModel> listarPorDescricao(String descricao)  throws NegocioException{
		List<RamoAtividade> ramoAtividades = null;
		try {
			ramoAtividades = this.ramoAtividadeService.listarPorDescricao(descricao);
			if (ramoAtividades.isEmpty()) {
				throw new NegocioException("N\u00E3o temos Ramo Atividade cadastradas.");
			}
		}catch (Exception e) {
			throw new NegocioException("Ocorreu um erro ao buscar Ramo Atividade.");
		}
		return mapper.map(ramoAtividades, RamoAtividadeModel[].class);
	}

}
