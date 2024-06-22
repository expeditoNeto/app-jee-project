package com.architecture.infrastructure.repositories.negocio;

import java.util.List;

import com.architecture.domain.entities.Empresa;
import com.architecture.domain.repositories.contracts.negocio.IEmpresaRepository;
import com.architecture.infrastructure.repositories.GenericRepository;

import jakarta.persistence.TypedQuery;

public class EmpresaRepository extends GenericRepository<Empresa> implements IEmpresaRepository {

	private static final long serialVersionUID = -6804585656385295702L;

	public EmpresaRepository() {
		super();		
	}

	@Override
	public List<Empresa> listarPorNomeFantasia(String nomeFantasia) {
		String sql = sqlListarPorNome();
		TypedQuery<Empresa> query = entityManager.createQuery(sql, Empresa.class);
		query.setParameter("nomeFantasia", nomeFantasia + "%");
		return query.getResultList();
	}
	
	private String sqlListarPorNome() {
		StringBuilder sql = new StringBuilder(200);
		
		sql.append("SELECT e FROM Empresa WHERE nomeFAntasio like :nomeFantasia");
		
		return sql.toString();
	}
}
