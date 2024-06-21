package com.architecture.domain.repositories.contracts;

import java.io.Serializable;
import java.util.List;

import com.architecture.domain.entities.BaseEntity;

public interface IGenericRepository<Entity extends BaseEntity> extends Serializable {
	
	public Entity salvar(Entity entity);
	public void excluir(Entity entity);
	public Entity bucarPorId(Long id);
	public List<Entity> listar();
	
}
