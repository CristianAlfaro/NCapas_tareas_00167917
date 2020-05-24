package com.uca.capas.EjemploParcial.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.EjemploParcial.domain.Contribuyente;
import com.uca.capas.EjemploParcial.domain.Importancia;
import com.uca.capas.EjemploParcial.service.ContribuyenteService;
import com.uca.capas.EjemploParcial.service.ImportanciaService;


@Controller
public class MainController {
	
	@Autowired
	ContribuyenteService contribuyenteService;
	
	@Autowired
	ImportanciaService importanciaService;
	
	@RequestMapping("/")
	public ModelAndView index() {
		
		ModelAndView mav = new ModelAndView();
		List<Importancia> importancias = importanciaService.findAll();
		Contribuyente contribuyente = new Contribuyente();
		
		mav.addObject("contribuyente", contribuyente);
		mav.addObject("importancias", importancias);
		mav.setViewName("index");
		
		return mav;
		
	}
	
	@RequestMapping("/guardarCont")
	public ModelAndView guardarCont(@ModelAttribute Contribuyente c) {
		
		contribuyenteService.save(c);
		
		ModelAndView mav = new ModelAndView();

		mav.setViewName("exito");
		
		return mav;
		
	}
	
	@RequestMapping("/contribuyentes")
	public ModelAndView conts() {
		
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = contribuyenteService.findAll();
		
		mav.addObject("contribuyentes", contribuyentes);
		mav.setViewName("contribuyentes");
		
		return mav;
		
	}

}
