/**
 * 
 */
package com.cfc.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author JIO
 *
 */
public class Detalle {
	
	private Timestamp fecha;
	
	private BigDecimal saldo;
	
	private BigDecimal rm;
	
	private BigDecimal ocioso ;
	
	private BigDecimal reserva;

	private BigDecimal menudo;

	/**
	 * @return the fecha
	 */
	public Timestamp getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the saldo
	 */
	public BigDecimal getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	/**
	 * @return the rm
	 */
	public BigDecimal getRm() {
		return rm;
	}

	/**
	 * @param rm the rm to set
	 */
	public void setRm(BigDecimal rm) {
		this.rm = rm;
	}

	/**
	 * @return the ocioso
	 */
	public BigDecimal getOcioso() {
		return ocioso;
	}

	/**
	 * @param ocioso the ocioso to set
	 */
	public void setOcioso(BigDecimal ocioso) {
		this.ocioso = ocioso;
	}

	/**
	 * @return the reserva
	 */
	public BigDecimal getReserva() {
		return reserva;
	}

	/**
	 * @param reserva the reserva to set
	 */
	public void setReserva(BigDecimal reserva) {
		this.reserva = reserva;
	}

	/**
	 * @return the menudo
	 */
	public BigDecimal getMenudo() {
		return menudo;
	}

	/**
	 * @param menudo the menudo to set
	 */
	public void setMenudo(BigDecimal menudo) {
		this.menudo = menudo;
	}
}
