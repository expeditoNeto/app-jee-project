package com.architecture.infrastructure.repositories.negocio;

import java.util.List;

import com.architecture.domain.entities.RamoAtividade;
import com.architecture.domain.repositories.contracts.negocio.IRamoAtividadeRepository;
import com.architecture.infrastructure.repositories.GenericRepository;

import jakarta.persistence.TypedQuery;

public class RamoAtividadeRepository extends GenericRepository<RamoAtividade> implements IRamoAtividadeRepository {

	private static final long serialVersionUID = -212350208602528629L;

	public RamoAtividadeRepository() {
		super();
	}

	@Override
	public List<RamoAtividade> listarPorDescricao(String descricao) {
		String sql = sqlListarPorDescricao();
		TypedQuery<RamoAtividade> query = entityManager.createQuery(sql, RamoAtividade.class);
		query.setParameter("descricao", descricao + "%");
		
		return query.getResultList();
	}
	
	private String sqlListarPorDescricao() {
		StringBuilder sql = new StringBuilder(200);
		
		sql.append("SELECT ra FROM RamoAtividade WHERE descricao like :descricao");
		
		return sql.toString();
	}

}
