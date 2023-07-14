package com.edu.certus.profesor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.certus.profesor.dto.ProfesorDto;
import com.edu.certus.profesor.dto.ResponseDto;
import com.edu.certus.profesor.entity.ProfesorEntity;
import com.edu.certus.profesor.repository.ProfesorRepository;
import com.edu.certus.profesor.service.ProfesorService;
import com.edu.certus.profesor.util.Constante;
import com.edu.certus.profesor.util.Util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProfesorServiceImpl implements ProfesorService{

	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Override
	public ResponseDto getAllProfesor() {
		try {
			List<ProfesorEntity> listProfesorEntity = profesorRepository.findAll();
			if(listProfesorEntity.isEmpty()) {
				return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
			}
			List<ProfesorDto> list = new ArrayList<ProfesorDto>();
			for (ProfesorEntity profesorEntity : listProfesorEntity) {
				list.add(ProfesorDto.builder()
						.id(profesorEntity.getId())
						.nombres(profesorEntity.getNombres())
						.apellidos(profesorEntity.getApellidos())
						.sexo(profesorEntity.getSexo())
						.estado(profesorEntity.getEstado())
						.build());
			}
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, list);
		} catch (Exception e) {
			log.error(Constante.OPERATION_FAILED, e);
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}

	@Override
	public ResponseDto getProfesor(Long id) {
		try {
			ProfesorEntity profesorEntity = profesorRepository.findById(id).orElse(null);
			if(null == profesorEntity) {
				return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
			}
			ProfesorDto profesorDto = ProfesorDto.builder()
					.id(profesorEntity.getId())
					.nombres(profesorEntity.getNombres())
					.apellidos(profesorEntity.getApellidos())
					.sexo(profesorEntity.getSexo())
					.estado(profesorEntity.getEstado())
					.build();
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, profesorDto);
		} catch (Exception e) {
			log.error(Constante.OPERATION_FAILED, e);
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}

	@Override
	public ResponseDto createProfesor(ProfesorDto profesor) {
		try {
			ProfesorEntity profesorEntity = ProfesorEntity.builder()
					.nombres(profesor.getNombres())
					.apellidos(profesor.getApellidos())
					.sexo(profesor.getSexo())
					.estado(true)
					.build();
			profesorRepository.save(profesorEntity);
			profesor.setId(profesorEntity.getId());
			return Util.getResponse(true, Constante.CREATION_SUCCESS, profesor);
		} catch (Exception e) {
			log.error(Constante.OPERATION_FAILED, e);
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}

	@Override
	public ResponseDto updateProfesor(ProfesorDto profesor) {
		try {
			ProfesorEntity profesorEntity = profesorRepository.findById(profesor.getId()).orElse(null);
			if(null == profesorEntity) {
				return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
			}
			profesorEntity.setNombres(profesor.getNombres());
			profesorEntity.setApellidos(profesor.getApellidos());
			profesorEntity.setSexo(profesor.getSexo());
			profesorRepository.save(profesorEntity);
			return Util.getResponse(true, Constante.UPDATE_SUCCESS, profesor);
		} catch (Exception e) {
			log.error(Constante.OPERATION_FAILED, e);
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}

	@Override
	public ResponseDto deleteProfesor(Long id) {
		try {
			ProfesorEntity profesorEntity = profesorRepository.findById(id).orElse(null);
			profesorEntity.setEstado(false);
			profesorRepository.save(profesorEntity);
			return Util.getResponse(true, Constante.OPERATION_SUCCESS, null);
		} catch (Exception e) {
			log.error(Constante.OPERATION_FAILED, e);
			return Util.getResponse(false, Constante.OPERATION_FAILED, null);
		}
	}

}
