package com.bcp.app.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalIdCache;



import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity(name = "CambioMoneda")
@Table(name = "CAMBIO_MONEDA")
@DynamicUpdate
@NaturalIdCache
public class CambioMoneda  implements Serializable {

private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true)	
	private int id;

	@Column(name = "CODIGO_MONEDA" ,nullable = false, updatable = false)
	private String codigoMoneda;
	
	@Column(name = "CODIGO_CAMBIO" ,nullable = false, updatable = false )
	private String codigoCambio;
	
	@Column(name = "VALOR" , nullable = false)
	private BigDecimal valorMoneda;
	
	@Column(name = "FECHA_ACTUALIZACION", nullable = false)
	private String fechaActualizacion;


}
