package com.dispensa.boot.web.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dispensa.boot.domain.Estoque;
import com.dispensa.boot.domain.ItensCompra;
import com.dispensa.boot.service.CompraService;
import com.dispensa.boot.service.EstoqueService;
import com.dispensa.boot.service.ItensCompraService;

import net.bytebuddy.asm.Advice.Return;

@Controller
@RequestMapping("/estoques")
public class EstoqueController {
	
	@Autowired
	private EstoqueService estoqueService;
	
	@Autowired
	private CompraService compraService;
	
	@Autowired
	private ItensCompraService itensCompraService;
	
	@GetMapping("/importar")
	public String importar(ModelMap model) {
		model.addAttribute("processamentos", compraService.findCompraNaoImportada());
		
		return "/estoque/importa";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("estoques", estoqueService.buscarEstoqueNaoUtilizado());
		
		return "/estoque/lista";
	}
	
	@GetMapping("/processar/{id}")
	public String processar(@PathVariable("id") Long id, ModelMap model) {
		
		if (id == null) {
			model.addAttribute("fail", "Compra não localizada, favor verifique novamante. ");
		}else {
			List<ItensCompra> buscarTodosItensCompraById = itensCompraService.buscarTodosItensCompraById(id);
			
			if (!buscarTodosItensCompraById.isEmpty()) {
				
				Estoque estoque = null;
				for (ItensCompra itensCompra : buscarTodosItensCompraById) {
					estoque = new Estoque();
					estoque.setItensCompra(itensCompra);
					//KG
					if (new Long("1").equals(
							estoque.getItensCompra().getUnidadeMedida().getId())) {
						
						estoqueService.salvar(estoque);
					}else {
						int i =1;
						while(i <= itensCompra.getQuantidade().intValue() ) {
							estoque = new Estoque();
							estoque.setItensCompra(itensCompra);
							estoqueService.salvar(estoque);
							i++;
						}
					}
				}
				model.addAttribute("success", "Estoque importado  com sucesso!!");
			}
			
		}
		
		return importar(model);
	}
	
	@GetMapping("/baixa/{id}")
	public String baixa(@PathVariable("id") Long id, ModelMap model) {
		
		if (id == null) {
			model.addAttribute("fail", "Compra não localizada, favor verifique novamante. ");
		}else {
			Estoque estoque = estoqueService.buscarPorId(id);
			estoque.setUtilizado(true);
			LocalDateTime agora = LocalDateTime.now();
			estoque.setDataRetirada(agora.toLocalDate());
			estoqueService.editar(estoque);
			
			model.addAttribute("success", "Baixa realizada com sucesso!!");
			
		}
		return listar(model);
	}
	
	@GetMapping("/listarBaixado")
	public String listarBaixado(ModelMap model) {
		model.addAttribute("estoques", estoqueService.buscarEstoqueUtilizado());
		
		return "/estoque/listaBaixado";
	}
	
	@GetMapping("/buscar/produto")
	public String buscarProduto(@RequestParam("produto") String produto, ModelMap model) {
		model.addAttribute("estoques", estoqueService.buscarProduto(produto));
		
		return "/estoque/lista";
	}
	
	@GetMapping("/buscar/data")
	public String buscarData(@RequestParam("inicioCompra") String inicioCompra, @RequestParam("fimCompra") String fimCompra, ModelMap model) {
		model.addAttribute("estoques", estoqueService.buscarData( inicioCompra, fimCompra));
		
		return "/estoque/lista";
	}
	
	
}
