package com.architecture.infrastructure.repositories;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import com.architecture.domain.entities.BaseEntity;
import com.architecture.domain.repositories.contracts.IGenericRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public abstract class GenericRepository<Entity extends BaseEntity> implements IGenericRepository<Entity> {

	@Inject
	protected EntityManager entityManager;
	private Class<Entity> classEntity;
	
	@SuppressWarnings({ "unchecked", })
	protected GenericRepository() {
		Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        classEntity = (Class<Entity>) pt.getActualTypeArguments()[0];
	}

	@Override
	public void salvar(Entity entity) {	
		entityManager.merge(entity);
	}

	@Override
	public void excluir(UUID id) {
		Entity entity = bucarPorId(id);
		entityManager.remove(entity);		
	}

	
	@Override
	public Entity bucarPorId(UUID id) {		
		return entityManager.find(classEntity, id);
	}

	@Override
	public List<Entity> listar() {
		StringBuilder sql = new StringBuilder(80);
		sql.append("FROM ").append(classEntity.getName());
		TypedQuery<Entity> query = entityManager.createQuery(sql.toString(), classEntity);
		return query.getResultList();
	}

}
