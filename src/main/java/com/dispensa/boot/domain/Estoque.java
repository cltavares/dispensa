package com.dispensa.boot.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "ESTOQUE")
public class Estoque extends AbstractEntidy<Long> {
	
	@ManyToOne
	@JoinColumn(name = "id_itens_compra_fk")
	public ItensCompra itensCompra;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name= "data_retirada", nullable = false, columnDefinition = "DATE")
	private LocalDate dataRetirada;
	
	@Column(nullable = false, unique = true)
	private boolean utilizado;

	public ItensCompra getItensCompra() {
		return itensCompra;
	}

	public void setItensCompra(ItensCompra itensCompra) {
		this.itensCompra = itensCompra;
	}

	public LocalDate getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(LocalDate dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public boolean isUtilizado() {
		return utilizado;
	}

	public void setUtilizado(boolean utilizado) {
		this.utilizado = utilizado;
	}
	
	

}
