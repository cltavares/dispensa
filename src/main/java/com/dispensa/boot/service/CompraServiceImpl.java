package com.dispensa.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dispensa.boot.dao.CompraDao;
import com.dispensa.boot.domain.Compra;

@Service
public class CompraServiceImpl implements CompraService {
	
	@Autowired
	private CompraDao dao;

	@Transactional(readOnly = false)
	public void salvar(Compra compra) {
		dao.save(compra);		
	}

	@Transactional(readOnly = false)
	public void editar(Compra compra) {
		dao.update(compra);		
	}

	@Transactional(readOnly = false)
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Transactional(readOnly = true)
	public Compra buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	public List<Compra> buscarTodos() {
		
		return dao.findAll();
	}

	@Override
	public boolean compraTemItens(Long id) {
		if (buscarPorId(id).getItensCompras().isEmpty()) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<Compra> findCompraNaoImportada() {
		// TODO Auto-generated method stub
		return dao.findCompraNaoImportada();
	}

}
