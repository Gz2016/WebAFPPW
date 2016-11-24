package com.upc.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upc.Entities.retiro;

@Repository
@Transactional
public interface retiroRepository extends CrudRepository<retiro, Integer>{

//double calcularmontoretiro(retiro r);->Este metodo debe ir en el service

@Query("select r from retiro r where r.cuenta.ccuenta=?1")
List<retiro> findByCCuenta(int idcuenta);

@Query("select r from retiro r where r.solicitudretiro.csolicitud=?1")
retiro findBySolicitudRetiro(int idsolicitud);



}
