package com.upc.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upc.Entities.Cuenta;

@Repository
@Transactional
public interface CuentaRepository extends CrudRepository<Cuenta, Integer>{
	@Query("select c from Cuenta c where c.cafiliado.cafiliado=?1")
	List<Cuenta> findByCAfiliado(int cafiliado);//CUENTAS DE AFILIADO
	@Query("select c from Cuenta c where c.cafiliado.sueldo between ?1 and ?2")
	List<Cuenta> findBySueldoAfiliado(double s1,double s2); //GENERICO - LAS CUENTAS ENTRE UN RANGO DE SUELDO
	@Query("select c from Cuenta c where c.fondo between ?1 and ?2")
	List<Cuenta> findByFondo(double f1,double f2);

}
