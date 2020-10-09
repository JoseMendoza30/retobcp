package com.bcp.app.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.app.dto.RequestCambio;
import com.bcp.app.dto.ResponseCambio;
import com.bcp.app.entity.CambioMoneda;
import com.bcp.app.entity.Catalogo;
import com.bcp.app.repository.CambioMonedaRepository;
import com.bcp.app.repository.CatalogoRepository;
import com.bcp.app.util.Constantes;

import rx.Single;


@Service
public class TipoCambioServiceImpl implements  TipoCambioService {
	
	@Autowired
	private CatalogoRepository catalogoRepository;
	
	@Autowired
	private CambioMonedaRepository cambioMonedaRepository;
	
	@Override
	public List<Catalogo> listaCatalogo(){
		List<Catalogo> listCatalogo = new ArrayList<>();
		Iterator<Catalogo> it =  catalogoRepository.findAll().iterator();
		it.forEachRemaining(listCatalogo::add);
		return listCatalogo;
	}
	
	
	
	@Override
	public  Single<ResponseCambio> cambioMonedaRx(RequestCambio request) {
		
        String transacc=request.getMonedaOrigen().equals(Constantes.MONEDA.SOLES)?Constantes.EVENTO.COMPRA:Constantes.EVENTO.VENTA;		
		String moneda=request.getMonedaOrigen().equals(Constantes.MONEDA.SOLES)?request.getMonedaDestino():request.getMonedaOrigen();
		ResponseCambio response=new ResponseCambio();
		//List<CambioMoneda> cambio = cambioMonedaRepository.consultaCambioMoneda(transacc, moneda);
		return Single.create(singleSubscriber -> {
			List<CambioMoneda> cambio = cambioMonedaRepository.consultaCambioMoneda(transacc, moneda);
            if (cambio==null || cambio.isEmpty())            	
                singleSubscriber.onError(new EntityNotFoundException());
            else {            	
            	BigDecimal valorCambio=cambio.get(0).getValorMoneda();
    			BigDecimal valorMonto=request.getMonto();
    			BigDecimal valorMontoTotal=valorCambio.multiply(valorMonto);
    			response.setMonedaDestino(request.getMonedaDestino());
    			response.setMonedaOrigen(request.getMonedaOrigen());
    			response.setTipoCambio(valorCambio);
    			response.setMonto(valorMonto);
    			response.setMontoTipoCambio(valorMontoTotal);  
    			response.setMsg("exitoso");
                singleSubscriber.onSuccess(response);
            }
        });
		
		
		
		//return Single.just(response);
	}
	
	@Override
	public CambioMoneda insertUpdateTipoCambio(CambioMoneda request) {
		LocalDateTime date = LocalDateTime.now();
		request.setFechaActualizacion(date.toString());
		return cambioMonedaRepository.save(request);
	}



	
}
