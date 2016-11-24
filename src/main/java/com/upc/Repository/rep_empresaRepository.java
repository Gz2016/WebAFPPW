package com.upc.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.upc.Entities.rep_empresa;


@Repository
@Transactional
public interface rep_empresaRepository extends CrudRepository<rep_empresa, Integer>
{
	//metodos adicionales
}
