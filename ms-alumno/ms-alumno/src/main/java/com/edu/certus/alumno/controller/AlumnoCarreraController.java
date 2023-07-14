/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.certus.alumno.controller;

import com.edu.certus.alumno.dto.AlumnoCarreraDto;
import com.edu.certus.alumno.dto.ResponseDto;
import com.edu.certus.alumno.service.AlumnoCarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/alumno-carrera")
public class AlumnoCarreraController {
    
	@Autowired
	private AlumnoCarreraService alumnoCarreraService;
	
	@GetMapping
	public ResponseEntity<ResponseDto> getAllAlumnoCarrera(){
		return ResponseEntity.status(HttpStatus.OK).body(alumnoCarreraService.getAllAlumnoCarrera());
	}

	@GetMapping("/{idAlumno}")
	public ResponseEntity<ResponseDto> getAlumnoCarrera(@PathVariable("idAlumno") Long idAlumno){
		return ResponseEntity.status(HttpStatus.OK).body(alumnoCarreraService.getAlumnoCarrera(idAlumno));
	}
	
	@PostMapping
	public ResponseEntity<ResponseDto> createAlumnoCarrera(@RequestBody AlumnoCarreraDto alumnoCarreraDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoCarreraService.createAlumnoCarrera(alumnoCarreraDto));
	}
	
	@PutMapping
	public ResponseEntity<ResponseDto> updateAlumnoCarrera(@RequestBody AlumnoCarreraDto alumnoCarreraDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoCarreraService.updateAlumnoCarrera(alumnoCarreraDto));
	}
}
