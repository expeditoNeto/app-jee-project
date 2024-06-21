package com.architecture.infrastructure.repositories;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import com.architecture.domain.entities.BaseEntity;
import com.architecture.domain.repositories.contracts.IGenericRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class GenericRepository<Entity extends BaseEntity> implements IGenericRepository<Entity> {

	//@Inject
	protected EntityManager entityManager;
	private Class<Entity> classEntity;
	
	@SuppressWarnings({ "unchecked", })
	protected GenericRepository(EntityManager entityManager) {
		Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        classEntity = (Class<Entity>) pt.getActualTypeArguments()[0];
        this.entityManager = entityManager;
	}

	@Override
	public void salvar(Entity entity) {		
		entityManager.merge(entity);
	}

	@Override
	public void excluir(Long id) {
		Entity entity = bucarPorId(id);
		entityManager.remove(entity);		
	}

	
	@Override
	public Entity bucarPorId(Long id) {		
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
