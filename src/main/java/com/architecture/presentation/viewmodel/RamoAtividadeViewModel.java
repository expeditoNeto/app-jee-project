package com.architecture.presentation.viewmodel;

import java.util.Set;

public class RamoAtividadeViewModel extends BaseViewModel {
	
private Set<EmpresaViewModel> empresas;
	
	private String descricao;

	
	public Set<EmpresaViewModel> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(Set<EmpresaViewModel> empresas) {
		this.empresas = empresas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
