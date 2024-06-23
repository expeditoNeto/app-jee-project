package com.architecture.domain.repositories.contracts;

import java.util.List;
import java.util.UUID;

import com.architecture.domain.entities.BaseEntity;

public interface IGenericRepository<Entity extends BaseEntity> {
	
	public void salvar(Entity entity);
	public void excluir(UUID id);
	public Entity bucarPorId(UUID id);
	public List<Entity> listar();
	
}
