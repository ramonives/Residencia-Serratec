package org.serratec.backend.projetojava2.Repositorios;

import org.serratec.backend.projetojava2.Entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
