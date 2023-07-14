package com.edu.certus.profesor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorCursoDto {
	private Long id;
	private Long idProfesor;
	private String nombreProfesor;
	private Boolean estadoProfesor;
	private Long idCurso;
	private String nombreCurso;
}
