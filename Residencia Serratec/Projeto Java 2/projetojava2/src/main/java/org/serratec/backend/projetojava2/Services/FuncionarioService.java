package org.serratec.backend.projetojava2.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.backend.projetojava2.Entidades.Funcionario;
import org.serratec.backend.projetojava2.Exception.DataNotFoundException;
import org.serratec.backend.projetojava2.Repositorios.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	private Funcionario findById(Integer id) throws DataNotFoundException {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		if (funcionario.isPresent()) {
			return funcionario.get();
		}
		throw new DataNotFoundException(id);
	}
	
	public Funcionario buscaPorId(Integer id) throws DataNotFoundException {
		return findById(id);
	}
	
	public List<Funcionario> buscaTodos() {
		return funcionarioRepository.findAll();
	}
	
	@Transactional
	public Funcionario incluiFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	@Transactional
	public Funcionario atualizaFuncionario(Integer id, Funcionario funcionario) throws DataNotFoundException {
		Funcionario funcionarioBanco = findById(id);
		funcionarioBanco.setNome(funcionario.getNome());
		funcionarioBanco.setCpf(funcionario.getCpf());
		return funcionarioRepository.save(funcionarioBanco);
	}
	
	public void apagaFuncionario(Integer id) throws DataNotFoundException {
		Funcionario funcionario = findById(id);
		funcionarioRepository.delete(funcionario);
	}




}
