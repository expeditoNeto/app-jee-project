package com.architecture.presentation.managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.architecture.application.model.EmpresaModel;
import com.architecture.application.model.RamoAtividadeModel;
import com.architecture.application.model.TipoEmpresaModel;
import com.architecture.application.services.contracts.IEmpresaAppService;
import com.architecture.application.services.contracts.IRamoAtividadeAppService;
import com.architecture.infrastructure.util.FacesMessages;
import com.architecture.infrastructure.util.IMapper;
import com.architecture.infrastructure.util.NegocioException;
import com.architecture.presentation.converter.RamoAtividadeConverter;
import com.architecture.presentation.viewmodel.EmpresaViewModel;
import com.architecture.presentation.viewmodel.PesquisaViewModel;
import com.architecture.presentation.viewmodel.RamoAtividadeViewModel;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 6025637519365925671L;
	
	private EmpresaViewModel empresaViewModel;
	private List<EmpresaViewModel> empresaViewModels;
	private PesquisaViewModel pesquisa = new PesquisaViewModel();
	private Converter ramoAtividadeConverter;
	
	@Inject
    private FacesMessages messages;
	@Inject
	private IMapper mapper;	
	@Inject
	private IEmpresaAppService empresaAppService;
	@Inject
	private IRamoAtividadeAppService ramoAtividadeAppService;
	
	
	public void todasEmpresas() {
		
		List<EmpresaModel> empresaModels = this.empresaAppService.listar();
		this.empresaViewModels = mapper.map(empresaModels, EmpresaViewModel[].class);		
		
	}
	
	public void pesquisar() {
		try {
			List<EmpresaModel> empresaModels = this.empresaAppService
				.listarPorNomeFantasia(this.pesquisa.getNomeFantasia());;
			this.empresaViewModels = mapper.map(empresaModels, EmpresaViewModel[].class);
		} catch (NegocioException e) {
			this.messages.error(e.getMessage());
		}
	}
	
	public void salvar() {
        EmpresaModel empresaModel = this.mapper.map(empresaViewModel, EmpresaModel.class);
        
        try {
			this.empresaAppService.salvar(empresaModel);
			todasEmpresas();
		} catch (NegocioException e) {
			this.messages.error(e.getMessage());
			return;
		}
        this.messages.info("Empresa salva com sucesso!");
        
        RequestContext.getCurrentInstance().update(Arrays.asList(
                "frm:empresasDataTable", "frm:messages"));
    }
	
	public List<RamoAtividadeViewModel> completarRamoAtividade(String termo) {
        
		List<RamoAtividadeModel> ramoAtividadeModels = null;
		List<RamoAtividadeViewModel> ramoAtividadeViewModels = new ArrayList<>();
		try {
			ramoAtividadeModels = this.ramoAtividadeAppService
					.listarPorDescricao(termo);
			ramoAtividadeViewModels = this.mapper
				.map(ramoAtividadeModels, RamoAtividadeViewModel[].class);
			this.ramoAtividadeConverter = new RamoAtividadeConverter(ramoAtividadeViewModels);
		} catch (NegocioException e) {
			this.messages.error(e.getMessage());
		}
        
		return ramoAtividadeViewModels;
    }
	
	public void prepararNovaEmpresa() {
        this.empresaViewModel = new EmpresaViewModel();
    }
	
	public void excluir() {
        try {
			empresaAppService.excluir(empresaViewModel.getId());
			empresaViewModel = null;
	        
	        todasEmpresas();
		} catch (NegocioException e) {
			this.messages.error(e.getMessage());
			return;
		}
                
        messages.info("Empresa excluída com sucesso!");
    }

	public EmpresaViewModel getEmpresaViewModel() {
		return empresaViewModel;
	}

	public void setEmpresaViewModel(EmpresaViewModel empresaViewModel) {
		this.empresaViewModel = empresaViewModel;
	}

	public List<EmpresaViewModel> getEmpresaViewModels() {
		return empresaViewModels;
	}

	public void setEmpresaViewModels(List<EmpresaViewModel> empresaViewModels) {
		this.empresaViewModels = empresaViewModels;
	}

	public PesquisaViewModel getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(PesquisaViewModel pesquisa) {
		this.pesquisa = pesquisa;
	}
	
	public TipoEmpresaModel[] getTiposEmpresa() {
        return TipoEmpresaModel.values();
    }

	public Converter getRamoAtividadeConverter() {
		return ramoAtividadeConverter;
	}
	
	public boolean isEmpresaSeleciona() {
        return !(empresaViewModel != null && empresaViewModel.getId() != null);
    }
}
