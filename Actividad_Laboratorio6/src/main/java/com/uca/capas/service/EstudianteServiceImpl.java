package com.uca.capas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService {
	
	@Autowired
	private EstudianteDAO estudianteDAO;

	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		
		return estudianteDAO.findAll();
		
	}

	@Override
	@Transactional
	public void insert(Estudiante estudiante) throws DataAccessException {

		estudianteDAO.insert(estudiante);
		
	}

	@Override
	@Transactional
	public void delete(Integer codigo) throws DataAccessException {

		estudianteDAO.delete(codigo);
		
	}

}
