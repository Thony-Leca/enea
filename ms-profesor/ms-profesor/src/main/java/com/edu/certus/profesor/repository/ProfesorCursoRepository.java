package com.edu.certus.profesor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.certus.profesor.entity.ProfesorCursoEntity;

@Repository
public interface ProfesorCursoRepository extends JpaRepository<ProfesorCursoEntity, Long>{
	List<ProfesorCursoEntity> findByIdProfesor(Long id);
	List<ProfesorCursoEntity> findByIdCurso(Long id);
}
