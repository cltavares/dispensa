package com.dispensa.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dispensa.boot.domain.ItensCompra;

@Repository
public class ItensCompraDaoImpl extends AbstractDao<ItensCompra, Long> implements ItensCompraDao {

	@Override
	public List<ItensCompra> buscarTodosItensCompraById(Long id) {
		// TODO Auto-generated method stub
		return createQuery("select ic from ItensCompra ic where ic.compra.id = ?1", id);
	}

/*
	@Override
	public List<ItensCompra> buscarTodosItensCompraById(Long id) {
		
		return createQuery("select f from Funcionario f where f.cargo.id = ?1", id);
	}
	
*/



}
