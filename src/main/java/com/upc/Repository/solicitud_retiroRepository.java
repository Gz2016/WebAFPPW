package com.upc.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.upc.Entities.solicitud_retiro;

@Repository
@Transactional
public interface solicitud_retiroRepository extends CrudRepository<solicitud_retiro,Integer> {
	
	@Query("select sr from solicitud_retiro sr where sr.operador.coperador= ?1")
	List<solicitud_retiro> findsolicitudByIdOperador(int idoperador);
	
@Query("select sr from solicitud_retiro sr where sr.afiliado.cafiliado= :idafiliado")
List<solicitud_retiro> findsolicitudByIdAfiliado(@Param("idafiliado") int idafiliado);

@Query("select sr from solicitud_retiro sr where sr.nestado= ?1")
List<solicitud_retiro> findsolicitudByEstado(String estado);

@Query("select sr from solicitud_retiro sr where sr.nestado= 'En Espera' ")
List<solicitud_retiro> findsolicitudByEstadoEnEspera();
}
