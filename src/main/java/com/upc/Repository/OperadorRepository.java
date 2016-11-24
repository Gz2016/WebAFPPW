package com.upc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.upc.Entities.Operador;

@Repository
@Transactional
public interface OperadorRepository extends CrudRepository<Operador, Integer> {
	
	@Query("select o from Operador o where o.nnombres=?1 ")
	List<Operador> findByNnombresAsc(String Nnombres);
	
	@Query("select o from Operador o where o.napellidos=?1 ")
	List<Operador> findByNapellidosAsc(String Napellidos);
	
	@Query("select o from Operador o where o.dni=?1 ")
	List<Operador> finByDni(int Dni);

}
