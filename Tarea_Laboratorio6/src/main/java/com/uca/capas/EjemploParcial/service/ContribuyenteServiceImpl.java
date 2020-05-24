package com.uca.capas.EjemploParcial.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.uca.capas.EjemploParcial.dao.ContribuyenteDAO;
import com.uca.capas.EjemploParcial.domain.Contribuyente;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService {
	
	@Autowired
	ContribuyenteDAO contribuyenteDAO;
	
	@Autowired
	ImportanciaService importanciaService;

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		return contribuyenteDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Contribuyente c) throws DataAccessException {
		
		c.setFingreso(new Date());
		c.setImportancia(importanciaService.findOne(c.getCimportancia()));
		contribuyenteDAO.save(c);	
		
	}

}
