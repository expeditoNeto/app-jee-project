package com.architecture.presentation.viewmodel;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class PesquisaViewModel implements Serializable{
	
	private static final long serialVersionUID = -1460273413600404998L;
	
	@NotBlank
	private String nomeFantasia;
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	
	
}
