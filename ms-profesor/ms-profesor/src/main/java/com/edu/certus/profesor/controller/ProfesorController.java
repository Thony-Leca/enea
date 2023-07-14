package com.edu.certus.profesor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.certus.profesor.dto.ProfesorDto;
import com.edu.certus.profesor.dto.ResponseDto;
import com.edu.certus.profesor.service.ProfesorService;

@RestController
@RequestMapping("/v1/profesor")
public class ProfesorController {

	@Autowired
	private ProfesorService profesorService;
	
	@GetMapping()
	public ResponseEntity<ResponseDto> readAllProfesor(){
		return ResponseEntity.status(HttpStatus.OK).body(profesorService.getAllProfesor());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDto> readProfesor(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(profesorService.getProfesor(id));
	}
	
	@PostMapping
	public ResponseEntity<ResponseDto> createProfesor(@RequestBody ProfesorDto profesor){
		return ResponseEntity.status(HttpStatus.CREATED).body(profesorService.createProfesor(profesor));
	}
	
	@PutMapping
	public ResponseEntity<ResponseDto> updateProfesor(@RequestBody ProfesorDto profesor){
		return ResponseEntity.status(HttpStatus.CREATED).body(profesorService.updateProfesor(profesor));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDto> deleteProfesor(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(profesorService.deleteProfesor(id));
	}
}
