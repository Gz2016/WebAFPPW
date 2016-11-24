package com.upc.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upc.Entities.Aporte;

@Repository
@Transactional
public interface AporteRepository extends CrudRepository<Aporte, Integer>{
	@Query("select a from Aporte a where a.daporte between ?1 and ?2")
	List<Aporte> findByFechaPago(String f1, String f2); //GENERICO
	
	@Query("select a from Aporte a where a.ccuenta.ccuenta=?1 and a.daporte between ?2 and ?3")
	List<Aporte> findByCcuentaAndFechaPago(int ccuenta, String f1, String f2); //PARA CADA CUENTA DEL AFILIADO
	@Query("select a from Aporte a where a.ccuenta.ccuenta=?1")
	List<Aporte> findByIdcuenta(int Ccuenta); //PARA CADA CUENTA DEL AFILIADO
	
	@Query("select a from Aporte a where a.montoaporte between ?1 and ?2")//GENERICO
	List<Aporte> findByMontoaporte(double m1, double m2); //GENERICO
	@Query("select a from Aporte a join a.ccuenta c where c.ccuenta.cafiliado.dni=?1")
	List<Aporte> findByDniAfiliado(int dni);
	
}
