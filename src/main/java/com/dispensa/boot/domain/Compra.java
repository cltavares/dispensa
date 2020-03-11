package com.dispensa.boot.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name = "COMPRA")
public class Compra extends AbstractEntidy<Long> {
	
	@NotBlank//(message = "Informe o Local da Compra")
	@Size(min = 3, max = 10)/// , message = "O Local da Compra deve ter entre {min} e {max} caracteres.")
	@Column(name= "local_compra", nullable = false, unique = true)
	private String localCompra;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name= "valor_compra", nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal valorCompra;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name= "data_compra", nullable = false, columnDefinition = "DATE")
	private LocalDate dataCompra;
	
	@ManyToOne
	@JoinColumn(name = "id_forma_pagamento_fk")
	public FormaPagamento formaPagamento;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name= "valor_tributo", nullable = true, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal valorTributo;
	

	@OneToMany(mappedBy= "compra")
	private List<ItensCompra> itensCompras;

	public String getLocalCompra() {
		return localCompra;
	}

	public void setLocalCompra(String localCompra) {
		this.localCompra = localCompra;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public List<ItensCompra> getItensCompras() {
		return itensCompras;
	}

	public void setItensCompras(List<ItensCompra> itensCompras) {
		this.itensCompras = itensCompras;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public BigDecimal getValorTributo() {
		return valorTributo;
	}

	public void setValorTributo(BigDecimal valorTributo) {
		this.valorTributo = valorTributo;
	}
	
	
	
	
	

}
