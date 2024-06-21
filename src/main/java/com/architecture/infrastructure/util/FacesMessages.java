package com.architecture.infrastructure.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesMessages {
	private void add(String msg, FacesMessage.Severity severity) {
        FacesMessage facesMessage = new FacesMessage(msg);
        facesMessage.setSeverity(severity);
        
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    
	
    public void info(String mensagem) {
        add(mensagem, FacesMessage.SEVERITY_INFO);
    }
    
    public void error(String mensagem){
        add(mensagem, FacesMessage.SEVERITY_ERROR);
    }

}
