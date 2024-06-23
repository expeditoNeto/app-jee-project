package com.architecture.infrastructure.util;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import org.modelmapper.ModelMapper;

@ApplicationScoped
public class MapperProducer {
	private  ModelMapper modelMapper = null;
	
	
	
	public MapperProducer() {
		this.modelMapper = new ModelMapper();
	}


	@Produces
	@RequestScoped
	public IMapper createIMapper(){
		
	    return new IMapper() {

	      @Override
	      public <D> D map(Object source, Class<D> destinationType) {
	        
	        return modelMapper.map(source, destinationType);
	      }

	      @Override
	      public void map(Object source, Object destination) {
	        modelMapper.map(source, destination);
	      }

	      @Override
	      public <D> List<D> map(List<?> source, Class<D[]> destinationType) {
	        List<D> destination = Arrays
	          .asList(modelMapper.map(source, destinationType));
	        return destination;
	      }    
	      
	    };
	  }
	
	public void closeIMapper(@Disposes IMapper mapper) {
		mapper = null;
	}
}
