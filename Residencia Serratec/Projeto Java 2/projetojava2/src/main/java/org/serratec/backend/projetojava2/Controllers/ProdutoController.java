package org.serratec.backend.projetojava2.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.projetojava2.Entidades.Produto;
import org.serratec.backend.projetojava2.Exception.DataNotFoundException;
import org.serratec.backend.projetojava2.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> buscaTodos(){
		return produtoService.buscaTodos();
	}
	
	@GetMapping("/{id}")
	public Produto buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
		return produtoService.buscaPorId(id);
	}
	
	@PostMapping
	public Produto inclui(@Valid @RequestBody Produto produto) {
		return produtoService.incluiProduto(produto);
	}
	
	@PutMapping("/{id}")
	public Produto atualiza(@PathVariable Integer id, @Valid @RequestBody Produto produto) throws DataNotFoundException {
		return produtoService.atualizaProduto(id, produto);
	}
	
	@DeleteMapping("/{id}") 
	public  void apaga(@PathVariable Integer id) throws DataNotFoundException {
		produtoService.apagaProduto(id);
	}


}
