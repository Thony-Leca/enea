package com.edu.certus.componente.service.impl;

import org.springframework.stereotype.Service;

import com.edu.certus.componente.service.ComponenteService;

@Service
public class ComponenteServiceImpl implements ComponenteService {

	@Override
	public String getServiceDocker() {
		
		return "Desplegar Docker Ok";
	}

}
