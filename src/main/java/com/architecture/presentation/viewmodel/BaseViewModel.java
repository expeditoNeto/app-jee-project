package com.architecture.presentation.viewmodel;

public abstract class BaseViewModel {
	protected Long id;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
