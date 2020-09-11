package org.serratec.backend.projetojava2.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.projetojava2.Entidades.Categoria;
import org.serratec.backend.projetojava2.Exception.DataNotFoundException;
import org.serratec.backend.projetojava2.Services.CategoriaService;
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
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> buscaTodos(){
		return categoriaService.buscaTodos();
	}
	
	@GetMapping("/{id}")
	public Categoria buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
		return categoriaService.buscaPorId(id);
	}
	
	@PostMapping
	public Categoria inclui(@Valid @RequestBody Categoria categoria) {
		return categoriaService.incluiCategoria(categoria);
	}

	@PutMapping("/{id}")
	public Categoria atualiza(@PathVariable Integer id, @Valid @RequestBody Categoria categoria) throws DataNotFoundException {
		return categoriaService.atualizaCategoria(id, categoria);
	}
	
	@DeleteMapping("/{id}") 
	public  void apaga(@PathVariable Integer id) throws DataNotFoundException {
		categoriaService.apagaCategoria(id);
	}

}
