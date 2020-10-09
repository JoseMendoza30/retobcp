package com.bcp.app.service;

import java.util.List;

import com.bcp.app.dto.RequestCambio;
import com.bcp.app.dto.ResponseCambio;
import com.bcp.app.entity.CambioMoneda;
import com.bcp.app.entity.Catalogo;

import rx.Single;

public interface TipoCambioService {

	List<Catalogo> listaCatalogo();

	CambioMoneda insertUpdateTipoCambio(CambioMoneda request);


	Single<ResponseCambio> cambioMonedaRx(RequestCambio request);

}
