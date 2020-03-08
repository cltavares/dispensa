package com.dispensa.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dispensa.boot.domain.Compra;

@Repository
public class CompraDaoImpl extends AbstractDao<Compra, Long> implements CompraDao {
	
	public List<Compra> findCompraNaoImportada() {
		String jpql = new StringBuilder("select c from Compra c where not exists  ")
				.append("(select e from Estoque e JOIN   ")
				.append("e.itensCompra where c.id=e.itensCompra.compra.id)").toString();
					
		return createQuery(jpql);
	}


}
