/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.certus.alumno.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoCarreraDto {
    	private Long id;
	private Long idAlumno;
        private String nombreAlumno;
	private Boolean estadoAlumno;
	private Long idCarrera;
        private String nom_carrera;
}
