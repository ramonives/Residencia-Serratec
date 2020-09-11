package org.serratec.backend.projetojava2.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.backend.projetojava2.Entidades.Cliente;
import org.serratec.backend.projetojava2.Exception.DataNotFoundException;
import org.serratec.backend.projetojava2.Repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private Cliente findById(Integer id) throws DataNotFoundException {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return cliente.get();
		}
		throw new DataNotFoundException(id);
	}
	
	public Cliente buscaPorId(Integer id) throws DataNotFoundException {
		return findById(id);
	}
	
	public List<Cliente> buscaTodos() {
		return clienteRepository.findAll();
	}
	
	@Transactional
	public Cliente incluiCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public Cliente atualizaCliente(Integer id, Cliente cliente) throws DataNotFoundException {
		Cliente clienteBanco = findById(id);
		clienteBanco.setNome(cliente.getNome());
		clienteBanco.setEndereco(cliente.getEndereco());
		clienteBanco.setTelefone(cliente.getTelefone());
		clienteBanco.setUsuario(cliente.getUsuario());
		clienteBanco.setEmail(cliente.getEmail());
		clienteBanco.setCpf(cliente.getCpf());
		clienteBanco.setNascimento(cliente.getNascimento());
		return clienteRepository.save(clienteBanco);
	}
	
	public void apagaCliente(Integer id) throws DataNotFoundException {
		
		Cliente cliente = findById(id);
		clienteRepository.delete(cliente);
		
	}




}
