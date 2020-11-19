package br.com.herancaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.herancaapi.entity.Correntista;

@Repository
public interface ICorrentistaRepository extends JpaRepository<Correntista, Long>{

}
