package com.cfc.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Forecast implements Serializable{

	private static final long serialVersionUID = 1L;
	private BigDecimal byDayToday = BigDecimal.ZERO;
	private BigDecimal byDayTomorrow = BigDecimal.ZERO;
	private BigDecimal byDateToday = BigDecimal.ZERO;
	private BigDecimal byDateTomorrow = BigDecimal.ZERO;
	
	public Forecast() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getByDayToday() {
		return byDayToday;
	}

	public void setByDayToday(BigDecimal byDayToday) {
		this.byDayToday = byDayToday;
	}

	public BigDecimal getByDayTomorrow() {
		return byDayTomorrow;
	}

	public void setByDayTomorrow(BigDecimal byDayTomorrow) {
		this.byDayTomorrow = byDayTomorrow;
	}

	public BigDecimal getByDateToday() {
		return byDateToday;
	}

	public void setByDateToday(BigDecimal byDateToday) {
		this.byDateToday = byDateToday;
	}

	public BigDecimal getByDateTomorrow() {
		return byDateTomorrow;
	}

	public void setByDateTomorrow(BigDecimal byDateTomorrow) {
		this.byDateTomorrow = byDateTomorrow;
	}
}
