package org.serratec.backend.projetojava2.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.backend.projetojava2.Entidades.ProdutoPedido;
import org.serratec.backend.projetojava2.Exception.DataNotFoundException;
import org.serratec.backend.projetojava2.Repositorios.ProdutoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoPedidoService {
	
	@Autowired
	private ProdutoPedidoRepository produtopedidoRepository;
	
	private ProdutoPedido findById(Integer id) throws DataNotFoundException {
		Optional<ProdutoPedido> produtopedido = produtopedidoRepository.findById(id);
		if (produtopedido.isPresent()) {
			return produtopedido.get();
		}
		throw new DataNotFoundException(id);
	}
	
	public ProdutoPedido buscaPorId(Integer id) throws DataNotFoundException {
		return findById(id);
		
	}
	
	public List<ProdutoPedido> buscaTodos() {
		return produtopedidoRepository.findAll(); 
	}
	
	@Transactional
	public ProdutoPedido incluiProdutoPedido(ProdutoPedido produtopedido) {
		return produtopedidoRepository.save(produtopedido);
		
	}
	
	@Transactional
	public ProdutoPedido atualizaProdutoPedido(Integer id, ProdutoPedido produtopedido) throws DataNotFoundException {
		ProdutoPedido produtopedidoBanco = findById(id);
		produtopedidoBanco.setQuantidade(produtopedido.getQuantidade());
		produtopedidoBanco.setValor(produtopedido.getValor());
		produtopedidoBanco.setProduto(produtopedido.getProduto());
		produtopedidoBanco.setPedido(produtopedido.getPedido());
		return produtopedidoRepository.save(produtopedidoBanco);
	}
	
	public void apagaProdutoPedido(Integer id) throws DataNotFoundException {
		ProdutoPedido produtopedido = findById(id);
		produtopedidoRepository.delete(produtopedido);
	}
	

}
