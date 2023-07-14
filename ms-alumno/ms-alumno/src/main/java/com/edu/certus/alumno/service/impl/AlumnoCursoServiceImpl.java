package com.edu.certus.alumno.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.certus.alumno.client.CursoClient;
import com.edu.certus.alumno.dto.AlumnoCursoDto;
import com.edu.certus.alumno.dto.CursoDto;
import com.edu.certus.alumno.dto.ResponseDto;
import com.edu.certus.alumno.entity.AlumnoCursoEntity;
import com.edu.certus.alumno.entity.AlumnoEntity;
import com.edu.certus.alumno.repository.AlumnoCursoRepository;
import com.edu.certus.alumno.repository.AlumnoRepository;
import com.edu.certus.alumno.service.AlumnoCursoService;
import com.edu.certus.alumno.util.Constante;
import com.edu.certus.alumno.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AlumnoCursoServiceImpl implements AlumnoCursoService {

	@Autowired
	private AlumnoCursoRepository alumnoCursoRepository;
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private CursoClient cursoClient;
	
	@Override
	public ResponseDto getAllAlumnoCurso() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<AlumnoCursoEntity> listAlumnoCursoEntity = alumnoCursoRepository.findAll();
			List<AlumnoCursoDto> listAlumnoCurso = new ArrayList<AlumnoCursoDto>();
			
			for (int i = 0; i < listAlumnoCursoEntity.size(); i++) {
				
				AlumnoEntity alumnoEntity = alumnoRepository.findById(listAlumnoCursoEntity.get(i).getIdAlumno()).orElse(null);
				ResponseDto responseDto = cursoClient.readCurso(listAlumnoCursoEntity.get(i).getIdCurso());
				CursoDto cursoDto = mapper.convertValue(responseDto.getData(), CursoDto.class);
				
				listAlumnoCurso.add(AlumnoCursoDto.builder()
						.id(listAlumnoCursoEntity.get(i).getId())
						.idAlumno(alumnoEntity.getId())
						.nombreAlumno(alumnoEntity.getNombres() + " " + alumnoEntity.getApellidos())
						.estadoAlumno(alumnoEntity.getEstado())
						.idCurso(cursoDto.getId())
						.nombreCurso(cursoDto.getDescripcion())
						.build());
			}
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, listAlumnoCurso);
		}catch (RetryableException ex) {
			log.error(Constante.NO_SERVICE_AVIABLE, ex);
			return Util.getResponse(false, Constante.NO_SERVICE_AVIABLE, null);
		} catch (Exception e) {
			log.error(Constante.OPERATION_FAILED, e);
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}

	@Override
	public ResponseDto getAlumnoCurso(Long idAlumno) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<AlumnoCursoEntity> listAlumnoCursoEntity = alumnoCursoRepository.findByIdAlumno(idAlumno);
			if(listAlumnoCursoEntity == null) {
				return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
			}
			List<AlumnoCursoDto> listAlumnoCursoDto = new ArrayList<AlumnoCursoDto>();
			for (AlumnoCursoEntity alumnoCursoEntity : listAlumnoCursoEntity) {
				
				AlumnoEntity alumnoEntity = alumnoRepository.findById(alumnoCursoEntity.getIdAlumno()).orElse(null);
				ResponseDto responseDto = cursoClient.readCurso(alumnoCursoEntity.getIdCurso());
				CursoDto cursoDto = mapper.convertValue(responseDto.getData(), CursoDto.class);
				
				listAlumnoCursoDto.add(AlumnoCursoDto.builder()
						.id(alumnoCursoEntity.getId())
						.idAlumno(alumnoEntity.getId())
						.nombreAlumno(alumnoEntity.getNombres() + " " + alumnoEntity.getApellidos())
						.estadoAlumno(alumnoEntity.getEstado())
						.idCurso(cursoDto.getId())
						.nombreCurso(cursoDto.getDescripcion())
						.build());
			}
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, listAlumnoCursoDto);
		}catch (RetryableException ex) {
			log.error(Constante.NO_SERVICE_AVIABLE, ex);
			return Util.getResponse(false, Constante.NO_SERVICE_AVIABLE, null);
		} catch (Exception e) {
			log.error(Constante.OPERATION_FAILED, e);
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}

	@Override
	public ResponseDto createAlumnoCurso(AlumnoCursoDto alumnoCursoDto) {
		try {
			AlumnoCursoEntity alumnoCursoEntity = AlumnoCursoEntity.builder()
					.idAlumno(alumnoCursoDto.getIdAlumno())
					.idCurso(alumnoCursoDto.getIdCurso())
					.build();
			alumnoCursoRepository.save(alumnoCursoEntity);
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, null);
		} catch (Exception e) {
			log.error(Constante.OPERATION_FAILED, e);
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}

	@Override
	public ResponseDto updateAlumnoCurso(AlumnoCursoDto alumnoCursoDto) {
		try {
			AlumnoCursoEntity alumnoCursoEntity = alumnoCursoRepository.findById(alumnoCursoDto.getId()).orElse(null);
			if(alumnoCursoEntity == null) {
				return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
			}
			alumnoCursoEntity.setIdAlumno(alumnoCursoDto.getIdAlumno());
			alumnoCursoEntity.setIdCurso(alumnoCursoDto.getIdCurso());
			alumnoCursoRepository.save(alumnoCursoEntity);
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, null);
		} catch (Exception e) {
			log.error(Constante.OPERATION_FAILED, e);
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
