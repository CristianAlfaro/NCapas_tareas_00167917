package com.uca.capas.EjemploParcial.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.capas.EjemploParcial.domain.Importancia;

public interface ImportanciaService {
	
	public List<Importancia> findAll() throws DataAccessException;
	
	public Importancia findOne(Integer cimportancia) throws DataAccessException;

}
