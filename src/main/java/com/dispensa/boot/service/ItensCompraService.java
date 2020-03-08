package com.dispensa.boot.service;

import java.util.List;

import com.dispensa.boot.domain.ItensCompra;

public interface ItensCompraService {
	
    void salvar(ItensCompra itensCompra);

    void editar(ItensCompra itensCompra);

    ItensCompra buscarPorId(Long id);
    
    List<ItensCompra> buscarTodos();

	boolean compraTemItens(Long id);
	
	List<ItensCompra> buscarTodosItensCompraById(Long id);
	
	

}
