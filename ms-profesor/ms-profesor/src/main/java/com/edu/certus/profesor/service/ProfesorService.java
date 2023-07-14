package com.edu.certus.profesor.service;

import com.edu.certus.profesor.dto.ProfesorDto;
import com.edu.certus.profesor.dto.ResponseDto;

public interface ProfesorService {
	public ResponseDto getAllProfesor();
	public ResponseDto getProfesor(Long id);
	public ResponseDto createProfesor(ProfesorDto profesor);
	public ResponseDto updateProfesor(ProfesorDto profesor);
	public ResponseDto deleteProfesor(Long id);
}
