package com.architecture.domain.entities;

public enum TipoEmpresa {
	MEI(0, "Microempreendedor Individual"), 
	EIRELI(1, "Empresa Individual de Responsabilidade Limitada"),
	LTDA(2, "Sociedade Limitada"),
	SA(3, "Sociedade Anônima");
	
	private Integer id;
	private String descricao;

	
	
	private TipoEmpresa(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}



	public String getDescricao() {
		return descricao;
	}

	
}
