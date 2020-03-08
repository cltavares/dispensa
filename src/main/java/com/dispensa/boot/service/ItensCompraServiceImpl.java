package com.dispensa.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dispensa.boot.dao.CompraDao;
import com.dispensa.boot.dao.ItensCompraDao;
import com.dispensa.boot.domain.ItensCompra;

@Service
public class ItensCompraServiceImpl implements ItensCompraService {
	
	@Autowired
	private ItensCompraDao dao;
	
	private CompraDao daoC;

	@Transactional(readOnly = false)
	public void salvar(ItensCompra itensCompra) {
		dao.save(itensCompra);		
	}

	@Transactional(readOnly = false)
	public void editar(ItensCompra itensCompra) {
		dao.update(itensCompra);		
	}


	@Transactional(readOnly = true)
	public ItensCompra buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	public List<ItensCompra> buscarTodos() {
		
		return dao.findAll();
	}


	@Transactional(readOnly = true)
	public List<ItensCompra> buscarTodosItensCompraById(Long id){
		return dao.buscarTodosItensCompraById(id);
		
	}

	@Override
	public boolean compraTemItens(Long id) {
		// TODO Auto-generated method stub
		return false;
	}


	
	
	



}
