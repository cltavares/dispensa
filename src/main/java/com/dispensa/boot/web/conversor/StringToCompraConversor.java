package com.dispensa.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dispensa.boot.domain.Compra;
import com.dispensa.boot.service.CompraService;



@Component
public class StringToCompraConversor implements Converter<String, Compra> {

	@Autowired
	private CompraService service;
	
	@Override
	public Compra convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
}
