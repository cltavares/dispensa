package com.dispensa.boot.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dispensa.boot.dao.CompraDao;
import com.dispensa.boot.dao.EstoqueDao;
import com.dispensa.boot.domain.Estoque;

@Service
public class EstoqueServiceImpl implements EstoqueService {
	
	@Autowired
	private EstoqueDao dao;
	
	private CompraDao daoC;

	@Transactional(readOnly = false)
	public void salvar(Estoque estoque) {
		dao.save(estoque);		
	}

	@Transactional(readOnly = false)
	public void editar(Estoque estoque) {
		dao.update(estoque);		
	}


	@Transactional(readOnly = true)
	public Estoque buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	public List<Estoque> buscarTodos() {
		
		return dao.findAll();
	}

	@Override
	public boolean compraTemItens(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Transactional(readOnly = true)
	public List<Estoque> buscarEstoqueNaoUtilizado() {
		
		return dao.buscarEstoqueNaoUtilizado();
	}
	
	@Transactional(readOnly = true)
	public List<Estoque> buscarEstoqueUtilizado() {
		
		return dao.buscarEstoqueUtilizado();
	}
	
	@Transactional(readOnly = true)
	public List<Estoque> buscarProduto(String produto) {
		
		return dao.buscarProduto(produto);
	}
	
	@Transactional(readOnly = true)
	public List<Estoque> buscarData(String inicioCompra, String fimCompra) {
		
		return dao.buscarData(inicioCompra, fimCompra);
	}
	
	
	
  
}
