/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.certus.carrera.service;

import com.edu.certus.carrera.dto.CarreraDto;
import com.edu.certus.carrera.dto.ResponseDto;
import com.edu.certus.carrera.entity.CarreraEntity;
import com.edu.certus.carrera.repository.CarreraRepository;
import com.edu.certus.carrera.util.Constantes;
import com.edu.certus.carrera.util.Util;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarreraServiceImp implements CarreraService{
    @Autowired
    private CarreraRepository carreraRepository;

    @Override
    public ResponseDto getAllCarrera() {
     		try {
			List<CarreraEntity> listcarreraEntity = carreraRepository.findAll();
			List<CarreraDto> listCarreraDto = new ArrayList<CarreraDto>();
			for (CarreraEntity carreraEntity : listcarreraEntity) {
				listCarreraDto.add(CarreraDto.builder()
				.id(carreraEntity.getId())
				.nom_carrera(carreraEntity.getNom_carrera())
				.build());
			}
			return Util.getResponse(true, Constantes.OPERATION_SUCCESS, listCarreraDto);
		} catch (Exception e) {
			return Util.getResponse(false, Constantes.OPERATION_FAILED, null);
		}
	}

    @Override
    public ResponseDto getCarrera(Long id) {
      		try {
			CarreraEntity carreraEntity= carreraRepository.findById(id).orElse(null);
			if(null == carreraEntity) {
				return Util.getResponse(true, Constantes.NO_RECORDS_ROUND, null);
			}
			CarreraDto carreraDto = CarreraDto.builder()
				.id(carreraEntity.getId())
				.nom_carrera(carreraEntity.getNom_carrera())
				.build();
			return Util.getResponse(true, Constantes.OPERATION_SUCCESS, carreraDto);
		} catch (Exception e) {
			return Util.getResponse(false, Constantes.OPERATION_FAILED, null);
		}
	}

    @Override
    public ResponseDto createCarrera(CarreraDto carrera) {
		try {
			CarreraEntity carreraEntity = CarreraEntity.builder()
					.nom_carrera(carrera.getNom_carrera())
					.build();
			carreraRepository.save(carreraEntity);
			carrera.setId(carreraEntity.getId());
			return Util.getResponse(true, Constantes.OPERATION_SUCCESS, carrera);
		} catch (Exception e) {
			return Util.getResponse(false, Constantes.OPERATION_FAILED, null);
		}
	}

    @Override
    public ResponseDto updateCarrera(CarreraDto carrera) {
    		try {
			CarreraEntity carreraEntity= carreraRepository.findById(carrera.getId()).orElse(null);
			if(null == carreraEntity) {
				return Util.getResponse(true, Constantes.NO_RECORDS_ROUND, null);
			}
			carreraEntity.setNom_carrera(carrera.getNom_carrera());
			carreraRepository.save(carreraEntity);
			return Util.getResponse(true, Constantes.OPERATION_SUCCESS, carrera);
		} catch (Exception e) {
			return Util.getResponse(false, Constantes.OPERATION_FAILED, null);
		}
	}
    
}
