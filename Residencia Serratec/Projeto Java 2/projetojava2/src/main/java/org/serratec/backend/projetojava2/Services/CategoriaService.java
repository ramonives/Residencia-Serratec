package org.serratec.backend.projetojava2.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.backend.projetojava2.Entidades.Categoria;
import org.serratec.backend.projetojava2.Exception.DataNotFoundException;
import org.serratec.backend.projetojava2.Repositorios.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	private Categoria findById(Integer id) throws DataNotFoundException {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if ( categoria.isPresent()) {
			return  categoria.get();
		}
		throw new DataNotFoundException(id);
	}
	
	public Categoria buscaPorId(Integer id) throws DataNotFoundException {
		return findById(id);
	}
	
	public List<Categoria> buscaTodos() {
		return categoriaRepository.findAll();
	}
	
	@Transactional
	public Categoria incluiCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	@Transactional
	public Categoria atualizaCategoria(Integer id, Categoria categoria) throws DataNotFoundException {
		Categoria categoriaBanco = findById(id);
		categoriaBanco.setNome(categoria.getNome());
		return categoriaRepository.save(categoriaBanco);
	}
	
	public void apagaCategoria(Integer id) throws DataNotFoundException {
		Categoria categoria = findById(id);
		categoriaRepository.delete(categoria);
	}

	

}
