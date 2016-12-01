package com.cfc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "PARAMETERS" database table.
 * 
 */
@Entity
@Table(name="PARAMETERS")
public class Parametros implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="PARAM_KEY")
	private String paramKey;

	@Column(name="PARAM_VALUE")
	private String paramValue;

	@Column(name="SHORT_DESC")
	private String shortDesc;

	public Parametros() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getParamKey() {
		return this.paramKey;
	}

	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}

	public String getParamValue() {
		return this.paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	public String getShortDesc() {
		return this.shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

}