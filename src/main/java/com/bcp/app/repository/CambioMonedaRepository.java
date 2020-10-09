package com.bcp.app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bcp.app.entity.CambioMoneda;


@Repository
public interface CambioMonedaRepository extends CrudRepository<CambioMoneda, Long> {

	@Query(" SELECT cambio FROM CambioMoneda  cambio WHERE cambio.codigoCambio = ?1 and cambio.codigoMoneda = ?2 ")
	 List<CambioMoneda> consultaCambioMoneda(String codigoCambio,String codigoMoneda);
	
}
