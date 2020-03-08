package com.dispensa.boot.dao;

import java.util.List;

import com.dispensa.boot.domain.Compra;

public interface CompraDao {
	
	void save(Compra compra);

    void update(Compra compra);

    void delete(Long id);

    Compra findById(Long id);

    List<Compra> findAll();
    
    List<Compra> findCompraNaoImportada();

}
