package org.serratec.backend.projetojava2.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.projetojava2.Entidades.Funcionario;
import org.serratec.backend.projetojava2.Exception.DataNotFoundException;
import org.serratec.backend.projetojava2.Services.FuncionarioService;
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
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	FuncionarioService funcionarioService;
	
	@GetMapping
	public List<Funcionario> buscaTodos(){
		return funcionarioService.buscaTodos();
	}
	
	@GetMapping("/{id}")
	public Funcionario buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
		return funcionarioService.buscaPorId(id);
	}
	
	@PostMapping
	public Funcionario inclui(@Valid @RequestBody Funcionario funcionario) {
		return funcionarioService.incluiFuncionario(funcionario);
	}

	@PutMapping("/{id}")
	public Funcionario atualiza(@PathVariable Integer id, @Valid @RequestBody Funcionario funcionario) throws DataNotFoundException {
		return funcionarioService.atualizaFuncionario(id, funcionario);
	}
	
	@DeleteMapping("/{id}") 
	public  void apaga(@PathVariable Integer id) throws DataNotFoundException {
		funcionarioService.apagaFuncionario(id);
	}
	

}
