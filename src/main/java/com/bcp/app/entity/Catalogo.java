package com.bcp.app.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalIdCache;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity(name = "Catalogo")
@Table(name = "CATALOGO")
@NaturalIdCache
public class Catalogo implements Serializable {

private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true)	
	private int id;

	@Column(name = "GRUPO")
	private String grupo;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "CODIGO")
	private String codigo;
}
