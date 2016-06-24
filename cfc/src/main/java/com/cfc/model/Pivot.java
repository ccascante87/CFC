/**
 * 
 */
package com.cfc.model;

/**
 * @author JIO
 *
 */
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the PIVOT database table.
 * 
 */
@Entity
@NamedQuery(name="Pivot.findAll", query="SELECT p FROM Pivot p")
public class Pivot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="COD_AGENCIA")
	private BigDecimal codAgencia;

	@Column(name="COD_MONEDA")
	private BigDecimal codMoneda;

	private Timestamp fecha;

	private BigDecimal lcir;

	private BigDecimal lcix;

	private BigDecimal lcr;

	private BigDecimal lcsr;

	private BigDecimal lcsx;

	private BigDecimal lcx;

	private BigDecimal menudo;

	private BigDecimal ocioso;

	@Column(name="PUNTO_REORDEN")
	private BigDecimal puntoReorden;

	private BigDecimal reserva;

	private BigDecimal rm;

	private BigDecimal saldo;

	@Column(name="SALDO_AUTORIZADO")
	private BigDecimal saldoAutorizado;

	@Column(name="SEGURO_MAX")
	private BigDecimal seguroMax;

	private BigDecimal utilizacion;

	public Pivot() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getCodAgencia() {
		return this.codAgencia;
	}

	public void setCodAgencia(BigDecimal codAgencia) {
		this.codAgencia = codAgencia;
	}

	public BigDecimal getCodMoneda() {
		return this.codMoneda;
	}

	public void setCodMoneda(BigDecimal codMoneda) {
		this.codMoneda = codMoneda;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getLcir() {
		return this.lcir;
	}

	public void setLcir(BigDecimal lcir) {
		this.lcir = lcir;
	}

	public BigDecimal getLcix() {
		return this.lcix;
	}

	public void setLcix(BigDecimal lcix) {
		this.lcix = lcix;
	}

	public BigDecimal getLcr() {
		return this.lcr;
	}

	public void setLcr(BigDecimal lcr) {
		this.lcr = lcr;
	}

	public BigDecimal getLcsr() {
		return this.lcsr;
	}

	public void setLcsr(BigDecimal lcsr) {
		this.lcsr = lcsr;
	}

	public BigDecimal getLcsx() {
		return this.lcsx;
	}

	public void setLcsx(BigDecimal lcsx) {
		this.lcsx = lcsx;
	}

	public BigDecimal getLcx() {
		return this.lcx;
	}

	public void setLcx(BigDecimal lcx) {
		this.lcx = lcx;
	}

	public BigDecimal getMenudo() {
		return this.menudo;
	}

	public void setMenudo(BigDecimal menudo) {
		this.menudo = menudo;
	}

	public BigDecimal getOcioso() {
		return this.ocioso;
	}

	public void setOcioso(BigDecimal ocioso) {
		this.ocioso = ocioso;
	}

	public BigDecimal getPuntoReorden() {
		return this.puntoReorden;
	}

	public void setPuntoReorden(BigDecimal puntoReorden) {
		this.puntoReorden = puntoReorden;
	}

	public BigDecimal getReserva() {
		return this.reserva;
	}

	public void setReserva(BigDecimal reserva) {
		this.reserva = reserva;
	}

	public BigDecimal getRm() {
		return this.rm;
	}

	public void setRm(BigDecimal rm) {
		this.rm = rm;
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public BigDecimal getSaldoAutorizado() {
		return this.saldoAutorizado;
	}

	public void setSaldoAutorizado(BigDecimal saldoAutorizado) {
		this.saldoAutorizado = saldoAutorizado;
	}

	public BigDecimal getSeguroMax() {
		return this.seguroMax;
	}

	public void setSeguroMax(BigDecimal seguroMax) {
		this.seguroMax = seguroMax;
	}

	public BigDecimal getUtilizacion() {
		return this.utilizacion;
	}

	public void setUtilizacion(BigDecimal utilizacion) {
		this.utilizacion = utilizacion;
	}

}