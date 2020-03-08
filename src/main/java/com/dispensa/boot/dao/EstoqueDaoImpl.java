package com.dispensa.boot.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dispensa.boot.domain.Estoque;
import com.dispensa.boot.domain.ItensCompra;

@Repository
public class EstoqueDaoImpl extends AbstractDao<Estoque, Long> implements EstoqueDao {
	
	@Override
	public List<Estoque> buscarEstoqueNaoUtilizado() {
		// TODO Auto-generated method stub
		return createQuery("select e from Estoque e where e.utilizado = ?1", false);
	}
	
	@Override
	public List<Estoque> buscarEstoqueUtilizado() {
		// TODO Auto-generated method stub
		return createQuery("select e from Estoque e where e.utilizado = ?1", true);
	}
	
	
	@Override
	public List<Estoque> buscarData(String inicioCompra, String fimCompra){
		
		StringBuilder jpql = new StringBuilder("select e from Estoque e  ").append("where 1 = 1 ");
		if (inicioCompra != "" && fimCompra != "")
			jpql.append("and e.itensCompra.compra.dataCompra between ?1 and ?2 ");
		else
			jpql.append("and e.itensCompra.compra.dataCompra = ?1 ");
								
		jpql.append("order by e.id asc").toString();
					
		if (inicioCompra != "" && fimCompra != "")
			return createQuery(jpql.toString(), LocalDate.parse(inicioCompra), LocalDate.parse(fimCompra));
		else 
			if (inicioCompra != "")
				return createQuery(jpql.toString(), LocalDate.parse(inicioCompra));
			else if (fimCompra != "")
				return createQuery(jpql.toString(), LocalDate.parse(fimCompra));
		
		return createQuery(jpql.toString());
			
		
	}

	@Override
	public List<Estoque> buscarProduto(String produto) {
		// TODO Auto-generated method stub
		return createQuery("select e from Estoque e where e.utilizado = false and upper(e.itensCompra.produto) like concat('%',?1,'%') ", produto);
	}
		
}
