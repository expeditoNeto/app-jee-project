package com.architecture.application.model;

import java.io.Serializable;
import java.util.Date;

public class EmpresaModel extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = -6741263445968334678L;

	private String nomeFantasia;
	
	private String razaoSocial;
	
	private String cnpj;
	
	private Date dataFundacao;
	
	private RamoAtividadeModel ramoAtividade;
	
	private TipoEmpresaModel tipo;
		
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

	public RamoAtividadeModel getRamoAtividade() {
		return ramoAtividade;
	}

	public void setRamoAtividade(RamoAtividadeModel ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

	public TipoEmpresaModel getTipo() {
		return tipo;
	}

	public void setTipo(TipoEmpresaModel tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpresaModel other = (EmpresaModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
