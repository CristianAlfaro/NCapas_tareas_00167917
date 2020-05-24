package com.uca.capas.EjemploParcial.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.uca.capas.EjemploParcial.domain.Contribuyente;

public interface ContribuyenteService {
	
	public List<Contribuyente> findAll() throws DataAccessException;
	
	public void save(Contribuyente c) throws DataAccessException;

}
