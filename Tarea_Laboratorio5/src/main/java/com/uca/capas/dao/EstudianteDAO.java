package com.uca.capas.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.capas.domain.Estudiante;

public interface EstudianteDAO {
	
	//Metodo para mostrar todos los estudiantes
	public List<Estudiante> findAll() throws DataAccessException;
	
	//Metodo para guardar un nuevo estudiante
	public void insert(Estudiante estudiante) throws DataAccessException;

}