package com.upc.Repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upc.Entities.Tipo_de_fondo;

@Repository
@Transactional
public interface Tipo_de_fondoRepository extends CrudRepository<Tipo_de_fondo, Integer> {

}
