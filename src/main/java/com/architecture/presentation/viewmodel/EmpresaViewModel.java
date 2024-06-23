package com.architecture.presentation.viewmodel;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

import com.architecture.application.model.TipoEmpresaModel;

public class EmpresaViewModel extends BaseViewModel implements Serializable {

	
	private static final long serialVersionUID = -7031668245588822014L;
	
	@NotEmpty
	private String nomeFantasia;
	
	@NotEmpty
	private String razaoSocial;
	
	@CNPJ
	@NotNull
	private String cnpj;
	
	@NotNull
	private Date dataFundacao;
	
	@NotNull
	private RamoAtividadeViewModel ramoAtividade;
	
	@NotNull
	private TipoEmpresaModel tipo;
	
	public boolean isRenderizar() {
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
