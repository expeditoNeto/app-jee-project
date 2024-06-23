package com.architecture.domain.services.contracts;

import java.io.Serializable;
import java.util.List;

import com.architecture.domain.entities.BaseEntity;

public interface IGenericService<Entity extends BaseEntity> extends Serializable {
	public void salvar(Entity entity);
	public void excluir(Long id);
	public Entity bucarPorId(Long id);
	public List<Entity> listar();
}
