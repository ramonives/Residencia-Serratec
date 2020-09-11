package org.serratec.backend.projetojava2.Repositorios;

import org.serratec.backend.projetojava2.Entidades.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

}
