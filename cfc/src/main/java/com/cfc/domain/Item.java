package com.cfc.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Item implements Serializable {
		
	private static final long serialVersionUID = 1L;
	private String label = "";
	private Object value = null;
	private Object lastValue = null;

	public Item(String label, Object value, Object lastValue) {
		super();
		this.label = label;
		this.value = value;
		this.lastValue = lastValue;
	}

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	public Object getLastValue() {
		return lastValue;
	}
	public void setLastValue(Object lastValue) {
		this.lastValue = lastValue;
	}

}
