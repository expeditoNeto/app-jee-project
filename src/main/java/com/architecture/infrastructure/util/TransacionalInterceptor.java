package com.architecture.infrastructure.util;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@Interceptor
@Transacional
@Priority(Interceptor.Priority.APPLICATION)
public class TransacionalInterceptor implements Serializable {
    
	private static final long serialVersionUID = -7308866099741099895L;
	@Inject
    private EntityManager manager;

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        EntityTransaction entityTransaction = manager.getTransaction();
        boolean criador = false;

        try {
            if (!entityTransaction.isActive()) {
                
                entityTransaction.begin();
                entityTransaction.rollback();

                entityTransaction.begin();

                criador = true;
            }

            return context.proceed();
        } catch (Exception e) {
            if (entityTransaction != null && criador) {
                entityTransaction.rollback();
            }

            throw new Exception(e);
        } finally {
            if (entityTransaction != null && entityTransaction.isActive() && criador) {
                entityTransaction.commit();
            }
        }
    }
}
