package com.architecture.presentation.viewmodel;

import java.io.Serializable;
import java.util.Date;

import com.architecture.application.model.TipoEmpresaModel;

public class EmpresaViewModel extends BaseViewModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nomeFantasia;
	
	private String razaoSocial;
	
	private String cnpj;
	
	private Date dataFundacao;
	
	private RamoAtividadeViewModel ramoAtividade;
	
	private TipoEmpresaModel tipo;
	
	public boolean isRendered() {
		return this != null;
	}
		
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public RamoAtividadeViewModel getRamoAtividade() {
		return ramoAtividade;
	}

	public void setRamoAtividade(RamoAtividadeViewModel ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

	public TipoEmpresaModel getTipo() {
		return tipo;
	}

	public void setTipo(TipoEmpresaModel tipo) {
		this.tipo = tipo;
	}
}
