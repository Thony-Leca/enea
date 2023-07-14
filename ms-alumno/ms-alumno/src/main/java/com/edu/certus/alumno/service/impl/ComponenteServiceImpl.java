package com.edu.certus.alumno.service.impl;

import org.springframework.stereotype.Service;
import com.edu.certus.alumno.service.ComponenteService;

@Service
public class ComponenteServiceImpl implements ComponenteService {

	@Override
	public String getServiceDocker() {
		
		return "Desplegar Docker Ok";
	}

}
