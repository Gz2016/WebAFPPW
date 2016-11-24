package com.upc.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upc.Entities.Periododeaporte;

@Repository
@Transactional
public interface PeriododeaporteRepository extends CrudRepository<Periododeaporte, Integer>{
	@Query("select p from Periododeaporte p where p.cafiliado.cafiliado=?1")
	List<Periododeaporte> findByCAfiliado(int cafiliado);//PARA CADA AFILIADO
	
	List<Periododeaporte> findByFpago(String fpago);//GENERICO
	@Query("select p from Periododeaporte p where p.cafiliado.cafiliado=?1 and p.fpago=?2")
	List<Periododeaporte> findByFpagoandCAfiliado(int cafiliado, String fpago);//PARA CADA AFILIADO
}
