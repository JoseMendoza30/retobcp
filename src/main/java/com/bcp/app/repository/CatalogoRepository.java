package com.bcp.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bcp.app.entity.CambioMoneda;
import com.bcp.app.entity.Catalogo;

@Repository
public interface CatalogoRepository extends CrudRepository<Catalogo, Long> {

}
