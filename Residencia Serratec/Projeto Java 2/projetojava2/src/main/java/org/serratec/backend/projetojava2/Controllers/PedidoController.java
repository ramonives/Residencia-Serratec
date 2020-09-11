package org.serratec.backend.projetojava2.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.projetojava2.Entidades.Pedido;
import org.serratec.backend.projetojava2.Exception.DataNotFoundException;
import org.serratec.backend.projetojava2.Services.PedidoService;
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
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	
	@GetMapping
	public List<Pedido> buscaTodos(){
		return pedidoService.buscaTodos();
	}
	
	@GetMapping("/{id}")
	public Pedido buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
		return pedidoService.buscaPorId(id);
	}
	
	@PostMapping
	public Pedido inclui(@Valid @RequestBody Pedido pedido) {
		return pedidoService.incluiPedido(pedido);
	}
	
	@PutMapping("/{id}")
	public Pedido atualiza(@PathVariable Integer id, @Valid @RequestBody Pedido pedido) throws DataNotFoundException {
		return pedidoService.atualizaPedido(id, pedido);
	}
	
	@DeleteMapping("/{id}") 
	public  void apaga(@PathVariable Integer id) throws DataNotFoundException {
		pedidoService.apagaPedido(id);
	}

}
