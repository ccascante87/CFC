package com.cfc.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the MONEDA database table.
 * 
 */
@Entity
@NamedQuery(name="Moneda.findAll", query="SELECT m FROM Moneda m")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Moneda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String descripcion;

	private String simbolo;


	@OneToMany(mappedBy="moneda", fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<SucursalMontoMoneda> sucursalMontoMonedas;

	@OneToMany(mappedBy="moneda", fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<SucursalPorcent> sucursalPorcents;
	
	public Moneda() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSimbolo() {
		return this.simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public Set<SucursalMontoMoneda> getSucursalMontoMonedas() {
		return sucursalMontoMonedas;
	}

	public void setSucursalMontoMonedas(Set<SucursalMontoMoneda> sucursalMontoMonedas) {
		this.sucursalMontoMonedas = sucursalMontoMonedas;
	}

	public Set<SucursalPorcent> getSucursalPorcents() {
		return sucursalPorcents;
	}

	public void setSucursalPorcents(Set<SucursalPorcent> sucursalPorcents) {
		this.sucursalPorcents = sucursalPorcents;
	}

}