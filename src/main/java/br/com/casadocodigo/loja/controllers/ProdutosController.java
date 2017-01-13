package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.enums.TipoPreco;
import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.validators.ProdutoValidator;

@Controller
public class ProdutosController {
	
	@Autowired
	ProdutoDAO dao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new ProdutoValidator());
	}
	
	@RequestMapping("/produtos/form")
	public ModelAndView form(){
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());		
		return modelAndView;
	}
	
	@RequestMapping(value="/produtos", method=RequestMethod.POST)
	public ModelAndView grava(Produto produto, BindingResult result, RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			form();
		}
		dao.gravar(produto);
		redirectAttributes.addFlashAttribute("sucesso", "produto cadastrado com sucesso!");
		return new ModelAndView("redirect:produtos");
	}

	
	@RequestMapping(value="/produtos", method=RequestMethod.GET)
	public ModelAndView listar(){
		List<Produto> produtos = dao.listar();
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("produtos", produtos);
		return modelAndView; 
	}
	
}
