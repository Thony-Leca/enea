/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.certus.alumno.repository;

import com.edu.certus.alumno.entity.AlumnoCarreraEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoCarreraRepository extends JpaRepository<AlumnoCarreraEntity, Long>{
    List<AlumnoCarreraEntity> findByIdAlumno(Long idAlumno);
}
