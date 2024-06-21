package com.architecture.infrastructure.repositories;

import java.util.List;

import com.architecture.domain.entities.Empresa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SchemaGeneration {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WorksPU");
		
		EntityManager em = emf.createEntityManager();
		
		List<Empresa> empresas = em.createQuery("from Empresa", Empresa.class).getResultList();
		
		em.close();
		emf.close();
	}

}
