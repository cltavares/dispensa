package com.dispensa.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "FORMA_PAGAMENTO")
public class FormaPagamento extends AbstractEntidy<Long> {
	
	@Column(nullable = false, unique = true)
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	

}
