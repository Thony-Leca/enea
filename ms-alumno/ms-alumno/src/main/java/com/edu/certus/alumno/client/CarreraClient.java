/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.certus.alumno.client;

import com.edu.certus.alumno.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-carrera")
public interface CarreraClient {
    	@GetMapping("/v1/carrera")
	ResponseDto readAllCarrera();
	
	@GetMapping("/v1/carrera/{id}")
	ResponseDto readCarrera(@PathVariable("id") Long id);
}
