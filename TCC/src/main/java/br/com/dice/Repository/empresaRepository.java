package br.com.dice.Repository;

import br.com.dice.Entity.cadastroEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface empresaRepository extends JpaRepository <cadastroEmpresa, Long> {



}
