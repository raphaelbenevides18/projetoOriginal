package br.com.rlb.projetoOriginal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rlb.projetoOriginal.entity.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
