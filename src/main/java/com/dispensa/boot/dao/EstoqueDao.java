package com.dispensa.boot.dao;

import java.util.List;

import com.dispensa.boot.domain.Estoque;

public interface EstoqueDao {
	
	void save(Estoque estoque);

    void update(Estoque estoque);

    Estoque findById(Long id);

    List<Estoque> findAll();
    
    List<Estoque> buscarEstoqueNaoUtilizado();
    
    List<Estoque> buscarEstoqueUtilizado();

	List<Estoque> buscarProduto(String produto);

	List<Estoque> buscarData(String inicioCompra, String fimCompra);

 
    

}
