package com.dispensa.boot.service;

import java.util.List;

import com.dispensa.boot.domain.Compra;

public interface CompraService {
	
    void salvar(Compra compra);

    void editar(Compra compra);

    void excluir(Long id);

    Compra buscarPorId(Long id);
    
    List<Compra> buscarTodos();

	boolean compraTemItens(Long id);
	
	List<Compra> findCompraNaoImportada();

}
