package com.cfc.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the SUCURSAL_PORCENT database table.
 * 
 */
@Entity
@Table(name="SUCURSAL_PORCENT")
@NamedQuery(name="SucursalPorcent.findAll", query="SELECT s FROM SucursalPorcent s")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class SucursalPorcent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private BigDecimal id;

	

	@Column(name="PORCEN_MENUDO")
	private BigDecimal porcenMenudo;

	@Column(name="PORCEN_RESERVA")
	private BigDecimal porcenReserva;

	//bi-directional many-to-one association to Sucursale
	@ManyToOne
	@JoinColumn(name="ID_SUCURSAL")
	private Sucursal sucursal;
	
	@ManyToOne
	@JoinColumn(name="ID_MONEDA")
	private Moneda moneda;


	public SucursalPorcent() {
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	

	public BigDecimal getPorcenMenudo() {
		return this.porcenMenudo;
	}

	public void setPorcenMenudo(BigDecimal porcenMenudo) {
		this.porcenMenudo = porcenMenudo;
	}

	public BigDecimal getPorcenReserva() {
		return this.porcenReserva;
	}

	public void setPorcenReserva(BigDecimal porcenReserva) {
		this.porcenReserva = porcenReserva;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}
	

}