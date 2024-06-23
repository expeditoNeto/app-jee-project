package com.architecture.domain.services.contracts;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import com.architecture.domain.entities.BaseEntity;

public interface IGenericService<Entity extends BaseEntity> extends Serializable {
	public void salvar(Entity entity);
	public void excluir(UUID id);
	public Entity bucarPorId(UUID id);
	public List<Entity> listar();
}
