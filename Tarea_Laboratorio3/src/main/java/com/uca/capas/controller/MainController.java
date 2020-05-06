package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Product;

@Controller
public class MainController {
	
	private List<Product> productos = new ArrayList<>();
	
	@GetMapping("/comprar")
	public ModelAndView comprarProducto() {
		ModelAndView mav = new ModelAndView();
		productos.add(new Product(0, "Zelda OOT", 10));
		productos.add(new Product(1, "Zelda SS", 30));
		productos.add(new Product(2, "Zelda TP", 20));
		productos.add(new Product(3, "Zelda BOTW", 5));
		productos.add(new Product(4, "Zelda MM", 25));
		
		mav.setViewName("select");
		mav.addObject("product", new Product());
		mav.addObject("producto", productos);

		return mav;
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("product", productos.get(product.getId()).getNombre());
		if(productos.get(product.getId()).getCantidad() >= product.getCantidad() && product.getCantidad() > 0) {
			mav.setViewName("compra");
		}else {
			mav.setViewName("error");
		}
		return mav;
	}

}
