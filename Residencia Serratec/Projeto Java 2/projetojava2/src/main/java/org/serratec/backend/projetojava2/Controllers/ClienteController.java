package org.serratec.backend.projetojava2.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.projetojava2.Entidades.Cliente;
import org.serratec.backend.projetojava2.Exception.DataNotFoundException;
import org.serratec.backend.projetojava2.Services.ClienteService;
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
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> buscaTodos(){
		return clienteService.buscaTodos();
	}
	
	@GetMapping("/{id}")
	public Cliente buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
		return clienteService.buscaPorId(id);
	}
	
	@PostMapping
	public Cliente inclui(@Valid @RequestBody Cliente cliente) {
		return clienteService.incluiCliente(cliente);
	}

	@PutMapping("/{id}")
	public Cliente atualiza(@PathVariable Integer id, @Valid @RequestBody Cliente cliente) throws DataNotFoundException {
		return clienteService.atualizaCliente(id, cliente);
	}
	
	@DeleteMapping("/{id}") 
	public  void apaga(@PathVariable Integer id) throws DataNotFoundException {
		clienteService.apagaCliente(id);
	}




}
