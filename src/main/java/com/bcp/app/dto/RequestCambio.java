package com.bcp.app.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
public class RequestCambio implements Serializable {

	private BigDecimal monto;
	private String monedaOrigen;
	private String monedaDestino;
	
	
}
