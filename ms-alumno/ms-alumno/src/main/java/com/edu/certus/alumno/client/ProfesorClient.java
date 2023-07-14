package com.edu.certus.alumno.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.edu.certus.alumno.dto.ResponseDto;

@FeignClient(name = "ms-profesor")
public interface ProfesorClient {

	@GetMapping("/v1/profesor")
	ResponseDto readAllProfesor();
	
	@GetMapping("/v1/profesor/{id}")
	ResponseDto readProfesor(@PathVariable("id") Long id);
	
	@GetMapping("/v1/profesor-curso")
	ResponseDto getAllProfesorCurso();
	
	@GetMapping("/v1/profesor-curso/id-profesor/{idProfesor}")
	ResponseDto getProfesorCurso(@PathVariable("idProfesor") Long idProfesor);
	
	@GetMapping("/v1/profesor-curso/id-curso/{idCurso}")
	ResponseDto getCursoProfesor(@PathVariable("idCurso") Long idCurso);
}
