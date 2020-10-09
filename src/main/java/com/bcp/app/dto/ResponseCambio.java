package com.bcp.app.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
public class ResponseCambio implements Serializable {
	
	private BigDecimal monto;
	private BigDecimal montoTipoCambio;
	private String monedaOrigen;
	private String monedaDestino;
	private BigDecimal tipoCambio;
	private String msg;
}
