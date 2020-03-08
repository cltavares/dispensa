package com.dispensa.boot.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name = "ITENS_COMPRA")
public class ItensCompra extends AbstractEntidy<Long> {
	
	
	@Column(nullable = false, unique = true)
	private String produto;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.0000")
	@Column(nullable = false, columnDefinition = "DECIMAL(7,4) DEFAULT 0")
	private BigDecimal quantidade;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name= "vlr_unitario", nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal valorUnitario;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name= "vlr_total", nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal valorTotal;
	
	@NotNull(message = "Escolha o tipo")
	@ManyToOne
	@JoinColumn(name = "id_unidade_medida_fk")
	public UnidadeMedida unidadeMedida;
	
	@ManyToOne
	@JoinColumn(name = "id_compra_fk")
	public Compra compra;

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	

	
}
