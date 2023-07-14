/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.certus.carrera.service;

import com.edu.certus.carrera.dto.CarreraDto;
import com.edu.certus.carrera.dto.ResponseDto;


public interface CarreraService {
    	public ResponseDto getAllCarrera();
	public ResponseDto getCarrera(Long id);
	public ResponseDto createCarrera(CarreraDto carrera);
	public ResponseDto updateCarrera(CarreraDto carrera);
}
