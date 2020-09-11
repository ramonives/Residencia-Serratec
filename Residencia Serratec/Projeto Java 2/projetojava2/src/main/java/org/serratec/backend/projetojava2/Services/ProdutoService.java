package org.serratec.backend.projetojava2.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.backend.projetojava2.Entidades.Produto;
import org.serratec.backend.projetojava2.Exception.DataNotFoundException;
import org.serratec.backend.projetojava2.Repositorios.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	private Produto findById(Integer id) throws DataNotFoundException {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			return produto.get();
		}
		throw new DataNotFoundException(id);
	}
	
	public Produto buscaPorId(Integer id) throws DataNotFoundException {
		return findById(id);
	}
	
	public List<Produto> buscaTodos() {
		return produtoRepository.findAll();
	}
	
	@Transactional
	public Produto incluiProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@Transactional
	public Produto atualizaProduto(Integer id, Produto produto) throws DataNotFoundException {
		Produto produtoBanco = findById(id);
		produtoBanco.setNome(produto.getNome());
		produtoBanco.setDescricao(produto.getDescricao());
		produtoBanco.setFabricacao(produto.getFabricacao());
		produtoBanco.setEstoque(produto.getEstoque());
		produtoBanco.setValor(produto.getValor());
		produtoBanco.setCategoria(produto.getCategoria());
		produtoBanco.setFuncionario(produto.getFuncionario());
		return produtoRepository.save(produtoBanco);
		
	}
	
	public void apagaProduto(Integer id) throws DataNotFoundException {
		
		Produto produto = findById(id);
		produtoRepository.delete(produto);
		
	}

}
