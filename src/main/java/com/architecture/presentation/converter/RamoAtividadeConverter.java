package com.architecture.presentation.converter;

import java.util.List;
import java.util.UUID;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.architecture.presentation.viewmodel.RamoAtividadeViewModel;

public class RamoAtividadeConverter implements Converter {
    
    private List<RamoAtividadeViewModel> ramoAtividadeViewModels;

    public RamoAtividadeConverter(List<RamoAtividadeViewModel> ramoAtividadeViewModels) {
        this.ramoAtividadeViewModels = ramoAtividadeViewModels;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        
        UUID id = UUID.fromString(value);
        
        return ramoAtividadeViewModels.stream()
        	.filter(ra -> id.equals(ra.getId()))
        	.findFirst()
        	.orElse(null);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        
        RamoAtividadeViewModel ramoAtividade = (RamoAtividadeViewModel)value;
        
        return ramoAtividade.getId().toString();
    }

}
