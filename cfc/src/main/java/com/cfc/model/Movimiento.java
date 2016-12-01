package com.cfc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the MOVIMIENTOS database table.
 * 
 */
@Entity
@Table(name="MOVIMIENTOS")
@NamedQuery(name="Movimiento.findAll", query="SELECT m FROM Movimiento m")
public class Movimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="CLIENTE_EMPRESA")
	private String clienteEmpresa;

	@Column(name="CODIGO_AGENCIA")
	private BigDecimal codigoAgencia;

	@Column(name="CODIGO_EMPRESA")
	private BigDecimal codigoEmpresa;

	@Column(name="CODIGO_MONEDA")
	private BigDecimal codigoMoneda;

	@Column(name="CODIGO_REGION")
	private String codigoRegion;

	@Column(name="CODIGO_TIPO_TRANSACCION")
	private BigDecimal codigoTipoTransaccion;

	@Column(name="CODIGO_USUARIO")
	private BigDecimal codigoUsuario;

	@Column(name="DESC_TRANSACCION")
	private String descTransaccion;

	@Column(name="ENTRADA_SALIDA")
	private String entradaSalida;

	@Column(name="FECHA_VALIDA")
	private Timestamp fechaValida;

	@Column(name="HORA_MOVIMIENTO")
	private Timestamp horaMovimiento;

	@Column(name="MONTO_VALOR")
	private BigDecimal montoValor;

	@Column(name="NOM_AGENCIA")
	private String nomAgencia;

	@Column(name="NOM_REGION")
	private String nomRegion;

	@Column(name="NOM_USUARIO")
	private String nomUsuario;

	public Movimiento() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClienteEmpresa() {
		return this.clienteEmpresa;
	}

	public void setClienteEmpresa(String clienteEmpresa) {
		this.clienteEmpresa = clienteEmpresa;
	}

	public BigDecimal getCodigoAgencia() {
		return this.codigoAgencia;
	}

	public void setCodigoAgencia(BigDecimal codigoAgencia) {
		this.codigoAgencia = codigoAgencia;
	}

	public BigDecimal getCodigoEmpresa() {
		return this.codigoEmpresa;
	}

	public void setCodigoEmpresa(BigDecimal codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	public BigDecimal getCodigoMoneda() {
		return this.codigoMoneda;
	}

	public void setCodigoMoneda(BigDecimal codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}

	public String getCodigoRegion() {
		return this.codigoRegion;
	}

	public void setCodigoRegion(String codigoRegion) {
		this.codigoRegion = codigoRegion;
	}

	public BigDecimal getCodigoTipoTransaccion() {
		return this.codigoTipoTransaccion;
	}

	public void setCodigoTipoTransaccion(BigDecimal codigoTipoTransaccion) {
		this.codigoTipoTransaccion = codigoTipoTransaccion;
	}

	public BigDecimal getCodigoUsuario() {
		return this.codigoUsuario;
	}

	public void setCodigoUsuario(BigDecimal codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getDescTransaccion() {
		return this.descTransaccion;
	}

	public void setDescTransaccion(String descTransaccion) {
		this.descTransaccion = descTransaccion;
	}

	public String getEntradaSalida() {
		return this.entradaSalida;
	}

	public void setEntradaSalida(String entradaSalida) {
		this.entradaSalida = entradaSalida;
	}

	public Timestamp getFechaValida() {
		return this.fechaValida;
	}

	public void setFechaValida(Timestamp fechaValida) {
		this.fechaValida = fechaValida;
	}

	public Timestamp getHoraMovimiento() {
		return this.horaMovimiento;
	}

	public void setHoraMovimiento(Timestamp horaMovimiento) {
		this.horaMovimiento = horaMovimiento;
	}

	public BigDecimal getMontoValor() {
		return this.montoValor;
	}

	public void setMontoValor(BigDecimal montoValor) {
		this.montoValor = montoValor;
	}

	public String getNomAgencia() {
		return this.nomAgencia;
	}

	public void setNomAgencia(String nomAgencia) {
		this.nomAgencia = nomAgencia;
	}

	public String getNomRegion() {
		return this.nomRegion;
	}

	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}

	public String getNomUsuario() {
		return this.nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

}