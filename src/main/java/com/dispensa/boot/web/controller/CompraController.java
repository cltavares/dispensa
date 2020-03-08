package com.dispensa.boot.web.controller;

import java.io.File;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dispensa.boot.domain.Compra;
import com.dispensa.boot.service.CompraService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/compras")
public class CompraController {
	
	@Autowired
	private CompraService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Compra compra) {
		
		return "/compra/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("compras", service.buscarTodos());
		
		return "/compra/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Compra compra, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors())
			return "/compra/cadastro";
		
		service.salvar(compra);
		attr.addFlashAttribute("success", "Compra inserido com sucesso!!");
		return "redirect:/compras/cadastrar";
		
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("compra", service.buscarPorId(id));		
		return "/compra/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Compra compra, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors())
			return "/compra/cadastro";
		
		service.editar(compra);
		attr.addFlashAttribute("success", "Compra editada com sucesso!!");
		return "redirect:/compras/cadastrar";
		
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		
		if (service.compraTemItens(id)) {
			model.addAttribute("fail", "Compra não removida, possui item(ns) vinculado(s)");
		}else {
			service.excluir(id);
			model.addAttribute("success", "Compra removida com sucesso!!");
		}
		
		return listar(model);
	}
	
	@GetMapping("/imprimir")
	 public String imprimir() {

	        List<Compra> relatorios = service.buscarTodos();
	        String path = "../";

	        try {
	        	
	        	JasperReport report = JasperCompileManager.compileReport(new File("").getAbsolutePath()+"/src/main/resources/templates/compra/relatorio/relListaCompras.jrxml");
	        	
	            //JasperReport report = JasperCompileManager.compileReport(path+"relatorio/relListaCompras.jasper");
	            JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(relatorios));            
	            JasperExportManager.exportReportToPdfFile(print, "relListaCompras.pdf");
	        } catch (JRException e) {
	            e.printStackTrace();
	        }

	        System.out.println("Relatório gerado.");
	        
	        return "/compra/lista";
	 }

}
