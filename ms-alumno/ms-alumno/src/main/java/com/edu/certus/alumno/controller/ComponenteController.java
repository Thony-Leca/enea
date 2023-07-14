package com.edu.certus.alumno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edu.certus.alumno.service.ComponenteService;

@RestController
@RequestMapping("/v1/componente")
public class ComponenteController {

	@Autowired
	private ComponenteService componenteService;
	
	@GetMapping
	public String getServiceDockerController() {
		return componenteService.getServiceDocker();
	}
}
