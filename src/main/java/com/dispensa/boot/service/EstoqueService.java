package com.dispensa.boot.service;

import java.util.List;

import com.dispensa.boot.domain.Estoque;

public interface EstoqueService {
	
    void salvar(Estoque estoque);

    void editar(Estoque estoque);

    Estoque buscarPorId(Long id);
    
    List<Estoque> buscarTodos();

	boolean compraTemItens(Long id);
	
    List<Estoque> buscarEstoqueNaoUtilizado();
    
    List<Estoque> buscarEstoqueUtilizado();

	List<Estoque> buscarProduto(String produto);

	List<Estoque> buscarData(String inicioCompra, String fimCompra);
	
}
