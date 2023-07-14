package com.edu.certus.alumno.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.certus.alumno.client.CursoClient;
import com.edu.certus.alumno.client.ProfesorClient;
import com.edu.certus.alumno.dto.AlumnoCursoProfesorDto;
import com.edu.certus.alumno.dto.CursoDto;
import com.edu.certus.alumno.dto.ProfesorCursoDto;
import com.edu.certus.alumno.dto.ResponseDto;
import com.edu.certus.alumno.entity.AlumnoCursoEntity;
import com.edu.certus.alumno.entity.AlumnoEntity;
import com.edu.certus.alumno.repository.AlumnoCursoRepository;
import com.edu.certus.alumno.repository.AlumnoRepository;
import com.edu.certus.alumno.service.AlumnoCursoProfesorService;
import com.edu.certus.alumno.util.Constante;
import com.edu.certus.alumno.util.Util;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AlumnoCursoProfesorServiceImpl implements AlumnoCursoProfesorService{
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private AlumnoCursoRepository alumnoCursoRepository;
	
	@Autowired
	private CursoClient cursoClient;
	
	@Autowired
	private ProfesorClient profesorClient;

	@Override
	public ResponseDto getAllAlumnoCursoProfesor() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<AlumnoCursoEntity> listAlumnoCursoEntity = alumnoCursoRepository.findAll();
			
			List<AlumnoCursoProfesorDto> listAlumnoCursoProfesorDto = new ArrayList<AlumnoCursoProfesorDto>();
			
			for (int i = 0; i < listAlumnoCursoEntity.size(); i++) {
					
				 AlumnoEntity alumnoEntity = alumnoRepository.findById(listAlumnoCursoEntity.get(i).getIdAlumno()).orElse(null);
				 ResponseDto responseDto = cursoClient.readCurso(listAlumnoCursoEntity.get(i).getIdCurso());
				 CursoDto cursoDto = mapper.convertValue(responseDto.getData(), CursoDto.class);
			
				 
				 ResponseDto responseProfesorCursoDto = profesorClient.getCursoProfesor(listAlumnoCursoEntity.get(i).getIdCurso());
				 String jsonResProfesorCursoDto = mapper.writeValueAsString(responseProfesorCursoDto.getData());
				 List<ProfesorCursoDto> listProfesorCursoDto = mapper.readValue(jsonResProfesorCursoDto, new TypeReference<List<ProfesorCursoDto>>() {});
				 
				 
				 for (ProfesorCursoDto profesorCursoDto : listProfesorCursoDto) {
					  
					 listAlumnoCursoProfesorDto.add(AlumnoCursoProfesorDto.builder()
						 .idAlumno(alumnoEntity.getId())
						 .nombreAlumno(alumnoEntity.getNombres() + " " + alumnoEntity.getApellidos())
						 .estadoAlumno(alumnoEntity.getEstado())
						 .idCurso(cursoDto.getId())
						 .nombreCurso(cursoDto.getDescripcion())
						 .idProfesor(profesorCursoDto.getIdProfesor())
						 .nombreProfesor(profesorCursoDto.getNombreProfesor())
						 .build());
				  }
				 
			}
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, listAlumnoCursoProfesorDto);
		} catch (Exception e) {
			log.error(Constante.OPERATION_FAILED, e);
			return Util.getResponse(true, Constante.OPERATION_FAILED, null);
		}

	}

}
