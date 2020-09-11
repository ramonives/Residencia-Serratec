package org.serratec.backend.projetojava2.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.projetojava2.Entidades.ProdutoPedido;
import org.serratec.backend.projetojava2.Exception.DataNotFoundException;
import org.serratec.backend.projetojava2.Services.ProdutoPedidoService;
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
@RequestMapping("/produto-pedido")
public class ProdutoPedidoController {
	
	@Autowired
	ProdutoPedidoService produtopedidoService;
	
	@GetMapping
	public List<ProdutoPedido> buscaTodos(){
		return produtopedidoService.buscaTodos();
	}
	
	@GetMapping("/{id}")
	public ProdutoPedido buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
		return produtopedidoService.buscaPorId(id);
	}
	
	@PostMapping
	public ProdutoPedido inclui(@Valid @RequestBody ProdutoPedido produtopedido) {
		return produtopedidoService.incluiProdutoPedido(produtopedido);
	}
	
	@PutMapping("/{id}")
	public ProdutoPedido atualiza(@PathVariable Integer id, @Valid @RequestBody ProdutoPedido produtopedido) throws DataNotFoundException {
		return produtopedidoService.atualizaProdutoPedido(id, produtopedido);
	}
	
	@DeleteMapping("/{id}") 
	public  void apaga(@PathVariable Integer id) throws DataNotFoundException {
		produtopedidoService.apagaProdutoPedido(id);
	}

}
