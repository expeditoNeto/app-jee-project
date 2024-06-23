package com.architecture.presentation.viewmodel;

import java.util.UUID;

public abstract class BaseViewModel {
	protected UUID id;

	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
}
