package com.architecture.domain.repositories.contracts;

import java.util.List;

import com.architecture.domain.entities.BaseEntity;

public interface IGenericRepository<Entity extends BaseEntity> {
	
	public void salvar(Entity entity);
	public void excluir(Long id);
	public Entity bucarPorId(Long id);
	public List<Entity> listar();
	
}
