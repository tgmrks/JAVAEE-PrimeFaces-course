package com.example.util.jpa;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	private @Inject EntityManager manager;
	
	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		EntityTransaction trx = manager.getTransaction();
		boolean creator = false;

		try {
			if (!trx.isActive()) {
				// do rollback
				trx.begin();
				trx.rollback();
				
				// then bigin transac
				trx.begin();
				
				creator = true;
			}

			return context.proceed();
		} catch (Exception e) {
			if (trx != null && creator) {
				trx.rollback();
			}

			throw e;
		} finally {
			if (trx != null && trx.isActive() && creator) {
				trx.commit();
			}
		}
	}	
}