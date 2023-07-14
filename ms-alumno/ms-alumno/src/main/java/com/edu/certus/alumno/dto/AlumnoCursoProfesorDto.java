package com.edu.certus.alumno.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoCursoProfesorDto {
	private Long idAlumno;
	private String nombreAlumno;
	private Boolean estadoAlumno;
	private Long idCurso;
	private String nombreCurso;
	private Long idProfesor;
	private String nombreProfesor;

}
