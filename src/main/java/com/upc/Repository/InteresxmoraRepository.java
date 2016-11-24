package com.upc.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upc.Entities.Interesxmora;

@Repository
@Transactional
public interface InteresxmoraRepository extends CrudRepository<Interesxmora, Integer>{
	@Query("select i from Interesxmora i where i.montointeres>?1")
	List<Interesxmora> findByMontointeresGreatherThan(double m);
	
}
