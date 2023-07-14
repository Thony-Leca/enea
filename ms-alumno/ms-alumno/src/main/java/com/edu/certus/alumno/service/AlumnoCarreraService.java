/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.certus.alumno.service;

import com.edu.certus.alumno.dto.AlumnoCarreraDto;
import com.edu.certus.alumno.dto.ResponseDto;


public interface AlumnoCarreraService {
    	public ResponseDto getAllAlumnoCarrera();
	public ResponseDto getAlumnoCarrera(Long id);

	public ResponseDto createAlumnoCarrera(AlumnoCarreraDto alumnoCarreraDto);
	public ResponseDto updateAlumnoCarrera(AlumnoCarreraDto alumnoCarreraDto);
}
