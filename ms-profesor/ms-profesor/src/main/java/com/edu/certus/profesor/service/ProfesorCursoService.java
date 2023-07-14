package com.edu.certus.profesor.service;

import com.edu.certus.profesor.dto.ProfesorCursoDto;
import com.edu.certus.profesor.dto.ResponseDto;

public interface ProfesorCursoService {
	public ResponseDto getAllProfesorCurso();
	public ResponseDto getProfesorCurso(Long idProfesor);
	public ResponseDto createProfesorCurso(ProfesorCursoDto profesorCursoDto);
	public ResponseDto updateProfesorCurso(ProfesorCursoDto profesorCursoDto);
	
	public ResponseDto getCursoProfesor(Long idCurso);
}
