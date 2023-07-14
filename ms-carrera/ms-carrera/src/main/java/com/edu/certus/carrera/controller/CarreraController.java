/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.certus.carrera.controller;

import com.edu.certus.carrera.dto.CarreraDto;
import com.edu.certus.carrera.dto.ResponseDto;
import com.edu.certus.carrera.service.CarreraService;
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
@RequestMapping("/v1/carrera")
public class CarreraController {
    
    @Autowired
    private CarreraService carreraService;
    
    @GetMapping()
	public ResponseEntity<ResponseDto> readAllCarrera(){
		return ResponseEntity.status(HttpStatus.OK).body(carreraService.getAllCarrera());
	}
    @GetMapping("/{id}")
        public ResponseEntity<ResponseDto> readCarrera(@PathVariable("id")Long id){
		return ResponseEntity.status(HttpStatus.OK).body(carreraService.getCarrera(id));
	}
    @PostMapping
	public ResponseEntity<ResponseDto> createCarrera(@RequestBody CarreraDto carrera){
		return ResponseEntity.status(HttpStatus.CREATED).body(carreraService.createCarrera(carrera));
	}
	
    @PutMapping
	public ResponseEntity<ResponseDto> updateCarrera(@RequestBody CarreraDto carrera){
		return ResponseEntity.status(HttpStatus.CREATED).body(carreraService.updateCarrera(carrera));
	}
}
