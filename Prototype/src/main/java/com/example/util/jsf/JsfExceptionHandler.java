package com.example.util.jsf;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import com.example.service.BusinessRuleExpection;


public class JsfExceptionHandler extends ExceptionHandlerWrapper {

	private ExceptionHandler wrapped;
	
	public JsfExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}
	
	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}
	
	@Override
	public void handle() throws FacesException {
		Iterator<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents().iterator();
		 
		while (events.hasNext()) {
			ExceptionQueuedEvent event = events.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
			
			Throwable exception = context.getException();
			BusinessRuleExpection businessException = getBusinessRuleExpection(exception);
			
			boolean handled = false;
			
			try {
				if (exception instanceof ViewExpiredException) {
					handled = true;
					redirect("/");
				} else if (businessException != null) {
					handled = true;
					FacesUtil.addErrorMessage(businessException.getMessage());
				} else {
					handled = true;
					redirect("/Error.xhtml");
				}
			} finally {
				if (handled) {
					events.remove();
				}
			}
		}
		
		getWrapped().handle();
	}
	
	private BusinessRuleExpection getBusinessRuleExpection(Throwable exception) {
		if (exception instanceof BusinessRuleExpection) {
			return (BusinessRuleExpection) exception;
		} else if (exception.getCause() != null) {
			return getBusinessRuleExpection(exception.getCause());
		}
		
		return null;
	}
	
	private void redirect(String page) {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContext.getExternalContext();
			String contextPath = externalContext.getRequestContextPath();
	
			externalContext.redirect(contextPath + page);
			facesContext.responseComplete();
		} catch (IOException e) {
			throw new FacesException(e);
		}
	}

}