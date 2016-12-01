package com.cfc.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the SUCURSALES database table.
 * 
 */
@Entity
@Table(name="SUCURSALES")
@NamedQuery(name="Sucursal.findAll", query="SELECT s FROM Sucursal s")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Sucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="CODIGO_SUCURSAL")
	private BigDecimal codigoSucursal;

	@Column(name="HORA_APERTURA")
	private Timestamp horaApertura;

	@Column(name="HORA_CIERRE")
	private Timestamp horaCierre;

	@Column(name="NOM_SUCURSAL")
	private String nomSucursal;

	//bi-directional many-to-one association to SucursalMontoMoneda
	@OneToMany(mappedBy="sucursal", fetch=FetchType.EAGER, targetEntity=SucursalMontoMoneda.class)
	private Set<SucursalMontoMoneda> sucursalMontoMonedas=new HashSet<>();

	//bi-directional many-to-one association to SucursalPorcent
	@OneToMany(mappedBy="sucursal", fetch=FetchType.EAGER)
	private Set<SucursalPorcent> sucursalPorcents =new HashSet<>();

	public Sucursal() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getCodigoSucursal() {
		return this.codigoSucursal;
	}

	public void setCodigoSucursal(BigDecimal codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}

	public Timestamp getHoraApertura() {
		return this.horaApertura;
	}

	public void setHoraApertura(Timestamp horaApertura) {
		this.horaApertura = horaApertura;
	}

	public Timestamp getHoraCierre() {
		return this.horaCierre;
	}

	public void setHoraCierre(Timestamp horaCierre) {
		this.horaCierre = horaCierre;
	}

	public String getNomSucursal() {
		return this.nomSucursal;
	}

	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

	public Set<SucursalMontoMoneda> getSucursalMontoMonedas() {
		return this.sucursalMontoMonedas;
	}

	public void setSucursalMontoMonedas(Set<SucursalMontoMoneda> sucursalMontoMonedas) {
		this.sucursalMontoMonedas = sucursalMontoMonedas;
	}

	public Set<SucursalPorcent> getSucursalPorcents() {
		return this.sucursalPorcents;
	}

	public void setSucursalPorcents(Set<SucursalPorcent> sucursalPorcents) {
		this.sucursalPorcents = sucursalPorcents;
	}
}