package com.architecture.application.model;

import java.io.Serializable;
import java.util.Set;

public class RamoAtividadeModel extends BaseModel implements Serializable {

	private static final long serialVersionUID = 2522498815796364860L;
	
	private Set<EmpresaModel> empresas;
	
	private String descricao;

	
	public Set<EmpresaModel> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(Set<EmpresaModel> empresas) {
		this.empresas = empresas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		RamoAtividadeModel other = (RamoAtividadeModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
