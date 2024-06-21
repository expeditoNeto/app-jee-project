package com.architecture.infrastructure.repositories;

import java.util.List;
import java.util.UUID;

import com.architecture.domain.entities.BaseEntity;
import com.architecture.domain.repositories.contracts.IGenericRepository;

public class GenericRepository<Entity extends BaseEntity> implements IGenericRepository<Entity> {

	private static final long serialVersionUID = 5338563468610393543L;
	
	
	
	@Override
	public Entity salvar(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Entity bucarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entity> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
