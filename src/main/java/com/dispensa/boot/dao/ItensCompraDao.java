package com.dispensa.boot.dao;

import java.util.List;

import com.dispensa.boot.domain.Estoque;
import com.dispensa.boot.domain.ItensCompra;

public interface ItensCompraDao {
	

	
	void save(ItensCompra itensCompra);

    void update(ItensCompra itensCompra);

    ItensCompra findById(Long id);

    List<ItensCompra> findAll();

	List<ItensCompra> buscarTodosItensCompraById(Long id);
    
    

}
