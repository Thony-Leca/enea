/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.certus.alumno.service.impl;

import com.edu.certus.alumno.client.CarreraClient;
import com.edu.certus.alumno.dto.AlumnoCarreraDto;
import com.edu.certus.alumno.dto.CarreraDto;
import com.edu.certus.alumno.dto.ResponseDto;
import com.edu.certus.alumno.entity.AlumnoCarreraEntity;
import com.edu.certus.alumno.entity.AlumnoEntity;
import com.edu.certus.alumno.repository.AlumnoRepository;
import com.edu.certus.alumno.repository.AlumnoCarreraRepository;
import com.edu.certus.alumno.service.AlumnoCarreraService;
import com.edu.certus.alumno.util.Constante;
import com.edu.certus.alumno.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.RetryableException;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AlumnoCarreraServiceImpl implements AlumnoCarreraService {
    	@Autowired
	private AlumnoCarreraRepository alumnoCarreraRepository;
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private CarreraClient carreraClient;
        
	@Override
	public ResponseDto getAllAlumnoCarrera() {
		          ObjectMapper mapper = new ObjectMapper();
		try {
			List<AlumnoCarreraEntity> listAlumnoCarreraEntity = alumnoCarreraRepository.findAll();
			List<AlumnoCarreraDto> listAlumnoCarrera = new ArrayList<AlumnoCarreraDto>();
			
			for (int i = 0; i < listAlumnoCarreraEntity.size(); i++) {
				
				                        AlumnoEntity alumnoEntity = alumnoRepository.findById(listAlumnoCarreraEntity.get(i).getIdAlumno()).orElse(null);
				ResponseDto responseDto = carreraClient.readCarrera(listAlumnoCarreraEntity.get(i).getIdCarrera());
				                        CarreraDto carreraDto = mapper.convertValue(responseDto.getData(), CarreraDto.class);
				
				listAlumnoCarrera.add(AlumnoCarreraDto.builder()
						.id(listAlumnoCarreraEntity.get(i).getId())
						.idAlumno(alumnoEntity.getId())
						.nombreAlumno(alumnoEntity.getNombres() + " " + alumnoEntity.getApellidos())
						.estadoAlumno(alumnoEntity.getEstado())
						.idCarrera(carreraDto.getId())
						.nom_carrera(carreraDto.getNom_carrera())
						.build());
			}
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, listAlumnoCarrera);
		}catch (RetryableException ex) {
			log.error(Constante.NO_SERVICE_AVIABLE, ex);
			return Util.getResponse(false, Constante.NO_SERVICE_AVIABLE, null);
		} catch (Exception e) {
			log.error(Constante.OPERATION_FAILED, e);
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}

	@Override
	public ResponseDto getAlumnoCarrera(Long idAlumno) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<AlumnoCarreraEntity> listAlumnoCarreraEntity = alumnoCarreraRepository.findByIdAlumno(idAlumno);
			if(listAlumnoCarreraEntity == null) {
				return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
			}
			List<AlumnoCarreraDto> listAlumnoCarreraDto = new ArrayList<AlumnoCarreraDto>();
			for (AlumnoCarreraEntity alumnoCursoEntity : listAlumnoCarreraEntity) {
				
				AlumnoEntity alumnoEntity = alumnoRepository.findById(alumnoCursoEntity.getIdAlumno()).orElse(null);
				ResponseDto responseDto = carreraClient.readCarrera(alumnoCursoEntity.getIdCarrera());
				CarreraDto carreraDto = mapper.convertValue(responseDto.getData(), CarreraDto.class);
				
				listAlumnoCarreraDto.add(AlumnoCarreraDto.builder()
						.id(alumnoCursoEntity.getId())
						.idAlumno(alumnoEntity.getId())
						.nombreAlumno(alumnoEntity.getNombres() + " " + alumnoEntity.getApellidos())
						.estadoAlumno(alumnoEntity.getEstado())
						.idCarrera(carreraDto.getId())
						.nom_carrera(carreraDto.getNom_carrera())
						.build());
			}
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, listAlumnoCarreraDto);
		}catch (RetryableException ex) {
			log.error(Constante.NO_SERVICE_AVIABLE, ex);
			return Util.getResponse(false, Constante.NO_SERVICE_AVIABLE, null);
		} catch (Exception e) {
			log.error(Constante.OPERATION_FAILED, e);
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}

	@Override
	public ResponseDto createAlumnoCarrera(AlumnoCarreraDto alumnoCarreraDto) {
		try {
			AlumnoCarreraEntity alumnoCursoEntity = AlumnoCarreraEntity.builder()
					.idAlumno(alumnoCarreraDto.getIdAlumno())
					.idCarrera(alumnoCarreraDto.getIdCarrera())
					.build();
			alumnoCarreraRepository.save(alumnoCursoEntity);
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, null);
		} catch (Exception e) {
			log.error(Constante.OPERATION_FAILED, e);
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}

	@Override
	public ResponseDto updateAlumnoCarrera(AlumnoCarreraDto alumnoCarreraDto) {
		try {
			AlumnoCarreraEntity alumnoCursoEntity = alumnoCarreraRepository.findById(alumnoCarreraDto.getId()).orElse(null);
			if(alumnoCursoEntity == null) {
				return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
			}
			alumnoCursoEntity.setIdAlumno(alumnoCarreraDto.getIdAlumno());
			alumnoCursoEntity.setIdCarrera(alumnoCarreraDto.getIdCarrera());
			alumnoCarreraRepository.save(alumnoCursoEntity);
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, null);
		} catch (Exception e) {
			log.error(Constante.OPERATION_FAILED, e);
			return Util.getResponse(false, Constante.OPERATION_FAILED, null); 
		}
	}}
